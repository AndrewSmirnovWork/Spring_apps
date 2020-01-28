package com.spring.demo;

import com.spring.demo.config.SpringConfig;
import com.spring.demo.dao.AccountDAO;
import com.spring.demo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO" ,AccountDAO.class);

        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        try {
            //simulate the exception
            boolean tripWire = true;
            List<Account> theAccounts = theAccountDAO.findAccounts(tripWire);
        } catch (Exception exc) {
            System.out.println("\nCaught exception");
        }
        context.close();
    }

}
