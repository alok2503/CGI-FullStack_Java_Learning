package com.cgi.demo.dao;

import com.cgi.demo.model.Student;

public interface StudentDao {
	
	public Student createStudent(Student student);
	public Student getStudentById(int studentid);
	public void deleteAll();
	public Student updateStudent(int studentid);

}
