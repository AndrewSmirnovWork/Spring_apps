package com.spring.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExpressions {


    @Pointcut("execution(* com.spring.demo.dao.*.*(..))")
    public void forDAOPackage() {
    }

    @Pointcut("execution(* com.spring.demo.dao.*.add*(..))")
    public void beforeAddDAOPackage() {
    }

    @Pointcut("execution(* com.spring.demo.dao.*.get*(..))")
    public void getter() {
    }

    @Pointcut("execution(* com.spring.demo.dao.*.set*(..))")
    public void setter() {
    }

    @Pointcut("forDAOPackage()&& !(setter() || getter())")
    public void performApiDao() {
    }

    @Pointcut("execution(* com.spring.demo.dao.*.add*(..))")
    public void afterAddForDaoPackage() {
    }
}


