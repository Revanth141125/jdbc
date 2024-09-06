package com.codegnan.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	// JDBC URL,Username,Password of Mysql server.
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/revanth";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";

	public static void main(String[] args) {
		String sql = "CREATE TABLE IF NOT EXISTS EMPLOYEE1 (" + "ID INT  PRIMARY KEY,"
				+ "NAME VARCHAR(100)," + "Age INT," + "IsActive VARCHAR(255)" + ")";
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection=DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
			statement=connection.createStatement();
			statement.execute(sql);
			System.out.println("Employees table created successfully");

			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(statement!=null) {
				try {
					statement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}if(connection!=null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
