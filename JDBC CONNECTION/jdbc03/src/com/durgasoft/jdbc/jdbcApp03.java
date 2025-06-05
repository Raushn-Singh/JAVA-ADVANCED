package com.durgasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class jdbcApp03 {

	public static void main(String[] args) {
		
		Connection con=null;
		Statement st=null;
		Scanner sc=null;
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system","raushan");
			st=con.createStatement();
			sc=new Scanner(System.in);
			System.out.print("enter salary");
			float esalrange=sc.nextFloat();
			int rowcount=st.executeUpdate("delete from emp5 where ESAL<"+esalrange);
			System.out.println("succesfully deleted"+rowcount);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
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
