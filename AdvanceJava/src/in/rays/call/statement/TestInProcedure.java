package in.rays.call.statement;
import java.sql.*;

public class TestInProcedure {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava", "root", "root");
		CallableStatement callstmt = conn.prepareCall("{CALL empIN(?)}");
		
		callstmt.setInt(1, 2);
		callstmt.execute();
		
		ResultSet rs = callstmt.getResultSet();
		
		while(rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
		}
		
	}

}
