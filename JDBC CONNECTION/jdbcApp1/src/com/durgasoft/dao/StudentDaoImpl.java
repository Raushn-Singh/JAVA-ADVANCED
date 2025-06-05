package com.durgasoft.dao;

import com.durgasoft.beans.Student;
import com.durgasoft.factory.ConnectionFactory;
import java.sql.*;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String add(Student std) {
	    String status="";
	    try {
	    	Connection conn=ConnectionFactory.getConnection();
	    	Statement st=conn.createStatement();
	    	ResultSet rs= st.executeQuery("select * from student where SID="+"'"+std.getSid()+"'");
	    	boolean b= rs.next();
	    	if(b==true) {
	    		// working
	    	}else {
	    		
	    	}
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
		return null;
	}

	@Override
	public String search(String sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(String sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String sid) {
		// TODO Auto-generated method stub
		return null;
	}

}
