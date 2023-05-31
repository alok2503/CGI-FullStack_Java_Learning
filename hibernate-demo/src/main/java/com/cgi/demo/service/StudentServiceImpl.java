package com.cgi.demo.service;

import com.cgi.demo.dao.StudentDao;
import com.cgi.demo.dao.StudentDaoImpl;
import com.cgi.demo.model.Student;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;

	{
		studentDao=new StudentDaoImpl();

	}

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.createStudent(student);
	}

	@Override
	public Student getStudentById(int studentid) {
		// TODO Auto-generated method stub
		return studentDao.getStudentById(studentid);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		studentDao.deleteAll();
		
	}

	@Override
	public Student updateStudent(int studentid) {
		// TODO Auto-generated method stub
		return studentDao.updateStudent(studentid);
	}

}
