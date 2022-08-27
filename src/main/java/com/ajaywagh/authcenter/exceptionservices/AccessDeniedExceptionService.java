package com.ajaywagh.authcenter.exceptionservices;

import com.ajaywagh.authcenter.exceptions.AccessDeniedException;
import com.ajaywagh.authcenter.log.LoggedClass;
import com.ajaywagh.authcenter.responsemodels.Error;
import com.ajaywagh.authcenter.responsemodels.ErrorCode;
import com.ajaywagh.authcenter.responsemodels.Response;
import com.ajaywagh.authcenter.responsemodels.Success;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@LoggedClass
public class AccessDeniedExceptionService {
    public ResponseEntity<Response> handleException(AccessDeniedException exception){
        Response response=new Response();
        response.setSuccess(Success.FALSE);
        response.setError(new Error(ErrorCode.ACCESS_DENIED, exception.getMessage()));
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }
}
