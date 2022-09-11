package com.ajaywagh.authcenter.endpoints;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping(value = "/api",method = RequestMethod.POST)
public class ApiEndpoint {

    public static final String OPERATION_FIELD_NAME="operation";

    @Value("${app_local_path}")
    String APP_LOCAL_PATH;

    final WebClient webClient=WebClient.create(APP_LOCAL_PATH);


    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String incoming(@RequestBody JsonNode node, @RequestHeader Map<String,String> headers){
        log.info("New Request : \n[Headers] \n {} \n[Body] \n {}",headers,node);


        return webClient.post()
                .uri(node.get(OPERATION_FIELD_NAME).textValue())
                .bodyValue(node)
                .retrieve()
                .bodyToMono(String.class).block();
    }
}
