package com.example.spring_di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach mycoach = context.getBean("coach",CricketCoach.class);
        System.out.println(mycoach.getDailyFortune()+"\n"+mycoach.getDailyWorkout());
    }
}
