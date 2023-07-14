package in.co.rays.prepare;

import java.sql.*;

public class TestDynamicInsert {

	public static void main(String[] args) throws Exception {

		testInsert(18, "kartik", 247, 33, 34, 35);
	}

	private static void testInsert(int id, String name, int rollNo, int physics, int chemistry, int maths)
			throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv", "root", "root");

		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?, ?, ?, ?, ?, ? )");
		
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, rollNo);
		ps.setInt(4, physics);
		ps.setInt(5, chemistry);
		ps.setInt(6, maths);

		int i = ps.executeUpdate();
		
		System.out.println("data inserted = " +i);



	}

}
