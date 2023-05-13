package com.example.spring_di;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "Happy day";
	}

}
