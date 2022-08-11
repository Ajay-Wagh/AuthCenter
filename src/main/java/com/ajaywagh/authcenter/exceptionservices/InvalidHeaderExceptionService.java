package com.ajaywagh.authcenter.exceptionservices;

import com.ajaywagh.authcenter.exceptions.InvalidHeaderException;
import com.ajaywagh.authcenter.responsemodels.Error;
import com.ajaywagh.authcenter.responsemodels.ErrorCode;
import com.ajaywagh.authcenter.responsemodels.Response;
import com.ajaywagh.authcenter.responsemodels.Success;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class InvalidHeaderExceptionService {
    Logger logger= LoggerFactory.getLogger(InvalidHeaderException.class);

    public ResponseEntity<Response> handleException(InvalidHeaderException e){
        logger.debug("Start handleException");
        Response response=new Response();
        response.setSuccess(Success.FALSE);
        response.setError(new Error(ErrorCode.INVALID_REQUEST, e.getMessage()));
        logger.debug("End handleException");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
