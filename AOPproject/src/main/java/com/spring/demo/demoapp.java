package com.spring.demo;

import com.spring.demo.config.SpringConfig;
import com.spring.demo.dao.AccountDAO;
import com.spring.demo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class demoapp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO" ,AccountDAO.class);

        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);


        Account theAccount = new Account();
        theAccount.setName("Andrew");
        theAccount.setLevel("High");

        //call the AccountDAO methods
        theAccountDAO.addAccount(theAccount, true);
        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("silver");

        String name = theAccountDAO.getName();
        System.out.println(name);
        String code = theAccountDAO.getServiceCode();
        System.out.println(code);

        //call the MembershipDAO methods
        theMembershipDAO.addAccount();

        //close the context
        context.close();
    }

}
