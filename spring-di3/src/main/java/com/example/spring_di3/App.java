package com.example.spring_di3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.spring_di3.demo.Department;
import com.example.spring_di3.demo.Employee;
import com.example.spring_di3.demo.Location;


/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        Employee e = context.getBean("emp",Employee.class);
        e.setEmployeeId(12);
        e.setFirstName("ALok");
        e.setLastName("Mishra");
        Department d = e.getDepartment();
        d.setDepartmentName("IT");
        d.setDepartmentId(100);
        Location l = d.getLocation();
        l.setCity("Hyderabad");
        l.setLocationId(133);
        l.setCountry("India");
        d.setLocation(l);
        e.setDepartment(d);
        System.out.println(e);

    }
}
