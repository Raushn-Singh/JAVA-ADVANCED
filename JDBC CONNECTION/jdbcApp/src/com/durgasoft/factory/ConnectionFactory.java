package com.durgasoft.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
private static Connection con;
static {
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system","raushan");
	}catch(Exception e) {
		e.printStackTrace();
	}
	}

public static Connection getConnection() {
	return con;
}
}
