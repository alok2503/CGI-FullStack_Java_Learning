package com.cgi.demo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages="com.cgi.demo")
public class SpringConfig {
	
	@Bean
	public DataSource datasource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/hr");
		dataSource.setUsername("root");
		dataSource.setPassword("Radhey@5866");
		dataSource.setDriverClassName(" com.mysql.cj.jdbc.Driver");
		return dataSource;
				
	}

}

