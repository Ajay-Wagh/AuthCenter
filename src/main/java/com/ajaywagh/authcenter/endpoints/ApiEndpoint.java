package com.ajaywagh.authcenter.endpoints;

import com.ajaywagh.authcenter.interceptors.HeaderCheckInterceptor;
import com.ajaywagh.authcenter.log.audit.AuditLogger;
import com.ajaywagh.authcenter.log.audit.EntryOutcome;
import com.ajaywagh.authcenter.log.audit.EntryType;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class ApiEndpoint {

    public static final String OPERATION_FIELD_NAME="operation";

    //used to mask passwords from the logs
    public static final String[] REQUEST_MASKED_FIELD_POINTERS ={"/password","/newUserPassword"};
    public static final String[] RESPONSE_MASKED_FIELD_POINTERS={"/token"};
    public static final String[] DEFAULT_HEADERS_TO_REMOVE={"Content-Type","Transfer-Encoding","Date","Connection"};

    @Value("${app_local_path}")
    String APP_LOCAL_PATH;

    @Autowired
    AuditLogger auditLogger;

    final CloseableHttpClient httpclient = HttpClients.createDefault();
    final ObjectMapper objectMapper=new ObjectMapper();


    @RequestMapping(value = "/api",method = RequestMethod.POST)
    public ResponseEntity<String> incoming(@RequestBody JsonNode body, @RequestHeader Map<String,String> headers) throws Exception {

        logRequest(body,headers);

        String operationToPerform=extractOperation(body);

        CloseableHttpResponse response=callInternalApi(operationToPerform,headers,body);

        int resCode=response.getCode();
        HttpHeaders httpHeaders=extractHeaders(response);
        String responseString=extractResponseString(response);
        Pair<Integer, String> pair=handle404(resCode,responseString);
        logResponse(pair.getSecond(),httpHeaders,pair.getFirst());
        removeDefaultHeaders(httpHeaders);
        return new ResponseEntity<>(responseString,httpHeaders, resCode);
    }

    private Pair<Integer,String> handle404(int resCode, String responseString) {
        //-handle 404 as invalid operation specified...
        return Pair.of(resCode,responseString);
    }

    private void removeDefaultHeaders(HttpHeaders httpHeaders) {
        for (String header:DEFAULT_HEADERS_TO_REMOVE){
            httpHeaders.remove(header);
        }
    }

    private void logRequest(JsonNode body,Map<String,String> headers) throws Exception {
        String corrId;
        try {
            String passwordRemovedBody=removePasswords(body, REQUEST_MASKED_FIELD_POINTERS);
            log.info("Request : \n[Headers] \n {} \n[Body] \n {}", headers,passwordRemovedBody );
            corrId=headers.get(HeaderCheckInterceptor.CORR_HEADER_ID);
            auditLogger.log(corrId, headers.toString(),passwordRemovedBody, EntryType.REQUEST, EntryOutcome.UNKNOWN);

        }catch (Exception e){
            log.error("Error while Auditing");
            throw new Exception("Error while auditing request... Check ApiEndpoint.java");
        }
    }

    private String extractOperation(JsonNode body){
        String operation="operation_value_not_found..";

        if(body.get(OPERATION_FIELD_NAME)!=null && body.get(OPERATION_FIELD_NAME).isValueNode()){
            operation=body.get(OPERATION_FIELD_NAME).textValue();
        }

        return operation;
    }

    private CloseableHttpResponse callInternalApi(String operation,Map<String,String> headers,JsonNode body) throws IOException {
        HttpPost httpPost = new HttpPost(APP_LOCAL_PATH + operation);
        headers.remove("content-length");
        headers.forEach(httpPost::setHeader);
        httpPost.setHeader(HeaderCheckInterceptor.INTEGRITY_KEY_HEADER_ID,HeaderCheckInterceptor.INTEGRITY_KEY);
        httpPost.setEntity(new StringEntity(body.toString()));
        return httpclient.execute(httpPost);
    }

    private HttpHeaders extractHeaders(CloseableHttpResponse response){
        HttpHeaders resHeaders=new HttpHeaders();
        for(Header header: response.getHeaders()){
            resHeaders.set(header.getName(), header.getValue());
        }
        return resHeaders;
    }

    private String extractResponseString(CloseableHttpResponse response) throws IOException {
        org.apache.hc.core5.http.HttpEntity entity = response.getEntity();
        String res=new String(entity.getContent().readAllBytes(), StandardCharsets.UTF_8);
        EntityUtils.consume(entity);
        return res;
    }

    private String removePasswords(JsonNode input,String[] pointers){
        log.debug("start method removePasswords (from log message)");
        JsonNode copy=input.deepCopy();

        for(String pointer: pointers){
            String field=pointer.substring(pointer.lastIndexOf(JsonPointer.SEPARATOR)+1);
            String parent=pointer.substring(0,pointer.lastIndexOf(JsonPointer.SEPARATOR));
            JsonPointer parentJsonPointer=JsonPointer.compile(parent);
            JsonNode parentJsonNode=copy.at(parentJsonPointer);
            if (!parentJsonNode.isMissingNode() && parentJsonNode.isObject()) {
                ObjectNode parentObjectNode = (ObjectNode) parentJsonNode;
                JsonNode fieldValueNode = parentObjectNode.get(field);
                if(fieldValueNode != null) {
                    parentObjectNode.put(field, "<masked>");
                }
            }else {
                log.error("Parent Json node is missing or is not an object");
            }
        }

        log.debug("end method removePasswords (from log message)");
        return copy.toString();
    }

    private void logResponse(String response,HttpHeaders headers, int statusCode) throws Exception {
        try {
            String passwordRemovedRes=removePasswords(objectMapper.readTree(response),RESPONSE_MASKED_FIELD_POINTERS);
            log.info("Response : \n[Headers] \n {} \n[Body] \n {}", headers,passwordRemovedRes );
            List<String> list=headers.get(HeaderCheckInterceptor.CORR_HEADER_ID);
            String corrId="";
            if(list!=null && list.size()>=1){
                corrId=list.get(0);
            }
            log.debug("Response Corr Id is {}",corrId);

            EntryOutcome entryOutcome;
            if(org.apache.hc.core5.http.HttpStatus.SC_OK==statusCode)
                entryOutcome=EntryOutcome.SUCCESS;
            else
                entryOutcome=EntryOutcome.FAILED;

            auditLogger.log(corrId, headers.toString(),passwordRemovedRes, EntryType.RESPONSE, entryOutcome);

        }catch (Exception e){
            log.error("Error while Auditing");
            throw new Exception("Error while auditing response... Check ApiEndpoint.java");
        }
    }

}
