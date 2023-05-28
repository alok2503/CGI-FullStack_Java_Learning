package com.example.demo.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.model.Customer;

@Repository
@EnableTransactionManagement
public class CustomerDaoImpl implements CustomerDao {

	private final SessionFactory sessionfactory;

	public CustomerDaoImpl(SessionFactory sessiofactory) {
		super();
		this.sessionfactory = sessiofactory;
	}

	@Override
	@Transactional
	public List<Customer> getAllCustomer() {
		Session session = sessionfactory.openSession();
		Query query = session.createQuery("From Customer", Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	public Customer createCustomer(Customer customer) {

		Session session = sessionfactory.openSession();
		session.save(customer);
		return customer;

	}

	@Override
	public Customer getCustomerById(int theId) {
		Session session = sessionfactory.openSession();
		Customer customer = session.find(Customer.class, theId);
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		Customer customer = session.find(Customer.class, theId);
		session.remove(customer);

	}

}
