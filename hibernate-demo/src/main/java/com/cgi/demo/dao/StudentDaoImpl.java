package com.cgi.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.cgi.demo.factory.MySessionFactory;
import com.cgi.demo.model.Student;


public class StudentDaoImpl implements StudentDao {
	
	private Session session;
	
	{
		 session = MySessionFactory.getSessionFactory().openSession();
	}
		

	@Override
	public Student createStudent(Student student) {
		session.getTransaction().begin();
		session.save(student);
		session.getTransaction().commit();
		return student;
	}


	@Override
	public Student getStudentById(int studentid) {
		session.getTransaction().begin();
		Student student=session.get(Student.class, studentid);
		if(student==null) {
			System.out.println("no student found....");
		}
		else {
			System.out.println("found......");
		}
		session.getTransaction().commit();
		return student;
	}


	@Override
	public void deleteAll() {
		session.getTransaction().begin();
		Query query = session.createQuery("From Student",Student.class);
		List<Student> list=query.getResultList();
		for(Student s:list) {
			session.delete(s);
		}
		session.getTransaction().commit();
		
	}


	@Override
	public Student updateStudent(int studentid) {
		// TODO Auto-generated method stub
		session.getTransaction().begin();
		Student student=session.get(Student.class, studentid);
		if(student==null) {
			System.out.println("no student found....");
		}else {
			student.setFirstName("shweta");
			session.merge(student);
		}
		
		session.getTransaction().commit();
		return student;
		
	}

}
