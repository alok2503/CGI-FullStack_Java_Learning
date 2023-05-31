package com.example.demo.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.model.Student;

@Repository
@EnableTransactionManagement
public class StudentDaoImpl implements StudentDao {
	
	private final SessionFactory sessionFactory;

	public StudentDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public Student createStudent(Student student) {
		Session session = sessionFactory.openSession();
		session.save(student);
		return student;
	}

	@Override
	@Transactional
	public List<Student> getAllStudents() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("From Student",Student.class);
		List<Student> students = query.getResultList();
		return students;
	}

	@Override
	@Transactional
	public Student findStudent(int theId) {
		Session session = sessionFactory.openSession();
		Student student=session.find(Student.class, theId);
		return student;
	}

	@Override
	@Transactional
	public List<Student> findStudent(String name) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("From Student",Student.class);
		query.setParameter("name", name);
		List<Student> students = query.getResultList();
		return students;
	}

	@Override
	@Transactional
	public List<Student> findStudent(Date date) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("From Student",Student.class);
		query.setParameter("date", date);
		List<Student> students = query.getResultList();
		return students;
	}

	@Override
	@Transactional
	public Student updateStudent(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Student updateStudent(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Student updateStudent(Student student) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(student);
		return student;
	}

	@Override
	@Transactional
	public void deleteStudent(int theId) {
		Session session=sessionFactory.openSession();
		Student student = session.get(Student.class, theId);
		System.out.println("deleteStudent:"+student);
		session.remove(student);	
		
	}

	@Override
	@Transactional
	public void deleteAll() {
		Session session = sessionFactory.openSession();
		session.remove(Student.class);
		
	}

}
