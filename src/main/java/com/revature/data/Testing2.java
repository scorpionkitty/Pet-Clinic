package com.revature.data;

public class Testing2 {
	public static void main(String[] args) throws Exception {
			TestingDBConnection dao = new TestingDBConnection();
			dao.selectTest();
			dao.close();

	}
}
