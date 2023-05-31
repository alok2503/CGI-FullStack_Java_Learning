
package com.cgi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        try {
			
        	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver() );
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","Radhey@5866");
        	if(connection!=null) {
        		System.out.println("connection succeedd");
        	}
        	else {
        		System.out.println("connection declined");
        	}
        	
        	Statement statement= connection.createStatement();
        	ResultSet resultset = statement.executeQuery("select lastname from customer");
        	
        	while(resultset.next()) {
        		System.out.println(resultset.getString("lastname"));
        	}
        	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

    }
}
