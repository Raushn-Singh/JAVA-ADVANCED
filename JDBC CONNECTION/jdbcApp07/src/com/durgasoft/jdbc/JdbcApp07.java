package com.durgasoft.jdbc;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

// Dynamic Input of sql quaries in database 



public class JdbcApp07 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		BufferedReader br=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system","raushan");
			st=con.createStatement();
			br=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter Query : ");
			String query=br.readLine();
			boolean b=st.execute(query);
			if(b==true) {
				rs=st.getResultSet();
				ResultSetMetaData md= rs.getMetaData();
				int count=md.getColumnCount();
				for(int i=1; i<=count; i++) {
					System.out.print(md.getColumnName(i)+"\t");
				}
				
				System.out.println();
				while(rs.next()) {
					for(int i=1; i<=count; i++) {
						System.out.print(rs.getString(i)+"\t");
					}
					System.out.println();
				}
			}else {
				int rowcount=st.getUpdateCount();
				System.out.println("rowcount"+rowcount);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				br.close();
				
				
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		

	}

}

















