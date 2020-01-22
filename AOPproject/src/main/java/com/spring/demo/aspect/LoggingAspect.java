package com.spring.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    //@Before("execution(* com.spring.demo.dao.*.*(..))")
    //any return type
    //any class, only from package com.spring.demo.dao.*
    //any method with any param type


    @Pointcut("execution(* com.spring.demo.dao.*.*(..))")
    private void forDAOPackage() {
    }

    @Before("forDAOPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>>Whenever ANY class or ANY method called from DAO Package");
    }

    @Before("forDAOPackage()&& !(setter() || getter())")
    public void performApi() {
        System.out.println("\n=====>>>Performing API with Getters or Setters");
    }

    @Pointcut("execution(* com.spring.demo.dao.*.get*(..))")
    private void getter() {
    }

    @Pointcut("execution(* com.spring.demo.dao.*.set*(..))")
    private void setter() {
    }

    @Before("setter()")
    public void forDaoPackageSetter() {
        System.out.println("Calling Setter..");
    }
    @Before("getter()")
    public void forDaoPackageGetter() {
        System.out.println("Calling Getter...");
    }
}
