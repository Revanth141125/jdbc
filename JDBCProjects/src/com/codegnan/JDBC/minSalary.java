package com.codegnan.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class minSalary {
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/revanth";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			statement = connection.createStatement();
			String selectedQuery = "SELECT AVG(ESAL) AS AVERAGE_SAL FROM WIPROEMP";
			resultSet = statement.executeQuery(selectedQuery);
			if(resultSet.next()) {
				double averageSalary = resultSet.getDouble("average_salary");
				System.out.println("Average salary of an emplees are :"+ averageSalary);
			}
			else {
				System.out.println("No data available");
			}
		   

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
