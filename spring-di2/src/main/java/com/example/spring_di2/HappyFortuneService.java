package com.example.spring_di2;

public class HappyFortuneService implements FortuneService {
	
	@Override
	public String getFortune() {
		
		return "Happy day";
	}


}
