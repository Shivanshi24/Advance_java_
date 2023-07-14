package in.co.rays.prepare;

import java.sql.*;

public class TestTransaction {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv", "root", "root");
		
		conn.setAutoCommit(false);

		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("insert into marksheet values(20, 'sharad', 250, 23, 34, 65)");
		i = stmt.executeUpdate("insert into marksheet values(20, 'sharad', 250, 23, 34, 65)");
		i = stmt.executeUpdate("insert into marksheet values(25, 'sharad', 250, 23, 34, 65)");
		
		System.out.println(i);
		conn.commit();
	}

}
