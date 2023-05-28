package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Customer;

public interface CustomerDao {
	
	public List<Customer> getAllCustomer();
	
	public Customer createCustomer(Customer customer);
	
	public Customer getCustomerById(int theId);
	
	public void deleteCustomer(int theId);

}
