package com.ajaywagh.authcenter.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodLogger {

    Logger logger= LoggerFactory.getLogger(MethodLogger.class);

    @Pointcut("@within(com.ajaywagh.authcenter.log.LoggedClass)")
    public void loggedClass(){}
    @Pointcut("@annotation(com.ajaywagh.authcenter.log.LoggedMethod)")
    public void loggedMethod(){}

    @Before("loggedClass() || loggedMethod()")
    public void adviceBefore(JoinPoint joinPoint){
        Signature signature=joinPoint.getSignature();
        logger.debug("Start of method \"{}\" of class \"{}\"",signature.getName(),signature.getDeclaringTypeName());
    }

    @After("loggedClass() || loggedMethod()")
    public void adviceAfter(JoinPoint joinPoint){
        Signature signature=joinPoint.getSignature();
        logger.debug("End of method \"{}\" of class \"{}\"",signature.getName(),signature.getDeclaringTypeName());
    }

    @AfterThrowing("loggedClass() || loggedMethod()")
    public void adviceAfterThrowing(JoinPoint joinPoint){
        Signature signature=joinPoint.getSignature();
        logger.debug("Exception by method \"{}\" of class \"{}\"",signature.getName(),signature.getDeclaringTypeName());
    }
}
