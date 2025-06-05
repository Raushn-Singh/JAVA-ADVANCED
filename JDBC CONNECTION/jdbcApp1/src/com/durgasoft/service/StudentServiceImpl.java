package com.durgasoft.service;

import com.durgasoft.beans.Student;
import com.durgasoft.dao.StudentDao;
import com.durgasoft.factory.StudentDaoFactory;

public class StudentServiceImpl implements StudentService {

	@Override
	public String addStudent(Student std) {
		StudentDao studentdao=StudentDaoFactory.getStudentDao();
		String status=studentdao.add(std);
		return status;
	}

	@Override
	public String searchStudent(Student sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateStudent(Student sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteStudent(Student sid) {
		// TODO Auto-generated method stub
		return null;
	}

}
