package com.cgi.demo;

import java.util.Random;

import com.cgi.demo.model.Student;
import com.cgi.demo.service.StudentServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       StudentServiceImpl s = new StudentServiceImpl();
       Student cs=s.createStudent(new Student(new Random().nextInt(1000),"Alok","Mishra","am@gmail.com"));
       System.out.println("student created......"+cs);
       Student student=s.getStudentById(2);
       System.out.println(student);
       //s.deleteAll();
       Student us=s.updateStudent(75);
       System.out.println("updated student:"+us);
    }
}
