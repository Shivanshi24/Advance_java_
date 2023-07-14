package in.rays.testjdbc;

import java.sql.*;

public class TestUpdate {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv", "root", "root");
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("update marksheet set name = 'shaan' where id = 4");
		
		System.out.println("Data updated = " + i);
		
		
	}

}
