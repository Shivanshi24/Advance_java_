package in.rays.com.user;

import java.util.*;

public class Ddate {
	public static void main(String[] args) {
		
		Date today = new Date();
		
		System.out.println("date = " + today);
		
		//getTime means it counts day from 1 jan 1970 till today
		System.out.println("long date = " + today.getTime());
		
		//get time method convert date into long
		System.out.println("sql date = " + new java.sql.Date(today.getTime()));
		
		
	}

}
