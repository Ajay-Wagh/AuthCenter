package com.ajaywagh.authcenter.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MethodLogger {

    @Pointcut("@within(com.ajaywagh.authcenter.log.LoggedClass)")
    public void loggedClass(){}
    @Pointcut("@annotation(com.ajaywagh.authcenter.log.LoggedMethod)")
    public void loggedMethod(){}

    @Before("loggedClass() || loggedMethod()")
    public void adviceBefore(JoinPoint joinPoint){
        Signature signature=joinPoint.getSignature();
        log.debug("Start of method \"{}\" of class \"{}\"",signature.getName(),signature.getDeclaringTypeName());
    }

    @After("loggedClass() || loggedMethod()")
    public void adviceAfter(JoinPoint joinPoint){
        Signature signature=joinPoint.getSignature();
        log.debug("End of method \"{}\" of class \"{}\"",signature.getName(),signature.getDeclaringTypeName());
    }

    @AfterThrowing("loggedClass() || loggedMethod()")
    public void adviceAfterThrowing(JoinPoint joinPoint){
        Signature signature=joinPoint.getSignature();
        log.debug("Exception by method \"{}\" of class \"{}\"",signature.getName(),signature.getDeclaringTypeName());
    }
}
