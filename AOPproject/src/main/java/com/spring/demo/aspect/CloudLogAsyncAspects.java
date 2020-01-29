package com.spring.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
@EnableAspectJAutoProxy
public class CloudLogAsyncAspects {

    @Before("com.spring.demo.aspect.AopExpressions.forDAOPackage()")
    public void logToCloudAsync() {
        System.out.println("\nLogging to Cloud in async fashion");
    }

    @Before("com.spring.demo.aspect.AopExpressions.setter()")
    public void forDaoPackageSetter() {
        System.out.println("\nCalling Setter..");
    }

    @Before("com.spring.demo.aspect.AopExpressions.getter()")
    public void forDaoPackageGetter() {
        System.out.println("\nCalling Getter...");
    }
}
