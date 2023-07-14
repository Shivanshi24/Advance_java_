package in.co.rays.prepare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class TestAdd {

	public static void main(String[] args) throws Exception {
		testAdd();

	}

	private static void testAdd() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(16,'ashmita', 245, 82, 45, 56)");
		
		int i = ps.executeUpdate();
		
		System.out.println("data inserted = " + 1);

	}

}
