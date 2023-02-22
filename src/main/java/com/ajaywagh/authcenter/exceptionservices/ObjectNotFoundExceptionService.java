package com.ajaywagh.authcenter.exceptionservices;

import com.ajaywagh.authcenter.exceptions.ObjectNotFoundException;
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
public class ObjectNotFoundExceptionService {

    public ResponseEntity<Response> handleException(ObjectNotFoundException objectNotFoundException){
        Response response=new Response();
        response.setSuccess(Success.FALSE);
        response.setError(new Error(ErrorCode.OBJECT_NOT_FOUND, objectNotFoundException.getMessage()));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
