package com.codegnan.JDBC;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Practise {
	static final String URL_NAME = "jdbc:mysql://localhost:3306/revanth";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		Scanner sc = new Scanner(System.in);
		try {
			connection = DriverManager.getConnection(URL_NAME, USERNAME, PASSWORD);
			statement = connection.createStatement();
			
			
			System.out.println("Enter the eno"); 
			int eno=sc.nextInt();
			System.out.println("Enter the ENAME");
			String ename = sc.next();
			System.out.println("Enter the age ");
			int eage = sc.nextInt();
			System.out.println("Enter the ESAl");
			double esal = sc.nextDouble();
			System.out.println("Enter the department");
			String edept = sc.next();

			String insertRecords = "INSERT INTO MYEMPLOYEES(ENO,ENAME,EAGE,ESAL,EDEPT)VALUES(" + eno + ',' + ename + ','
					+ eage + ',' + esal + ',' + edept + ')';
			int rowEffected = statement.executeUpdate(insertRecords);
			if (rowEffected == 1) {
				System.out.println("succesfully inserted");
			} else {
				 System.out.println("failed......."); }
			 
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
}