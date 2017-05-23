package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class insertquery {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/newapp?autoReconnect=true&useSSL=false";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "sinduja0495";

	public static void main(String[] args) {
		insertCustomer();

	}

	public final static Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
		return con;
	}

	public static void printAllCustomername() {
		try {
			Connection con = getConnection();
			String query = "select * from newapp.customer";// give me all rows
															// from customer
															// table
			// statement,prepared statement
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertCustomer() {
		try {
			Connection con = getConnection();
			String query = "insert into newapp.customer(ID,Name) values(2,'vamshi')";
			Statement stmt = con.createStatement();
			int rowsEffected = stmt.executeUpdate(query);
			System.out.println(rowsEffected);
			stmt.close();
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
