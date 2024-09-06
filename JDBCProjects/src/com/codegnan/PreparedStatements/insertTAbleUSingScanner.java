package com.codegnan.PreparedStatements;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertTAbleUSingScanner {
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/revanth";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";

	public static void main(String[] args) {
		PreparedStatement preparedStatement = null;
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			// Prepare sql Query with parameters are without parameters
			String insertQuery = "insert into employee (eno,ename,esal,eaddr) values(?,?,?,?)";
			preparedStatement = connection.prepareStatement(insertQuery);

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the number of records :");
			int numRecords = sc.nextInt();
			sc.nextLine();
			for (int i = 0; i < numRecords; i++) {
				System.out.println("Enter details of record : " + (i + 1) + " :");
				System.out.println("Enter employee number :");
				int eno = sc.nextInt();
				System.out.println("Enter the employee name");
				String ename = sc.next();
				System.out.println("Enter the salary of an employee.");
				float esal = sc.nextFloat();
				System.out.println("Enter employee Adress.");
				String eaddr = sc.next();

				preparedStatement.setInt(1, eno);
				preparedStatement.setString(2, ename);
				preparedStatement.setDouble(3, esal);
				preparedStatement.setString(4, eaddr);

				int rowEffected = preparedStatement.executeUpdate(insertQuery);
				System.out.println(rowEffected + " is succesfully inserted");
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
