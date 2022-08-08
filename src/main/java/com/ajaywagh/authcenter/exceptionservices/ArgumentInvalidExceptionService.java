package com.ajaywagh.authcenter.exceptionservices;

import com.ajaywagh.authcenter.responsemodels.Error;
import com.ajaywagh.authcenter.responsemodels.ErrorCode;
import com.ajaywagh.authcenter.responsemodels.Response;
import com.ajaywagh.authcenter.responsemodels.Success;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Service
public class ArgumentInvalidExceptionService {
    public ResponseEntity<Object> handleException(MethodArgumentNotValidException exception){
        Response response=new Response();
        response.setSuccess(Success.FALSE);
        StringBuilder builder=new StringBuilder();
        exception.getAllErrors().forEach(err->{
            builder.append(err.getDefaultMessage()).append(" ");});
        response.setError(new Error(ErrorCode.INVALID_REQUEST, builder.toString()));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
