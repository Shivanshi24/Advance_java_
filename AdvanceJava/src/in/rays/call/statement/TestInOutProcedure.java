package in.rays.call.statement;
import java.sql.*;

public class TestInOutProcedure {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava", "root", "root");
		CallableStatement callstmt = conn.prepareCall("{CALL empINOUT(?)}");
		
		callstmt.setInt(1, 3);
	
		
		callstmt.registerOutParameter(1, Types.INTEGER);
		callstmt.execute();
		
		System.out.println(callstmt.getInt(1));
		

		
	}
}
