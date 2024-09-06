package com.codegnan.PreparedStatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Preparedwithbatch {
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/revanth";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			String sql ="update employee set esal=? where eno =?";
			preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setDouble(1, 720000);
			preparedStatement.setInt(2, 111);
			preparedStatement.addBatch();
			
			preparedStatement.setDouble(1, 920000);
			preparedStatement.setInt(2, 222);
			preparedStatement.addBatch();
			
			preparedStatement.setDouble(1, 1020000);
			preparedStatement.setInt(2, 555);
			preparedStatement.addBatch();
			
			int updateCounts[]=preparedStatement.executeBatch();
			System.out.println("Batch update is executed ");
			for(int i=0;i<updateCounts.length;i++) {
				System.out.println("update count for Statement : "+i+" : "+updateCounts[i]);
			}
			
			
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
