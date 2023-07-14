package in.rays.com.user;

import java.sql.*;
import java.util.*;

public class UserModel {
	public Integer nextPk() throws Exception {
		int pk = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select max(id) from user");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}

		return pk + 1;

	}

	public void add(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv", "root", "root");

		PreparedStatement ps = conn.prepareStatement("insert into user values(?, ?, ?, ?, ?, ?,?)");

		ps.setInt(1, nextPk());
		ps.setString(2, bean.getFirstName());
		ps.setString(3, bean.getLastName());
		ps.setString(4, bean.getLoginId());
		ps.setString(5, bean.getPassword());
		ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(7, bean.getAddress());

		int i = ps.executeUpdate();
		System.out.println(i);

	}

	public void update(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv", "root", "root");

		PreparedStatement ps = conn.prepareStatement(
				"update user set first_name =?, last_name=?, login_id=?, password=?, dob=?, address=? where id=?");

		ps.setString(1, bean.getFirstName());
		ps.setString(2, bean.getLastName());
		ps.setString(3, bean.getLoginId());
		ps.setString(4, bean.getPassword());
		ps.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(6, bean.getAddress());
		ps.setInt(7, bean.getId());

		int i = ps.executeUpdate();
		System.out.println(i);

	}

	public void delete(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv", "root", "root");

		PreparedStatement ps = conn.prepareStatement("delete from user where id =?");

		ps.setInt(1, id);

		int i = ps.executeUpdate();
		System.out.println(i);

	}
	// search by first name and last name;

	public List search(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv", "root", "root");

		StringBuffer sql = new StringBuffer("select * from user where 1=1");

		if (bean != null) {

			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {

				sql.append(" and first_name like '" + bean.getFirstName() + "%'");

			}

			if (bean.getLastName() != null && bean.getLastName().length() > 0) {

				sql.append(" and last_name like '" + bean.getLastName() + "%'");

			}
		}

		System.out.println(sql);

		PreparedStatement ps = conn.prepareStatement(sql.toString());

		ArrayList list = new ArrayList();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
			list.add(bean);
		}

		return list;

	}
	// searchdob method;

	public List searchDob(UserBean bean, int pageNo, int pageSize) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv", "root", "root");

		StringBuffer sql = new StringBuffer("select * from user where 1=1");

		if (bean != null) {

			if (bean.getDob() != null && bean.getDob().getTime() > 0) {

				sql.append(" and dob like '" + new java.sql.Date(bean.getDob().getTime()) + "%'");
			}
		}

		if (pageNo > 0) {

			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
		}

		System.out.println(sql);

		PreparedStatement ps = conn.prepareStatement(sql.toString());

		ArrayList list = new ArrayList();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setAddress(rs.getString(7));
			list.add(bean);
		}

		return list;

	}

	public UserBean authenticate(String loginId, String password) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select * from user where login_id=? and password=?");

		ps.setString(1, loginId);
		ps.setString(2, password);

		ResultSet rs = ps.executeQuery();
		UserBean bean = null;

		while (rs.next()) {
             
			bean = new UserBean();
			System.out.print("\t"+ rs.getInt(1));
			System.out.print("\t"+rs.getString(2));
			System.out.print("\t"+rs.getString(3));
			System.out.print("\t"+rs.getString(4));
			System.out.print("\t"+rs.getString(5));
			System.out.print("\t"+rs.getString(6));
			System.out.println("\t"+rs.getString(7));
      
		}
             
		return bean;
	}

}
