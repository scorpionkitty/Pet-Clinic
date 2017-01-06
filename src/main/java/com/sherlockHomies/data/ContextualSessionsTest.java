package com.sherlockHomies.data;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextualSessionsTest {

	private static ApplicationContext contxt;
	
	@BeforeClass
	public static void setup(){
		contxt = new ClassPathXmlApplicationContext("beans.xml");
	}
	
/*	@Test
	public void create(){
		contxt.getBean(DAO.class).insert(new Card("Spades", 10));
		System.out.println("Success!");
	}*/
}
