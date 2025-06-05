package com.durgasoft.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbc5 {

	public static void main(String[] args) {
		
		Connection con= null;
		Statement st= null;
		BufferedReader br=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system","raushan");
			st=con.createStatement();
			br=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter the table name :");
			String tname=br.readLine();
			String query="CREATE TABLE"+" "+tname+"(";
			int primarykeycount=0;
			String primarykeys="";
			while(true) {
				System.out.print("Enter the column name ");
				String colname=br.readLine();
				System.out.print("Enter column Type:");
				String coltype=br.readLine();
				System.out.print("Enter the column size");
				int colsize=Integer.parseInt(br.readLine());
				query=query+colname+" "+coltype+"("+colsize+")";
				System.out.println("is primary [yes/no] :");
				String primarykeysoption=br.readLine();
				if(primarykeysoption.equalsIgnoreCase("yes")) {
		           if(primarykeycount==0) {
		        	   primarykeys=primarykeys+colname;
		        	   primarykeycount++;
		           }else {
		        	   primarykeys=primarykeys+","+colname;
		           }
				}
				
				System.out.print("one more coulmn[yes/no]");
				String coloption=br.readLine();
				if(coloption.equalsIgnoreCase("yes")) {
					query=query+",";
					continue;
				}else {
					query=query+","+"primary key"+"("+primarykeys+"))";
					break;
				}
				
				
				
				
			}
			System.out.print(query);
			
			st.executeUpdate(query);
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			br.close();
			st.close();
			con.close();
			
			}catch(Exception e){
				e.printStackTrace();
			}
		}

	}

}
