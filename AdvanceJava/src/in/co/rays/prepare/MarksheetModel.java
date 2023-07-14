package in.co.rays.prepare;

import java.sql.*;
import java.util.*;

import com.mysql.cj.protocol.Resultset;

public class MarksheetModel {

	//test add
	public void add(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv", "root", "root");

		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?, ?, ?, ?, ?, ? )");

		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getRollNo());
		ps.setInt(4, bean.getPhysics());
		ps.setInt(5, bean.getChemistry());
		ps.setInt(6, bean.getMaths());

		int i = ps.executeUpdate();

		System.out.println(i);

	}
        //test update
	public void update(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv", "root", "root");

		PreparedStatement ps = conn.prepareStatement(
				"update marksheet set name = ?, roll_no=?, physics =?, chemistry = ?, maths = ?  where id = ?");

		ps.setString(1, bean.getName());
		ps.setInt(2, bean.getRollNo());
		ps.setInt(3, bean.getPhysics());
		ps.setInt(4, bean.getChemistry());
		ps.setInt(5, bean.getMaths());
		ps.setInt(6, bean.getId());

		int i = ps.executeUpdate();

		System.out.println(i);

	}
          //test delete
	public void delete(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv", "root", "root");

		PreparedStatement ps = conn.prepareStatement("delete from marksheet where id = ? ");
		ps.setInt(1, id);

		int i = ps.executeUpdate();

		System.out.println(i);

	}
          //test find by roll_no
	public MarksheetBean findByRoll(int rollNo) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from marksheet where roll_no = ?");

		ps.setInt(1, rollNo);
		ResultSet rs = ps.executeQuery();

	     MarksheetBean bean = null;

		while (rs.next()) {
			
			bean = new MarksheetBean();

			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRollNo(rs.getInt(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
		}

		return bean;

	}

	// search method

	public List search() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from marksheet");

		ArrayList list = new ArrayList();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			MarksheetBean bean = new MarksheetBean();

			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRollNo(rs.getInt(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			list.add(bean);

		}

		System.out.println("data inserted = " + rs);
		return list;
	}

	// string Buffer

	public List search2(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv", "root", "root");

		StringBuffer sql = new StringBuffer("select * from marksheet");
		if (bean != null) {
			sql.append(" and name like '" + bean.getName() + "%'");
		}
		System.out.println(sql);

		PreparedStatement ps = conn.prepareStatement(sql.toString());
		return null;

	}

	// sql injection
	public List search3(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv", "root", "root");

		StringBuffer sql = new StringBuffer("select * from marksheet where 1=1");

		if (bean != null) {

			sql.append(" and name like '" + bean.getName() + "%'");

		}

		System.out.println(sql);

		PreparedStatement ps = conn.prepareStatement(sql.toString());

		ArrayList list = new ArrayList();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			bean = new MarksheetBean();

			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRollNo(rs.getInt(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			list.add(bean);

		}

		return list;
	}

	// sql injection name+roll no

	public List search4(MarksheetBean bean, int pageNo, int pageSize) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv", "root", "root");

		StringBuffer sql = new StringBuffer("select * from marksheet where 1=1");

		if (bean != null) {

			if (bean.getName() != null && bean.getName().length() > 0) {

				sql.append(" and name like '" + bean.getName() + "%'");

			}

			if (bean.getRollNo() > 0) {
				sql.append(" and roll_no = '" + bean.getRollNo() + "'");
			}

		}
		if(pageSize>0) {
			
			pageNo =(pageNo-1)*pageSize;
			sql.append(" limit " +pageNo+", "+pageSize);
		}

		System.out.println(sql);

		PreparedStatement ps = conn.prepareStatement(sql.toString());

		ArrayList list = new ArrayList();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			bean = new MarksheetBean();

			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRollNo(rs.getInt(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			list.add(bean);

		}

		return list;
	}
	
	


}
