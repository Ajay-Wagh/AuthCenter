package com.ajaywagh.authcenter.interceptors;

import com.ajaywagh.authcenter.exceptions.InvalidHeaderException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class HeaderCheckInterceptor implements HandlerInterceptor {

    public static final int CORR_ID_MIN_SIZE=5;
    public static final int CORR_ID_MAX_SIZE=15;
    public static final String CORR_HEADER_ID="CorrelationId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        checkHeaders(request);
        addCorrIdToResponseHeader(request,response);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }




    private void checkHeaders(HttpServletRequest request) throws InvalidHeaderException {
        checkCorrId(request.getHeader(CORR_HEADER_ID));
    }

    private void checkCorrId(String corrId) throws InvalidHeaderException {
        if(corrId==null)
            throw new InvalidHeaderException(CORR_HEADER_ID+" in the header is required");
        else if(corrId.length()<CORR_ID_MIN_SIZE || corrId.length()>CORR_ID_MAX_SIZE)
            throw new InvalidHeaderException(CORR_HEADER_ID+" should have minimum "+CORR_ID_MIN_SIZE+" and maximum "+CORR_ID_MAX_SIZE+" characters");
    }

    private void addCorrIdToResponseHeader(HttpServletRequest request, HttpServletResponse response){
        response.setHeader(CORR_HEADER_ID, request.getHeader(CORR_HEADER_ID));
    }
}
