package com.spring.demo.app;

import com.spring.demo.app.Service.Coach;
import com.spring.demo.app.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoApp {
    public static void main(String[] args) {

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
//      Coach secondCoach = context.getBean("tennisCoach", Coach.class);

/*
        boolean result = (theCoach == secondCoach);
        System.out.println(theCoach + "\n" + secondCoach);
*/

        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        System.out.println("email: " + theCoach.getEmail()+ "\n"+
                            "team: " + theCoach.getTeam());
        context.close();
    }
}
