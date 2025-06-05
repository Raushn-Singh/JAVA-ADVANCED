package com.durgasoft.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcApp01 {
      public static void main(String args[]) {
    	  Connection conn=null;
    	  Statement st=null;
    	  BufferedReader br=null;
    	  try {
    		  
    		  Class.forName("oracle.jdbc.OracleDriver");

    		   conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system","raushan");
    	
    		  st=conn.createStatement();
    		  System.out.println("name");
    		  br=new BufferedReader(new InputStreamReader(System.in));
    		  
    		  while(true) {
    			  System.out.print("Enter employee id");
    			  int eno=Integer.parseInt(br.readLine());
    			  System.out.print("Enter the employee name");
    			  String ename =br.readLine();
    			  System.out.println("Enter employee salary");
    			  float esal=Float.parseFloat(br.readLine());
    			  System.out.println("Enter the employee address");
    			  String eaddr=br.readLine();
    			  String query = "insert into emp5 values (" + eno + ", '" + ename + "', " + esal + ", '" + eaddr + "')";

    			 System.out.print("ram");
    			  st.executeUpdate(query);
    			  System.out.print("Succesfully inserted employee");
    			  System.out.print("one more employee [yes/no]? : ");
    			  String option =br.readLine();
    			  if(option.equalsIgnoreCase("yes")) {
    				  continue;
    			  }else {
    				  break;
    			  }
    		  }
    	  }catch(Exception e) {
    		 
    	  }
    	  finally {
    		  try {
    		  br.close();
    		  st.close();
    		  conn.close();
    		  }catch(Exception e) {
    			  e.printStackTrace();
    		  }
    	  }
      }
}
