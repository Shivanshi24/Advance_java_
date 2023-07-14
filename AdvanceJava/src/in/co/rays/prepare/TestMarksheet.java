package in.co.rays.prepare;

import java.util.*;

public class TestMarksheet {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testUpdate();
		// testDelete(20);
		// testFindByRoll();
		//testSearch();
		//testSearch2();
		//testSearch3();
		testSearch4();
		

	}
	
	private static void testSearch4() throws Exception {
		
		MarksheetBean bean = new MarksheetBean();
		
		bean.setRollNo(203);
		bean.setName("a");
		
		
		 MarksheetModel model = new MarksheetModel();
		 List list = model.search4(null, 1, 5);
		 
		 Iterator it = list.iterator();

			while (it.hasNext()) {
				 bean = (MarksheetBean) it.next();
				System.out.print(bean.getId());
				System.out.print("\t"+ bean.getName());
				System.out.print("\t"+bean.getRollNo());
				System.out.print("\t"+bean.getPhysics());
				System.out.print("\t"+bean.getChemistry());
				System.out.println("\t"+bean.getMaths());

			}
		
		
		
	}

	private static void testSearch3() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		
		bean.setName("shi");
		
		
		 MarksheetModel model = new MarksheetModel();
		 List list = model.search3(bean);
		 
		 Iterator it = list.iterator();

			while (it.hasNext()) {
				 bean = (MarksheetBean) it.next();
				System.out.print(bean.getId());
				System.out.print("\t"+ bean.getName());
				System.out.print("\t"+bean.getRollNo());
				System.out.print("\t"+bean.getPhysics());
				System.out.print("\t"+bean.getChemistry());
				System.out.println("\t"+bean.getMaths());

			}
	}

	private static void testSearch2() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setName("s");
		
		 MarksheetModel model = new MarksheetModel();
		 List list = model.search2(bean);
		 
		 Iterator it = list.iterator();

			while (it.hasNext()) {
				 bean = (MarksheetBean) it.next();
				System.out.print(bean.getId());
				System.out.print("\t"+ bean.getName());
				System.out.print("\t"+bean.getRollNo());
				System.out.print("\t"+bean.getPhysics());
				System.out.print("\t"+bean.getChemistry());
				System.out.println("\t"+bean.getMaths());

			}
	}

	private static void testSearch() throws Exception {

		MarksheetModel model = new MarksheetModel();
		List list = model.search();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			MarksheetBean bean = (MarksheetBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t"+ bean.getName());
			System.out.print("\t"+bean.getRollNo());
			System.out.print("\t"+bean.getPhysics());
			System.out.print("\t"+bean.getChemistry());
			System.out.println("\t"+bean.getMaths());

		}
	}

	private static void testFindByRoll() throws Exception {

		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = model.findByRoll(205);

		if (bean == null) {
			System.out.println("Invallid");
		} else {
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getRollNo());
			System.out.println(bean.getPhysics());
			System.out.println(bean.getChemistry());
			System.out.println(bean.getMaths());
		}

	}

	private static void testDelete(int id) throws Exception {

		MarksheetModel model = new MarksheetModel();

		model.delete(id);

	}

	private static void testUpdate() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setId(1);
		bean.setName("jatin");
		bean.setRollNo(202);
		bean.setPhysics(76);
		bean.setChemistry(88);
		bean.setMaths(67);

		MarksheetModel model = new MarksheetModel();
		model.update(bean);

	}

	private static void testAdd() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setId(19);
		bean.setName("surbhi");
		bean.setRollNo(249);
		bean.setPhysics(44);
		bean.setChemistry(47);
		bean.setMaths(48);

		MarksheetModel model = new MarksheetModel();
		model.add(bean);
	}

}
