package com.spring.demo.app;

import com.spring.demo.app.Service.Coach;
import com.spring.demo.app.Service.FortuneService;
import org.springframework.stereotype.Component;

@Component
public class WrestlingCoach implements Coach {

	private FortuneService fortuneService;
			
	public WrestlingCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your double leg takedown.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
