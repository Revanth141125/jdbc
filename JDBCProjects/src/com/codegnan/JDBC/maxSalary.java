package com.codegnan.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class maxSalary {
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
			String selectedQuery = "SELECT * FROM WIPROEMP WHERE ESAL=(SELECT MAX(ESAL) FROM WIPROEMP)";
			resultSet = statement.executeQuery(selectedQuery);
		    while(resultSet.next()) {
				System.out.println("ENO\tENAME\tEAGE\tESAL\tEDEPT");
				System.out.println("----------------------------------------");
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getDouble(4)+"\t"+resultSet.getString(5));
                
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
