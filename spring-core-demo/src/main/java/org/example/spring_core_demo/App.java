package org.example.spring_core_demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person p =context.getBean("person",Person.class);
        System.out.println(p.getFirst_name()+" "+p.getLast_name());
        
        Employee e = context.getBean("employee",Employee.class);
        System.out.println(e.getDesignation()+" "+e.getSalary()+" "+e.getEmployeeId());
        System.out.println(e);
    }
}
