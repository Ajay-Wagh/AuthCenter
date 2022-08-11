package com.ajaywagh.authcenter.exceptionservices;

import com.ajaywagh.authcenter.responsemodels.Error;
import com.ajaywagh.authcenter.responsemodels.ErrorCode;
import com.ajaywagh.authcenter.responsemodels.Response;
import com.ajaywagh.authcenter.responsemodels.Success;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Service
public class ArgumentInvalidExceptionService {

    Logger logger= LoggerFactory.getLogger(ArgumentInvalidExceptionService.class);

    public ResponseEntity<Object> handleException(MethodArgumentNotValidException exception){
        logger.debug("Start handleException");
        Response response=new Response();
        response.setSuccess(Success.FALSE);
        StringBuilder builder=new StringBuilder();
        exception.getAllErrors().forEach(err->{
            builder.append(err.getDefaultMessage()).append(" ");});
        response.setError(new Error(ErrorCode.INVALID_REQUEST, builder.toString()));
        logger.debug("End handleException");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
