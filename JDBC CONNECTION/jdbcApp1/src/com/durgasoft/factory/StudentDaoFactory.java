package com.durgasoft.factory;

import com.durgasoft.dao.StudentDao;
import com.durgasoft.dao.StudentDaoImpl;

public class StudentDaoFactory {
private static StudentDao studentdao;
static {
	studentdao=new StudentDaoImpl();
}

public static StudentDao getStudentDao() {
	return studentdao;
}

}
