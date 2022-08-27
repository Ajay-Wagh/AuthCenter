package com.ajaywagh.authcenter.interceptors;

import com.ajaywagh.authcenter.exceptions.InvalidHeaderException;
import com.ajaywagh.authcenter.log.LoggedClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.AccessDeniedException;

@Component
@LoggedClass
public class HeaderCheckInterceptor implements HandlerInterceptor {

    public static final int CORR_ID_MIN_SIZE=5;
    public static final int CORR_ID_MAX_SIZE=15;
    public static final String CORR_HEADER_ID="CorrelationId";
    public static final String INTEGRITY_KEY_HEADER_ID="IntegrityKey";
    public static final String INTEGRITY_KEY="qwerQWER124578";


    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        checkHeaders(request);
        addCorrIdToResponseHeader(request,response);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }




    private void checkHeaders(HttpServletRequest request) throws InvalidHeaderException, AccessDeniedException {
        checkCorrId(request.getHeader(CORR_HEADER_ID));
        checkIntegrity(request);
    }

    private void checkCorrId(String corrId) throws InvalidHeaderException {
        if(corrId==null)
            throw new InvalidHeaderException(CORR_HEADER_ID+" in the header is required");
        else if(corrId.length()<CORR_ID_MIN_SIZE || corrId.length()>CORR_ID_MAX_SIZE)
            throw new InvalidHeaderException(CORR_HEADER_ID+" should have minimum "+
                    CORR_ID_MIN_SIZE+" and maximum "+CORR_ID_MAX_SIZE+" characters");
    }

    private void addCorrIdToResponseHeader(HttpServletRequest request, HttpServletResponse response){
        response.setHeader(CORR_HEADER_ID, request.getHeader(CORR_HEADER_ID));
    }

    private void checkIntegrity(HttpServletRequest request) throws AccessDeniedException {
        System.out.println(request.getRemoteAddr());
        if(!request.getRemoteAddr().equals("127.0.0.1") || !request.getHeader(INTEGRITY_KEY_HEADER_ID).equals(INTEGRITY_KEY)){
            throw new AccessDeniedException("Access Denied");
        }
    }
}
