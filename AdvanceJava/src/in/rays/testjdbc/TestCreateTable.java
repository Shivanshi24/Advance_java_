package in.rays.testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class TestCreateTable {

	public static void main(String[] args) throws Exception {
	
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava", "root", "root");

		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("create table batch(id int, name varchar(45))");
		
		System.out.println("create table = " + i);


	}

}
