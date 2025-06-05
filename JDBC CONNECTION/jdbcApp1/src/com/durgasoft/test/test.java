package com.durgasoft.test;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import com.durgasoft.beans.*;
import com.durgasoft.factory.StudentServiceFactory;
import com.durgasoft.service.StudentService;
public class test {

	public static void main(String[] args) {
		
try {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	while(true) {
	System.out.println("1. ADD");
	System.out.println("2. SEARCH");
	System.out.println("3. UPDATE");
	System.out.println("4. DELETE");
	System.out.println("5. EXIT");
	System.out.print("Enter [1, 2, 3, 4, 5]");
	int option=Integer.parseInt(br.readLine());
	String sid="",sname="",saddr="";
	StudentService studentservice=StudentServiceFactory.getStudentService();
	switch(option){
	case 1 :
		System.out.println("Enter student ID");
		sid=br.readLine();
		System.out.print("Enter Student Name");
		sname=br.readLine();
		System.out.print("Enter the Address");
		saddr=br.readLine();
	    Student st=new Student();
	    st.setSid(sid);
	    st.setSname(sname);
	    st.setSaddr(saddr);
	    
	    String status=studentservice.addStudent(st);
	    System.out.print("Status :" +status);
	    
		
		break;
	case 2:
		break;
	case 3:
		break;
	case 4:
		break;
	case 5:
		break;
    default :
    	break;
		
	}
	}
	
}catch(Exception e) {
	e.printStackTrace();
}
	}
	
}
