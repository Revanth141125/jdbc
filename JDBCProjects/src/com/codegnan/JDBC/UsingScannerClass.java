package com.codegnan.JDBC;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UsingScannerClass {
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/revanth";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		Scanner sc = new Scanner(System.in);
		try {
			connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			statement = connection.createStatement();
			System.out.println("Enter employee number :");
			int eno = sc.nextInt();
			System.out.println("Enter the employee name");
			String ename = sc.next();
			System.out.println("Enter the salary of an employee.");
			float esal = sc.nextFloat();
			System.out.println("Enter employee Adress.");
			String eaddr = sc.next();

			String insertSql = "INSERT INTO EMP(ENO,ENAME,ESAL,EADDR) VALUES(" + eno + ',' + ename + ','
					+ esal + ',' + eaddr + ")";
			int rowEffected= statement.executeUpdate(insertSql);
			if(rowEffected == 1) {
				System.out.println("Records is succesfully Added");
			}
			else {
				System.out.println("failed");
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
