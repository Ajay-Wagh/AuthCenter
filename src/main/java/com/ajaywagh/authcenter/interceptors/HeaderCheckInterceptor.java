package com.ajaywagh.authcenter.interceptors;

import com.ajaywagh.authcenter.exceptions.InvalidHeaderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class HeaderCheckInterceptor implements HandlerInterceptor {

    public static final int CORR_ID_MIN_SIZE=5;
    public static final int CORR_ID_MAX_SIZE=15;
    public static final String CORR_HEADER_ID="CorrelationId";

    Logger logger= LoggerFactory.getLogger(HeaderCheckInterceptor.class);

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        logger.debug("Start preHandle");
        checkHeaders(request);
        addCorrIdToResponseHeader(request,response);
        logger.debug("End preHandle");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }




    private void checkHeaders(HttpServletRequest request) throws InvalidHeaderException {
        logger.debug("Start checkHeaders");
        checkCorrId(request.getHeader(CORR_HEADER_ID));
        logger.debug("End checkHeaders");
    }

    private void checkCorrId(String corrId) throws InvalidHeaderException {
        logger.debug("Start checkCorrId");
        if(corrId==null)
            throw new InvalidHeaderException(CORR_HEADER_ID+" in the header is required");
        else if(corrId.length()<CORR_ID_MIN_SIZE || corrId.length()>CORR_ID_MAX_SIZE)
            throw new InvalidHeaderException(CORR_HEADER_ID+" should have minimum "+
                    CORR_ID_MIN_SIZE+" and maximum "+CORR_ID_MAX_SIZE+" characters");
        logger.debug("End checkHeaders");
    }

    private void addCorrIdToResponseHeader(HttpServletRequest request, HttpServletResponse response){
        logger.debug("Start addCorrIdToResponseHeader");
        response.setHeader(CORR_HEADER_ID, request.getHeader(CORR_HEADER_ID));
        logger.debug("End addCorrIdToResponseHeader");
    }
}
