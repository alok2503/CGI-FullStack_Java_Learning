package com.example.demo.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	private final StudentDao studentDao;
	

	public StudentServiceImpl(StudentDao studentDao) {
		super();
		this.studentDao = studentDao;
	}

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.createStudent(student);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentDao.getAllStudents();
	}

	@Override
	public Student findStudent(int theId) {
		// TODO Auto-generated method stub
		return studentDao.findStudent(theId);
	}

	@Override
	public List<Student> findStudent(String name) {
		// TODO Auto-generated method stub
		return studentDao.findStudent(name);
	}

	@Override
	public List<Student> findStudent(Date date) {
		// TODO Auto-generated method stub
		return studentDao.findStudent(date);
	}

	@Override
	public Student updateStudent(int theId) {
		// TODO Auto-generated method stub
		return studentDao.updateStudent(theId);
	}

	@Override
	public Student updateStudent(String name) {
		// TODO Auto-generated method stub
		return studentDao.updateStudent(name);
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.updateStudent(student);
	}

	@Override
	public void deleteStudent(int theId) {
		// TODO Auto-generated method stub
		studentDao.deleteStudent(theId);
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		studentDao.deleteAll();
		
	}

}
