package com.java.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCdemo {
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/newapp?autoReconnect=true&useSSL=false";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "sinduja0495";
	public static void main(String []args){
		try {
			Connection con =DriverManager.getConnection(DB_URL,USER,PASS);
		    String query="select * from newapp.customer";//give me all rows from customer table
		    //statement,prepared statement
		    Statement stmt=con.createStatement();
		    ResultSet rs=stmt.executeQuery(query);
		while(rs.next()){
			System.out.println(rs.getString(1)+" "+ rs.getString(2));
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
