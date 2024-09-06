package com.codegnan.JDBC;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class deleteRecord{
		 static final String JDBC_URL ="jdbc:mysql://localhost:3306/revanth";
	      static final String USERNAME ="root";
	      static final String PASSWORD ="root";
	      
		public static void main(String[] args) {
			Connection connection =null;
			Statement statement=null;
			Scanner sc=new Scanner(System.in);
			
			try {
				
				//2.create connection
				connection=DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
				//3.create statement
				statement=connection.createStatement();
				//4.prepare and execute sql query 
				System.out.println("Enter the employee number to inset :");
				int enoToDelete = sc.nextInt();
				String deleteQuery="delete from emp where eno ="+enoToDelete;
				int rowEffected =statement.executeUpdate(deleteQuery);
				if(rowEffected > 0) {
					System.out.println("record  with employee number" +enoToDelete+"Succesfully deleted");
				}
				else {
					System.out.println("No record with employee number "+enoToDelete);
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


