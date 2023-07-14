package in.rays.call.statement;
import java.sql.*;

public class TestStoredFunction {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava", "root", "root");
		CallableStatement callstmt = conn.prepareCall("{? = CALL square(?)}");
		
		callstmt.setInt(2, 12);
		callstmt.registerOutParameter(1, Types.INTEGER);
		callstmt.execute();
		
		System.out.println("square = " + callstmt.getInt(1));
		

	}

}
