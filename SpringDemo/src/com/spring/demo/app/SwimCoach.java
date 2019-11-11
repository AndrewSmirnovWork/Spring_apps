package com.spring.demo.app;

import com.spring.demo.app.Service.Coach;
import com.spring.demo.app.Service.FortuneService;
import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
    @Value("${email}")
    private String email;

    @Value("${team}")
    private String team;

    private FortuneService fortuneService;

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String getDailyWorkout() {
        return "Swin 250 meters as warm up";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
