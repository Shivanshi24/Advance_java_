package in.rays.call.statement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.*;

public class TestCountFunction {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava", "root", "root");
		CallableStatement callstmt = conn.prepareCall("{? = CALL empCount()}");
		
		callstmt.registerOutParameter(1, Types.INTEGER);
		
		callstmt.execute();
		
		System.out.println("count = " + callstmt.getInt(1) );

	}

}
