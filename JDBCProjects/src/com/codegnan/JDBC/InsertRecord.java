package com.codegnan.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecord {
      static final String JDBC_URL ="jdbc:mysql://localhost:3306/revanth";
      static final String USERNAME ="root";
      static final String PASSWORD ="root";
      
	public static void main(String[] args) {
		Connection connection =null;
		Statement statement=null;
		
		try {
			
			//2.create connection
			connection=DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			//3.create statement
			statement=connection.createStatement();
			//4.prepare and execute sql query 
			String insertQuery="INSERT INTO EMPLOYEE (ENO,ENAME,ESAL,EADDR) VALUES(1,'REVANTH',5000,'HYD')";
			int rowEffected= statement.executeUpdate(insertQuery);
			if(rowEffected == 1) {
				System.out.println("Records is succesfully Added");
			}
			else {
				System.out.println("Already Exist");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
        	if (statement != null) {
        		try {
        			statement.close();
        		}catch(SQLException e) {
        			e.printStackTrace();
        		}
        	}
        	if(connection != null) {
        		try {
        			connection.close();
        		}catch(SQLException e) {
        			e.printStackTrace();
        		}
        	}
		}
	}
}
	
		
		

	


