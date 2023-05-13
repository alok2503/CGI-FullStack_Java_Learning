package com.example.spring_di2;

import com.example.spring_di2.FortuneService;

public class CricketCoach implements Coach{
	
	private String email;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	private String team;
	
	private FortuneService fortuneservice;

	public FortuneService getFortuneservice() {
		return fortuneservice;
	}

	public void setFortuneservice(FortuneService fortuneservice) {
		this.fortuneservice = fortuneservice;
	}

	@Override
	public String getDailyWorkout() {
		
		return "do running today!!"+team;
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneservice.getFortune();
	}

}
