package in.rays.testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;


public class TestCreateDtabase {

	public static void main(String[] args) throws Exception {
	
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("create database advjava");
		
		System.out.println("new database = " + i);

	}

}
