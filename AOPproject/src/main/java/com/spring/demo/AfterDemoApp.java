package com.spring.demo;

import com.spring.demo.config.SpringConfig;
import com.spring.demo.dao.AccountDAO;
import com.spring.demo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO" ,AccountDAO.class);

        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        boolean tripWire = true;
        List<Account> theAccounts = theAccountDAO.findAccounts(tripWire);

        context.close();
    }

}
