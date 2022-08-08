package com.ajaywagh.authcenter.exceptions;

public class InvalidCredentialsException extends RuntimeException{

    public InvalidCredentialsException(){
        super("Invalid Credentials Provided");
    }
}
