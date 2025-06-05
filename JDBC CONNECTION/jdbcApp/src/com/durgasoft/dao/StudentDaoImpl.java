package com.durgasoft.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.durgasoft.beans.Student;
import com.durgasoft.factory.ConnectionFactory;
import com.durgasoft.factory.StudentDaoFactory;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String add(Student std) {
		String Status="";
		try {
			Connection conn=ConnectionFactory.getConnection();
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from student where SID = '"+std.getSid()+"'");
			boolean b=rs.next();
			if(b==true) {
				Status="already existed";
			}else {
				int rowcount=st.executeUpdate("insert into student values('"+std.getSid()+"','"+std.getSname()+"','"+std.getSaddr()+"')");
				if(rowcount==1) {
					Status="Student insertion succesfully";
					
				}else {
					Status ="Student insertion failed";
				}
			}
			
			
			
		}catch(Exception e) {
			Status="Student  Insertion  failure";
			e.printStackTrace();
		}
		return Status;
	}

	@Override
	public Student search(String sid) {
		Student std=null;
		try {
			Connection con =ConnectionFactory.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from student where SID = '"+sid+"'");
			boolean b=rs.next();
			if(b==true) {
				std =new Student();
				std.setSid(rs.getString("SID"));
				std.setSname(rs.getString("SNAME"));
				std.setSaddr(rs.getString("SADDR"));
				
			}else {
				std=null;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return std;
	}

	@Override
	public String update(Student std) {
	String status="";
	try {
		Connection conn=ConnectionFactory.getConnection();
		Statement st=conn.createStatement();
		int rowcount=st.executeUpdate("update student set SNAME = '"+std.getSname()+"',SADDR = '"+std.getSaddr()+"' where SID = '"+std.getSid()+"'");
		
		if(rowcount==1) {
			status="Student Updation Successful";
		}else {
			status="Student Updation Failure";
			
		}
		
		
		
	}catch(Exception e) {
		status="Student Updation failure";
		e.printStackTrace();
	}
		return status;
	}

	@Override
	public String delete(String sid) {
		String Status=" ";
		try {
			Connection conn=ConnectionFactory.getConnection();
			Statement st=conn.createStatement();
			int rowcount=st.executeUpdate("delete from student where SID = '"+sid+"'");
			if(rowcount==1) {
				Status="Student successfully deleted";
				
			}else {
				Status="Student Deletion failure ";
			}
		}catch(Exception e ) {
			Status="student deletion failure";
			e.printStackTrace();
		}
		return Status;
	}

}
