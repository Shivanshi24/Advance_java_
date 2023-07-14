package in.rays.com.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;;

public class TestUser {

	public static void main(String[] args) throws Exception {

		//testAdd();
		//testUpdate();
		//testDelete(2);
		  //testSearch();
		testSearchDob();
		//testAuthenticate();
	}

	
	private static void testAuthenticate() throws Exception {
		UserModel model = new UserModel();
		model.authenticate("priya@gmail.com", "4793");
		
		
	}


	private static void testSearchDob() throws Exception {
		UserBean bean = new UserBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setDob(sdf.parse("2000-08-19"));
	
		
		UserModel model = new UserModel();
		List list = model.searchDob(bean, 1, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (UserBean) it.next();
			System.out.print("\t " + bean.getId());
			System.out.print("\t " + bean.getFirstName());
			System.out.print("\t " + bean.getLastName());
			System.out.print("\t " + bean.getLoginId());
			System.out.print("\t " + bean.getPassword());
			System.out.print("\t " + bean.getDob());
			System.out.println("\t " + bean.getAddress());
		}
		
	}

	private static void testSearch() throws Exception {
		UserBean bean = new UserBean();

		bean.setFirstName("a");
		bean.setLastName("t");

		UserModel model = new UserModel();
		List list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (UserBean) it.next();
			System.out.print("\t " + bean.getId());
			System.out.print("\t " + bean.getFirstName());
			System.out.print("\t " + bean.getLastName());
			System.out.print("\t " + bean.getLoginId());
			System.out.print("\t " + bean.getPassword());
			System.out.print("\t " + bean.getDob());
			System.out.println("\t " + bean.getAddress());
		}
	}

	private static void testDelete(int id) throws Exception {

		UserModel model = new UserModel();
		model.delete(id);

	}

	private static void testUpdate() throws Exception {
		UserBean bean = new UserBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setId(1);
		bean.setFirstName("aditi");
		bean.setLastName("dubey");
		bean.setLoginId("aditi@gmail.com");
		bean.setPassword("1278");
		bean.setDob(sdf.parse("2000-11-25"));
		bean.setAddress("ujjain");

		UserModel model = new UserModel();
		model.update(bean);

	}

	private static void testAdd() throws Exception {

		UserBean bean = new UserBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		
		bean.setFirstName("mridula");
		bean.setLastName("geed");
		bean.setLoginId("guptash@gmail.com");
		bean.setPassword("3421");
		bean.setDob(sdf.parse("1999-04-15"));
		bean.setAddress("satna");

		UserModel model = new UserModel();
		model.add(bean);
	}

}
