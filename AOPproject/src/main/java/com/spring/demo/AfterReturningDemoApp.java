package com.spring.demo;

import com.spring.demo.config.SpringConfig;
import com.spring.demo.dao.AccountDAO;
import com.spring.demo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO" ,AccountDAO.class);

        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        System.out.println("Normal names: ");
        List<Account> theAccounts = theAccountDAO.findAccounts(false);

        System.out.println("\nUppercase names:");
        System.out.println(theAccounts);
        context.close();
    }
}