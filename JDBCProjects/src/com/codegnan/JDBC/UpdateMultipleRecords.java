package com.codegnan.JDBC;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateMultipleRecords {
	static final String URL_NAME = "jdbc:mysql://localhost:3306/revanth";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			connection=DriverManager.getConnection(URL_NAME, USERNAME, PASSWORD);
			statement=connection.createStatement();
			
				
				System.out.println("enter the  ENO to update");
				int eno = sc.nextInt();
				System.out.println("enter the ENAME to update");
				String ename = sc.next();
				System.out.println("enter the  EAGE to update");
				int eage = sc.nextInt();
				System.out.println("enter the  ESAL to update");
				double esal = sc.nextDouble();
				System.out.println("enter the  EDEPT to update");
				String edept = sc.next();
				sc.nextLine();
				String insertRecord = "UPDATE WIPROEMP SET ENAME = '"+ename+"',EAGE='"+eage+"',ESAL='"+esal+"',EDEPT ='"+edept+"'WHERE ENO = "+eno;
				int rowEffected = statement.executeUpdate(insertRecord);
				if (rowEffected > 0) {
					System.out.println("succesfully updated.....");
				} else {
					System.out.println("failed to updated........");
				}
			
		
          
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
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
