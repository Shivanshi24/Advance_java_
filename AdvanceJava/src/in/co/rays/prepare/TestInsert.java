package in.co.rays.prepare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestInsert {

	public static void main(String[] args) throws Exception {

		testInsert();
	}

	private static void testInsert()
			throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv", "root", "root");

		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?, ?, ?, ?, ?, ? )");
		
		ps.setInt(1, 17);
		ps.setString(2, "raman");
		ps.setInt(3, 246);
		ps.setInt(4, 34);
		ps.setInt(5, 45);
		ps.setInt(6, 51);

		int i = ps.executeUpdate();
		
		System.out.println("data inserted = " +i);

	}

}
