package com.durgasoft.service;

import com.durgasoft.beans.Student;

public interface StudentService {
     public String addStudent(Student std);
     public String searchStudent(Student sid );
     public String updateStudent(Student sid);
     public String deleteStudent(Student sid);
	
	
	
}
