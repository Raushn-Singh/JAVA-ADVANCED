package com.durgasoft.jdbc;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcApp06 {

	public static void main(String[] args) {
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		FileOutputStream fos=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system","raushan");
			st=conn.createStatement();
			rs=st.executeQuery("select * from emp5");
			
			String data=" ";
			data=data+"<html><body><table border='1'";
			data=data+"<tr><th>ENO</th><th>ENAME</th><th>EADDR</th></tr>";
			while(rs.next()) {
				data=data+"<tr>";
				data=data+"<td>"+rs.getInt("ENO")+"</td>";
				data =data+"<td>"+rs.getString("ENAME")+"</td>";
				data=data+"<td>"+rs.getFloat("ESAL")+"</td>";
				data=data+"</td>"+rs.getString("EADDR")+"</td>";
				
			}
		data=data+"</table></body></html>";
		fos=new FileOutputStream("C:/documents/emp.html");
		byte[] b=data.getBytes();
		fos.write(b);
		System.out.print("data transfered to C:/documents/emp.html");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
			fos.close();
			rs.close();
			st.close();
			conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
