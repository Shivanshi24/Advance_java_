package in.rays.testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class TestDelete {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv", "root", "root");
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("delete from marksheet where id = 14");
		
		System.out.println("Data deleted = " + i);
	}

}
