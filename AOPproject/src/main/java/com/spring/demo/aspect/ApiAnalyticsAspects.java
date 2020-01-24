package com.spring.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class ApiAnalyticsAspects {
    @Before("com.spring.demo.aspect.AopExpressions.performApiDao()")
    public void performApi() {
        System.out.println("\n=====>>>Performing API No with Getters or Setters");
    }
}
