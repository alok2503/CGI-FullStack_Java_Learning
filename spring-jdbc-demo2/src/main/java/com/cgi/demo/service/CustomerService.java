package com.cgi.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.cgi.demo.model.Customer;

public interface CustomerService {
	
	public List<Customer> getAllCustomers();
	public List<Customer> getCustomerById();
	public Customer createCustomer(Customer customer) throws SQLException;
	public void deleteCustomerById(int customerId) throws SQLException;


}
