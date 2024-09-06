package com.codegnan.PreparedStatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertTable {
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/revanth";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";

	public static void main(String[] args) {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			// establish the connection.
			connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			// Prepare sql query with parameters or without parameters.
			String insertQuery = "insert into employee (eno,ename,esal,eaddr) values(?,?,?,?)";
			// create preparedstatement object
			preparedStatement = connection.prepareStatement(insertQuery);
			// set the values to a positional p[arameters.
			preparedStatement.setInt(1, 111);
			preparedStatement.setString(2, "codegnan");
			preparedStatement.setDouble(3, 60000);
			preparedStatement.setString(4, "hyd");
			// execute the query.
			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println(rowsAffected + " rows Inserted Succesfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
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


