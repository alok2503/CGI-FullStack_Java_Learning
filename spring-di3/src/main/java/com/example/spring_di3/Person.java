package com.example.spring_di3;

import org.springframework.stereotype.Component;

@Component
public class Person {
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	private int age;
	private String firstName;

	@Override
	public String toString() {
		return "Person [age=" + age + ", firstName=" + firstName + "]";
	}
	

}
