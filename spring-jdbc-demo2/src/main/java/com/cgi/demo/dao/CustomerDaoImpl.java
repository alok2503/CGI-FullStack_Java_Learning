package com.cgi.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cgi.demo.model.Customer;

@Component("customerDao")
public class CustomerDaoImpl implements CustomerDao {

	private final DataSource dataSource;
	
	//public Connection connection;

	@Autowired
	public CustomerDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> list=new ArrayList<Customer>();
		try {
			Connection connection=dataSource.getConnection();
			
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from customer");
			while(resultSet.next())
			{
			 list.add(new Customer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));	
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Customer> getCustomerById() {
		List<Customer> list= new ArrayList<>();
		try {
			
			Connection connection= dataSource.getConnection();
			
			Statement statement = connection.createStatement();
			ResultSet resultSet= statement.executeQuery("select * from customer where customerid=1");
			
			if(resultSet.next()) {
				System.out.println(" customer found!!!");
				list.add(new Customer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));	
			}else {
				System.out.println("not found!!!!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public Customer createCustomer(Customer customer) throws SQLException {
		
		System.out.println(customer.getFirstName());
		Connection connection= dataSource.getConnection();
	
		PreparedStatement preparedStatement = connection.prepareStatement("insert into customer values(?,?,?,?)");
		preparedStatement.setInt(1, customer.getCustomerId());
		preparedStatement.setString(2, customer.getFirstName());
		preparedStatement.setString(3, customer.getLastName());
		preparedStatement.setString(4, customer.getEmail());
		preparedStatement.executeUpdate();
		return customer;

	}

	@Override
	public void deleteCustomerById(int customerId) throws SQLException {
		// TODO Auto-generated method stub
		try {
			
			Connection connection = dataSource.getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("delete  from customer where customerid=?");
			preparedStatement.setInt(1, customerId);
			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				System.out.println("customer with " + customerId + " removed sucessfully...");
			} else {
				System.out.println("no such record found........!!");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

		
	}

}

