package com.example.spring_jdbc_demo;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
  
        
        try {
            @SuppressWarnings("resource")
    		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            DataSource datasource=context.getBean("dataSource",DriverManagerDataSource.class);
            
			Connection connection=datasource.getConnection();
			System.out.println(connection);
			System.out.println("Connection Succedded!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
