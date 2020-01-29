package com.spring.demo.aspect;

import com.spring.demo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@EnableAspectJAutoProxy
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

    @AfterReturning(
            pointcut = "execution(* com.spring.demo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterSuccessfulAdd(JoinPoint joinpoint, List<Account> result) {
        String method = joinpoint.getSignature().toShortString();
        System.out.println("\n====>>>(@After returning, but before changing to Uppercase) result is: " + result );
        convertAccountNamesToUpperCase(result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        //loop through accounts
        for (Account tempAcc : result) {

            //get uppercase version of name
            String upperName = tempAcc.getName().toUpperCase();

            //update the name of the accounts
            tempAcc.setName(upperName);
        }
    }

    @AfterThrowing(pointcut = "execution(* com.spring.demo.dao.AccountDAO.findAccounts(..))",
                    throwing = "theExc")
    public void afterErrorAdd(JoinPoint joinPoint, Throwable theExc) {

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);

        //log the exception
        System.out.println("\nThe exception is: " + theExc);
    }

    @After("execution(* com.spring.demo.dao.AccountDAO.findAccounts(..))")
    public void afterAnyConditionsFindAccountMethod(JoinPoint joinPoint) {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @After (finally) on method: " + method);
    }

    @Around("execution(* com.spring.demo.service.TrafficServiceFortune.getFortune(..))")
    public Object afterAnyConditionsFindAccountMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // print out which method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @Around on method: " + method);

        try {
            Object result = proceedingJoinPoint.proceed();
            return result;
        } catch (Exception exp) {
            System.out.println("There is a problem");
            throw exp;
        }
    }
}