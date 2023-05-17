package com.cgi.demo;

import java.util.List;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cgi.demo.config.SpringConfig;
import com.cgi.demo.model.Customer;
import com.cgi.demo.service.CustomerService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
        	
        	ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
			
        	CustomerService customerService =context.getBean("customerService",CustomerService.class);
        	
        	List<Customer> list=customerService.getAllCustomers();
        	for(Customer c:list)
        	{
        	  System.out.println(c);	
        	}
        	
        	List<Customer> list2= customerService.getCustomerById();
        			for(Customer c:list2) {
        				System.out.println(c);
        			}
        			
        		Customer c=	customerService.createCustomer(new Customer(new Random().nextInt(1000),"shweta","mishra","sm@gmail.com"));
        		System.out.println(c.getFirstName());
        		
        		customerService.deleteCustomerById(1);
        	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}
