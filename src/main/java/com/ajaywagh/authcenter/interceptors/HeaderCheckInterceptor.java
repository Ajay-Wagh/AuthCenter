package com.ajaywagh.authcenter.interceptors;

import com.ajaywagh.authcenter.exceptions.AccessDeniedException;
import com.ajaywagh.authcenter.exceptions.InvalidHeaderException;
import com.ajaywagh.authcenter.log.LoggedClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@LoggedClass
@Slf4j
public class HeaderCheckInterceptor implements HandlerInterceptor {

    public static final int CORR_ID_MIN_SIZE=5;
    public static final int CORR_ID_MAX_SIZE=15;
    public static final String CORR_HEADER_ID="correlationid";
    public static final String INTEGRITY_KEY_HEADER_ID="integritykey";
    public static final String INTEGRITY_KEY="qwerQWER124578";


    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        checkHeaders(request);
        addCorrIdToResponseHeader(request,response);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }




    private void checkHeaders(HttpServletRequest request) throws InvalidHeaderException, AccessDeniedException {
        log.debug("start of checkHeaders");
        checkCorrId(request.getHeader(CORR_HEADER_ID));
        checkIntegrity(request);
        log.debug("end of checkHeaders");
    }

    private void checkCorrId(String corrId) throws InvalidHeaderException {
        log.debug("start of checkCorrId");
        if(corrId==null)
            throw new InvalidHeaderException(CORR_HEADER_ID+" in the header is required");
        else if(corrId.length()<CORR_ID_MIN_SIZE || corrId.length()>CORR_ID_MAX_SIZE)
            throw new InvalidHeaderException(CORR_HEADER_ID+" should have minimum "+
                    CORR_ID_MIN_SIZE+" and maximum "+CORR_ID_MAX_SIZE+" characters");
        log.debug("end of checkCorrId");
    }

    private void addCorrIdToResponseHeader(HttpServletRequest request, HttpServletResponse response){
        log.debug("start of addCorrIdToResponseHeader");
        response.setHeader(CORR_HEADER_ID, request.getHeader(CORR_HEADER_ID));
        log.debug("end of addCorrIdToResponseHeader");
    }

    private void checkIntegrity(HttpServletRequest request) throws AccessDeniedException {
        log.debug("start of checkIntegrity");
        String key=request.getHeader(INTEGRITY_KEY_HEADER_ID);

        if(!request.getRemoteAddr().equals("127.0.0.1")|| key==null || !key.equals(INTEGRITY_KEY)){
            throw new AccessDeniedException("Access Denied");
        }
        log.debug("end of checkIntegrity");
    }
}
