package com.ajaywagh.authcenter.exceptionservices;

import com.ajaywagh.authcenter.log.LoggedClass;
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
@LoggedClass
public class MessageNotReadableExceptionService {
    public static final int MESSAGE_TRUNCATE_LENGTH =60;

    public ResponseEntity<Object> handleException(HttpMessageNotReadableException exception){
        Response response=new Response();
        response.setSuccess(Success.FALSE);
        response.setError(new Error(ErrorCode.INVALID_REQUEST, exception.getLocalizedMessage().substring(0, MESSAGE_TRUNCATE_LENGTH)+"...truncated"));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
