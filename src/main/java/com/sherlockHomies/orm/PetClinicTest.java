package com.sherlockHomies.orm;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sherlockHomies.beans.Appointment;
import com.sherlockHomies.beans.User;

public class PetClinicTest {
	
	private static ApplicationContext ctxt;

	public static void setup(){
		ctxt = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
	}
	
	public static void main(String[] args) {
		//setup();
		User u = ctxt.getBean(Facade.class).getUser(3);
		System.out.println(u);
		
		List<Appointment> result = ctxt.getBean(Facade.class).getAllOwnerAppt(ctxt.getBean(Facade.class).getUser(1));
		for(Appointment r : result){
			System.out.println(r);
		}
	}
}
