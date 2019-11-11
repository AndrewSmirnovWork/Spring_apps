package com.spring.demo.app;

import com.spring.demo.app.Service.Coach;
import com.spring.demo.app.Service.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("fileFortuneService")
    private FortuneService fortuneService;


    @Override
    public String getDailyWorkout() {
        return "Try harder";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
