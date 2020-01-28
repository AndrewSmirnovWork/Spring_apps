package com.spring.demo;

import com.spring.demo.config.SpringConfig;
import com.spring.demo.dao.AccountDAO;
import com.spring.demo.dao.MembershipDAO;
import com.spring.demo.service.TrafficServiceFortune;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO" ,AccountDAO.class);

        TrafficServiceFortune trafficServiceFortune = context.getBean("trafficServiceFortune", TrafficServiceFortune.class);

        System.out.println("\nMain Program: AroundDemoApp");

        System.out.println("Calling getFortune");

        String data = trafficServiceFortune.getFortune();

        System.out.println("\nMy fortune is: " + data);

        System.out.println("\nFinished");

        context.close();
    }

}
