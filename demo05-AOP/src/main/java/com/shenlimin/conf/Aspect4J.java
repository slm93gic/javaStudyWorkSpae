package com.shenlimin.conf;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class Aspect4J {

    @Pointcut("execution(public * com.shenlimin.controller..*.*(..))")
    public void Pointcut() {

    }

    //前置通知
    @Before("Pointcut()")
    public void beforeMethod(JoinPoint joinPoint) {
        log.info("调用了前置通知");
    }

    //@After: 后置通知
    @After("Pointcut()")
    public void afterMethod(JoinPoint joinPoint) {
        log.info("调用了后置通知");
    }

}
