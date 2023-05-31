package com.cgi.demo.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cgi.demo.model.Student;

public class MySessionFactory {
	
	public static SessionFactory getSessionFactory(){
	SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
	return factory;
	
	}

}
