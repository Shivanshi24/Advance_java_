package in.rays.testjdbc;

import java.sql.*;

public class TestAdvInsertValue {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava", "root", "root");

		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("insert into batch values(1, 'swati')");
		
		System.out.println("value insert = " + i);

	}

}
