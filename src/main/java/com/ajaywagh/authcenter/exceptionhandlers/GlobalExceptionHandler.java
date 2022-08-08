package com.ajaywagh.authcenter.exceptionhandlers;

import com.ajaywagh.authcenter.exceptions.InvalidCredentialsException;
import com.ajaywagh.authcenter.exceptions.InvalidHeaderException;
import com.ajaywagh.authcenter.exceptionservices.*;
import com.ajaywagh.authcenter.responsemodels.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    GlobalExceptionService globalExceptionService;
    @Autowired
    InvalidCredentialsExceptionService invalidCredentialsExceptionService;
    @Autowired
    ArgumentInvalidExceptionService argumentInvalidExceptionService;
    @Autowired
    InvalidHeaderExceptionService invalidHeaderExceptionService;
    @Autowired
    MessageNotReadableExceptionService messageNotReadableExceptionService;

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<Response> handleInvalidCredentialsException(InvalidCredentialsException exception){
        return invalidCredentialsExceptionService.handleInvalidCredentialsException(exception);
    }

    @ExceptionHandler(InvalidHeaderException.class)
    public ResponseEntity<Response> handleInvalidHeaderException(InvalidHeaderException invalidHeaderException){
        return invalidHeaderExceptionService.handleInvalidHeaderException(invalidHeaderException);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleGlobalException(Exception exception){
        return globalExceptionService.handleException(exception);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return argumentInvalidExceptionService.handleException(ex);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return messageNotReadableExceptionService.handleException(ex);
    }
}
