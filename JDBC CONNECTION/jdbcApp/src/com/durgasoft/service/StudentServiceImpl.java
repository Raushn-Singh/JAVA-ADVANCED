package com.durgasoft.service;

import com.durgasoft.beans.Student;
import com.durgasoft.dao.StudentDao;
import com.durgasoft.factory.StudentDaoFactory;

public class StudentServiceImpl implements StudentService {

	@Override
	public String addStudent(Student std) {
	    StudentDao studentdao=StudentDaoFactory.getStudentDao();
	    String Status=studentdao.add(std);
	    
		return Status;
	}

	@Override
	public String updateStudent(Student std) {
           StudentDao studentdao=StudentDaoFactory.getStudentDao();
           String Status=studentdao.update(std);
		return Status;
	}

	@Override
	public Student searchStudent(String sid) {
		StudentDao studentdao=StudentDaoFactory.getStudentDao();
		Student std=studentdao.search(sid);
		return std;
	}

	@Override
	public String deletestudent(String sid) {
		StudentDao studentdao=StudentDaoFactory.getStudentDao();
		String Status=studentdao.delete(sid);
		return Status;
	}

}
