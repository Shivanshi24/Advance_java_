package in.rays.testjdbc;

import java.sql.*;

public class TestSelect {

	public static void main(String[] args) throws Exception {

		// load driver;

		Class.forName("com.mysql.cj.jdbc.Driver");

		// create object of connection;

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv ", "root", "root");

		// create object of statement;

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from marksheet");

		while (rs.next()) {

			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getInt(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));

		}

	}

}
