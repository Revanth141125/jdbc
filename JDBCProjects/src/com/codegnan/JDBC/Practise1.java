package com.codegnan.JDBC;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Practise1 {
	static final String USER_URL = "jdbc:mysql://localhost:3306/revanth";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		Scanner sc = new Scanner(System.in);
		try {
			connection = DriverManager.getConnection(USER_URL, USERNAME, PASSWORD);
			statement = connection.createStatement();
			/*
			 * String
			 * insertSql="INSERT INTO WIPROEMP(ENO,ENAME,EAGE,ESAL,EDEPT)VALUES(1,'REV',22,56788,'DEVELOPER')"
			 * ; int rowEffected=statement.executeUpdate(insertSql); if(rowEffected == 1) {
			 * System.out.println("succesfully inserted"); } else {
			 * System.out.println("Failed to insert.......");
			 */
			
				System.out.println("enter the value to ENO");
				int eno = sc.nextInt();
				System.out.println("enter the value to ENAME");
				String ename = sc.next();
				System.out.println("enter the value to EAGE");
				int eage = sc.nextInt();
				System.out.println("enter the value to ESAL");
				double esal = sc.nextDouble();
				System.out.println("enter the value to EDEPT");
				String edept = sc.next();
				sc.nextLine();
				String insertRecord = "INSERT INTO WIPROEMP(ENO,ENAME,EAGE,ESAL,EDEPT)VALUES(" + eno + ',' + ename + ','
						+ eage + ',' + esal + ',' + edept + ')';
				int rowEffected = statement.executeUpdate(insertRecord);
				if (rowEffected > 0) {
					System.out.println("succesfully.....");
				} else {
					System.out.println("failed ........");
				}
			

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
