package com.cgi.demo.service;

import com.cgi.demo.model.Student;

public interface StudentService {
	
	public Student createStudent(Student student);
	public Student getStudentById(int studentid);
	public void deleteAll();
	public Student updateStudent(int studentid);

}
