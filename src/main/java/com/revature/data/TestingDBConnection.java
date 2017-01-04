package com.revature.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.exec.ExecuteException;

public class TestingDBConnection {
	private Connection conn;
	private static final String URL = "jdbc:oracle:thin:@orcl.c7mfdglx6mgu.us-west-2.rds.amazonaws.com:1521:orcl";
	private static final String USER = "demo";
	private static final String PASS = "welcome1";

	public TestingDBConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection(URL, USER, PASS);
	}
	
	public void selectTest() throws SQLException{
		String sql="Select * from USER_ROLE";
		PreparedStatement stmt= conn.prepareStatement(sql);
		ResultSet set = stmt.executeQuery();
		while(set.next()){
			System.out.println(set.getString(2));
		}
	}
	
	public void close() throws SQLException{
		conn.close();
	}
}
