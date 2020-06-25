package com.code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		//String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker";
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimeZone=UTC";
		String user ="hbstudent";
		String password ="hbstudent";
		try {
			System.out.println("Connecting to Database..."+ jdbcUrl);
			Connection con = DriverManager.getConnection(jdbcUrl,user,password);
			System.out.println("Connection Successful");
			
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			
		}
		
		finally {
			
		}
	}

}
