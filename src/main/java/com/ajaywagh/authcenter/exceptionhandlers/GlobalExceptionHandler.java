package com.ajaywagh.authcenter.exceptionhandlers;

import com.ajaywagh.authcenter.exceptions.AccessDeniedException;
import com.ajaywagh.authcenter.exceptions.InvalidCredentialsException;
import com.ajaywagh.authcenter.exceptions.InvalidHeaderException;
import com.ajaywagh.authcenter.exceptionservices.*;
import com.ajaywagh.authcenter.responsemodels.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.NonNull;
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
    @Autowired
    AccessDeniedExceptionService accessDeniedExceptionService;

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<Response> handleInvalidCredentialsException(InvalidCredentialsException exception){
        return invalidCredentialsExceptionService.handleException(exception);
    }

    @ExceptionHandler(InvalidHeaderException.class)
    public ResponseEntity<Response> handleInvalidHeaderException(InvalidHeaderException invalidHeaderException){
        return invalidHeaderExceptionService.handleException(invalidHeaderException);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Response> handleAccessDeniedException(AccessDeniedException accessDeniedException){
        return accessDeniedExceptionService.handleException(accessDeniedException);
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleGlobalException(Exception exception){
        return globalExceptionService.handleException(exception);
    }

    @Override
    @NonNull
    protected ResponseEntity<Object> handleMethodArgumentNotValid(@NonNull MethodArgumentNotValidException ex, @NonNull HttpHeaders headers, @NonNull HttpStatus status, @NonNull WebRequest request) {
        return argumentInvalidExceptionService.handleException(ex);
    }

    @Override
    @NonNull
    protected ResponseEntity<Object> handleHttpMessageNotReadable(@NonNull HttpMessageNotReadableException ex, @NonNull HttpHeaders headers, @NonNull HttpStatus status, @NonNull WebRequest request) {
        return messageNotReadableExceptionService.handleException(ex);
    }
}
