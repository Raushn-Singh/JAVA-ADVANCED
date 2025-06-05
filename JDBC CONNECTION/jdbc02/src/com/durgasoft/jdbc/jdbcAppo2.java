package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class jdbcAppo2 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		Scanner sc=null;
		try {   		  Class.forName("oracle.jdbc.OracleDriver");
		   con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system","raushan");
			st=con.createStatement();
			sc=new Scanner(System.in);
			System.out.println("Enter the ammount");
			int bonus=sc.nextInt();
			System.out.print("Salary range :");
			float salrange=sc.nextFloat();
			int rowcount=st.executeUpdate("update emp5 set ESAL=ESAL+"+bonus+"where ESAL<"+salrange);
			System.out.println("Employes update"+rowcount);
;		}catch(Exception e) {
			e.printStackTrace();
		}
           finally {
        	   try {
        		   sc.close();
        		   st.close();
        		   con.close();
        	   }catch(Exception e) {
        		   e.printStackTrace();
        	   }
           }
	}

}
