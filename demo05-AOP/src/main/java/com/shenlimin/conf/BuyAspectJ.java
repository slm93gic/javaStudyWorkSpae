package com.shenlimin.conf;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Aspect
@Component
public class BuyAspectJ {

//    @Before("execution(* com.shenlimin.controller..*.*(..))")
//    @Pointcut("execution(public * com.shenlimin.service..*.*(..))")
    public void Pointcut() {
        System.out.println("男孩女孩都买自己喜欢的东西");
    }

}
