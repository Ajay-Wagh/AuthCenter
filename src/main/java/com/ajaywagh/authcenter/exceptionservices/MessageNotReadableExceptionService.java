package com.ajaywagh.authcenter.exceptionservices;

import com.ajaywagh.authcenter.responsemodels.Error;
import com.ajaywagh.authcenter.responsemodels.ErrorCode;
import com.ajaywagh.authcenter.responsemodels.Response;
import com.ajaywagh.authcenter.responsemodels.Success;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

@Service
public class MessageNotReadableExceptionService {
    public static final int MESSAGE_TRUNCATE_LENGTH =60;
    Logger logger=LoggerFactory.getLogger(MessageNotReadableExceptionService.class);

    public ResponseEntity<Object> handleException(HttpMessageNotReadableException exception){
        logger.debug("Start handleException");
        Response response=new Response();
        response.setSuccess(Success.FALSE);
        response.setError(new Error(ErrorCode.INVALID_REQUEST, exception.getLocalizedMessage().substring(0, MESSAGE_TRUNCATE_LENGTH)+"...truncated"));
        logger.debug("End handleException");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
