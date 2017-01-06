package com.sherlockHomies.orm;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sherlockHomies.beans.Pet;
import com.sherlockHomies.beans.User;

public class DAOTest {

	private static ApplicationContext ctxt;
	
	@BeforeClass
	public static void setup(){
		ctxt = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	/**
	 * Tested methods:
	 * 	UserDAO
	 * 		getAll
	 * 		getbyId
	 */
	
	@Ignore
	@Test
	public void testUserGetAll(){
		List<User> users = ctxt.getBean(UserDAO.class).getAll();
		System.out.println(users);
	}
	
	@Ignore
	@Test
	public void testUserGetById(){
		User userman = ctxt.getBean(UserDAO.class).getById(1);
		System.out.println(userman);
	}
	
	@Ignore
	@Test
	public void testPetGetAll(){
		List<Pet> pets = ctxt.getBean(PetDAO.class).getAll();
		System.out.println(pets);
	}
	
	@Ignore
	@Test
	public void testPetGetById(){
		Pet pet = ctxt.getBean(PetDAO.class).getById(3);
		System.out.println(pet);
	}
}
