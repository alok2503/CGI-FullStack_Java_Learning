package com.cgi.demo.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cgi.demo.dao.CustomerDao;
import com.cgi.demo.model.Customer;

@Component("customerService")
public class CustomerServiceImpl implements CustomerService{
	
	private final CustomerDao customerDao;
	

	public CustomerServiceImpl(CustomerDao customerDao) {

		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerDao.getAllCustomers();
	}

	@Override
	public List<Customer> getCustomerById() {
		// TODO Auto-generated method stub
		return customerDao.getCustomerById();
	}

	@Override
	public Customer createCustomer(Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		return customerDao.createCustomer(customer);
	}

	@Override
	public void deleteCustomerById(int customerId) throws SQLException {
		// TODO Auto-generated method stub
		
		 customerDao.deleteCustomerById(customerId);
		
	}

}
