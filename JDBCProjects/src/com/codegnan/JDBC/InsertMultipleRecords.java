package com.codegnan.JDBC;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertMultipleRecords {
	static final String JDBC_URL ="jdbc:mysql://localhost:3306/revanth";
    static final String USERNAME ="root";
    static final String PASSWORD ="root";

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		Scanner sc = new Scanner(System.in);
		try {
			connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			statement = connection.createStatement();
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
				String insertSql = "INSERT INTO EMPLOYEE(ENO,ENAME,ESAL,EADDR) VALUES(" + eno + ',' + ename + ','
						+ esal + ',' + eaddr + ")";
				int rowEffected = statement.executeUpdate(insertSql);
				if (rowEffected == 1) {
					System.out.println("Records are succesfully Added .");
				}
				else {
					System.out.println("Failed");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
