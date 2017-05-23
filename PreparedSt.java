package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedSt {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/newapp?autoReconnect=true&useSSL=false";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "sinduja0495";

	public static void main(String[] args) {
		insertCustomerPstmt(3, "NMRao");

	}

	public final static Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
		return con;
	}

	public static void insertCustomerPstmt(int ID, String Name) {
		try {
			Connection con = getConnection();
			String query = "insert into newapp.customer(ID,Name) values(?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setLong(1, ID);
			pstmt.setString(2, Name);

			int rowsEffected = pstmt.executeUpdate();
			System.out.println(rowsEffected);
			pstmt.close();
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
