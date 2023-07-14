package in.rays.testjdbc;

import java.sql.*;

public class TestSelectAdv {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava", "root", "root");

		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from  batch");
		
		while(rs.next()) {
			
			System.out.print("\t" + rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			
		}

	}

}
