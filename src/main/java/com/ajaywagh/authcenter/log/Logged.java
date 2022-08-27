package com.ajaywagh.authcenter.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logged {

    @Pointcut("@within(com.ajaywagh.authcenter.log.LoggedClass)")
    public void loggedClass(){}
    @Pointcut("@annotation(com.ajaywagh.authcenter.log.LoggedMethod)")
    public void loggedMethod(){}

    @Before("loggedClass() || loggedMethod()")
    public void adviceBefore(JoinPoint joinPoint){

    }

    @After("loggedClass() || loggedMethod()")
    public void adviceAfter(JoinPoint joinPoint){

    }

    @AfterThrowing("loggedClass() || loggedMethod()")
    public void adviceAfterThrowing(JoinPoint joinPoint){

    }
}
