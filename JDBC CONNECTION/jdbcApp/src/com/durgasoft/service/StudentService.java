package com.durgasoft.service;

import com.durgasoft.beans.Student;

public interface StudentService {
  public String addStudent(Student std);
  public String updateStudent(Student std);
  public Student searchStudent(String sid);
  public String deletestudent(String sid);
}
