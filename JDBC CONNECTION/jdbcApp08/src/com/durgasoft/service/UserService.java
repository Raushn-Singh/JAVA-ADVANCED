package com.durgasoft.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserService {
	Connection con;
	Statement st;
	ResultSet rs;
	String status;
	
public UserService() {
	try {
		Class.forName("oracle.jdbc.OracleDriver");
        con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system","raushan");
        st=con.createStatement();
        
	
	}catch(Exception e) {
		e.printStackTrace();
	}
}

public String checkLogin(String uname, String upwd) {
	try {
		rs=st.executeQuery("select * from reg_Users where UNAME = '"+uname+"' and UPWD= '"+upwd+"'");
		boolean b=rs.next();
		if(b==true) {
			status="User Login Success";
		}else {
			status="User login failure";
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	return status;
}

}
