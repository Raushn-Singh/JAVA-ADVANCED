package com.durgasoft.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.durgasoft.beans.Student;
import com.durgasoft.factory.StudentServiceFactory;
import com.durgasoft.service.StudentService;


public class Test {
   public static void main(String args[]) {
	   try {
		   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		  while(true) {
			 System.out.print("1. ADD");
			 System.out.print("2. SEARCH");
			 System.out.print("3. UPDATE");
			 System.out.print("4. DELETE");
             System.out.print("5. EXIT");
             System.out.print("your option is [1,2,3,4,5] :");
             int option =Integer.parseInt(br.readLine());
             String sid="",sname="",saddr="";

        	 StudentService studentservice=StudentServiceFactory.getStudentService();
             switch(option) {
             case 1:
            	 System.out.print("Student id :");
            	 sid=br.readLine();
            	 System.out.print("Student Name :");
            	  sname=br.readLine();
            	 System.out.print("Student Address");
            	  saddr=br.readLine();
            	 Student std=new Student();
            	 std.setSid(sid);
            	 std.setSname(sname);
            	 std.setSaddr(saddr);
            	 String status=studentservice.addStudent(std);
            	 System.out.print("Status :"+status);
            	 
            	 break;
            	 
             case 2 :
            	 System.out.print("Enter Student id");
            	 sid=br.readLine();
            	 std=studentservice.searchStudent(sid);
            	 if(std==null) {
            		 System.out.print("Student not Exsited");
            	 }else {
            		 System.out.println("Student Details");
            		 System.out.println("------------------------------");
            		 System.out.print("Student Id"+std.getSid());
            		 System.out.print("Student Name "+std.getSname());
            		 System.out.print("student Address"+std.getSaddr());
            	 }
            	 break ;
             case 3:
            	 System.out.print("Student ID : ");
            	 sid=br.readLine();
            	 std=studentservice.searchStudent(sid);
            	 if(std==null) {
            		 System.out.println("Status : Student does not existed");
            	 }else {
            		 System.out.print("Student Name [old name :"+std.getSname()+"] :");
            		 String sname_New=br.readLine();
            		 if(sname_New==null || sname_New.equals("")) {
            			 sname_New=std.getSname();
            		 }
            		 System.out.print("Student Address [old Address :"+std.getSaddr()+"] :");
            		 String saddr_New=br.readLine();
            		 if(saddr_New==null || saddr_New.equals(" ")) {
            			 saddr_New=std.getSaddr();
            		 }
            		 
            		 Student std_New=new Student();
            		 std_New.setSid(sid);
            		 std_New.setSname(sname_New);
            		 std_New.setSaddr(saddr_New);
            		 
            		 status=studentservice.updateStudent(std_New);
            		 System.out.print("Status : "+status);
            		 
            		 
            	 }
            	 break;
             case 4:
            	 System.out.print("Student Id");
            	 sid=br.readLine();
            	 std=studentservice.searchStudent(sid);
            	 if(std==null) {
            		 System.out.print("Status : Student not existed");
            	 }else {
            		 status=studentservice.deletestudent(sid);
            		 System.out.print("Status : "+ status);
            	 }
            	 break;
             case 5:
            	 System.out.print("******Thanks for using student Application ");
            	 System.exit(0);
            	 break;
            default :
            	System.out.print("Provide Number from [1,2,3,4,5]");
            	break;
             }
             
             
             
 		  }
	   }catch(Exception e) {
		   
	   }
   }
}
