package com.ajaywagh.authcenter.exceptionservices;

import com.ajaywagh.authcenter.exceptions.InvalidCredentialsException;
import com.ajaywagh.authcenter.responsemodels.Error;
import com.ajaywagh.authcenter.responsemodels.ErrorCode;
import com.ajaywagh.authcenter.responsemodels.Response;
import com.ajaywagh.authcenter.responsemodels.Success;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class InvalidCredentialsExceptionService {
    public ResponseEntity<Response> handleInvalidCredentialsException(InvalidCredentialsException exception){
        Response response=new Response();
        response.setSuccess(Success.FALSE);
        response.setError(new Error(ErrorCode.INVALID_CREDENTIALS, exception.getMessage()));
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
}
