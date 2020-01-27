package com.spring.demo.aspect;

import com.spring.demo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LoggingAspect {
    //@Before("execution(* com.spring.demo.dao.*.*(..))")
    //any return type
    //any class, only from package com.spring.demo.dao.*
    //any method with any param type

    @Before("com.spring.demo.aspect.AopExpressions.beforeAddDAOPackage()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        //display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method :" + methodSignature);

        //display method args

        //get args
        Object[] args = theJoinPoint.getArgs();

        //loop thru args
        for (Object tempArgs : args) {
            System.out.println(tempArgs);
            if (tempArgs instanceof Account) {
                //downcast and print Account specific stuff
                Account theAccount = (Account) tempArgs;
                System.out.println("Account name: " + theAccount.getName());
                System.out.println("Account level: " + theAccount.getLevel());
            }
        }
    }

    @AfterReturning("com.spring.demo.aspect.AopExpressions.afterAddForDaoPackage()")
    public void afterSuccessfulAdd() {
        System.out.println("Added!");
    }

    @AfterThrowing("com.spring.demo.aspect.AopExpressions.afterAddForDaoPackage()")
    public void afterErrorAdd() {
        System.out.println("Error! Can't add right now! Try later...");
    }
}