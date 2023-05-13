package com.example.spring_di;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneservice;

	public FortuneService getFortuneservice() {
		return fortuneservice;
	}

	public void setFortuneservice(FortuneService fortuneservice) {
		this.fortuneservice = fortuneservice;
	}

	@Override
	public String getDailyWorkout() {
		
		return "do running today!!";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneservice.getFortune();
	}

}
