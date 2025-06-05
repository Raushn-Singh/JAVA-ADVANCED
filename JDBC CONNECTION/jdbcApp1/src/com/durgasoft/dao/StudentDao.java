package com.durgasoft.dao;

import com.durgasoft.beans.Student;

public interface StudentDao {
  public String add(Student std);
  public String search(String sid);
  public String update(String sid);
  public String delete(String sid);
  
}
