package com.sherlockHomies.orm;

import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sherlockHomies.beans.Appointment;
import com.sherlockHomies.beans.Invoice;
import com.sherlockHomies.beans.Pet;
import com.sherlockHomies.beans.Rating;
import com.sherlockHomies.beans.User;

public class DAOTest {

	private static ApplicationContext ctxt;
	
	@BeforeClass
	public static void setup(){
		ctxt = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
	}
	
	/**
	 * Tested methods:
	 * 	UserDAO
	 * 		getAll
	 * 		getbyId
	 */
	
	@Test
	public void testAddAppt(){
		Timestamp timestamp = null;
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		    Date parsedDate = dateFormat.parse("02-02-2017");
		    timestamp = new java.sql.Timestamp(parsedDate.getTime());
		    System.out.println(timestamp.toString());
		}catch(Exception e){}
		Appointment appt = ctxt.getBean(Facade.class).createAndInsertAppt(3, 1, 1, "Funny walk", timestamp);
		System.out.println(appt);
	}
	
	@Test
	@Ignore
	public void testCompletedAppt(){
		/*List<Appointment> appts = ctxt.getBean(AppointmentDAO.class).getAppointmentsBeforeTodayByUser(3);*/
		List<Appointment> appts = ctxt.getBean(Facade.class).getPastAppointmentsByUser(3);
		System.out.println(appts);
	}
	
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
	public void testUserGetByRole(){
		List<User> users=ctxt.getBean(UserDAO.class).getUsersByRole("Vet");
		System.out.println(users);
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
	
	@Ignore
	@Test
	public void testAppointmentGetAll(){
		List<Appointment> appt = ctxt.getBean(AppointmentDAO.class).getAll();
		System.out.println(appt);
	}
	
	@Ignore
	@Test
	public void getAppointmentById(){
		Appointment appt = ctxt.getBean(AppointmentDAO.class).getById(1);
		System.out.println(appt);
	}
	
	@Ignore
	@Test
	public void testInvoiceGetAll(){
		List<Invoice> invs = ctxt.getBean(InvoiceDAO.class).getAll();
		System.out.println(invs);
	}
	
	@Ignore
	@Test
	public void testInvoiceGetById(){
		Invoice inv = ctxt.getBean(InvoiceDAO.class).getById(31);
		System.out.println(inv);
	}
	
	@Ignore
	@Test
	public void testRatingGetAll(){
		List<Rating> ratings = ctxt.getBean(RatingDAO.class).getAll();
		System.out.println(ratings);
	}
	
	@Ignore
	@Test
	public void testRatingGetById(){
		Rating r = ctxt.getBean(RatingDAO.class).getRatingById(1);
		System.out.println(r);
	}
	
	@Ignore
	@Test
	public void testPetByType(){
		List<Pet> pet = ctxt.getBean(PetDAO.class).getByType(1);
		System.out.println(pet);
	}
	
	@Ignore
	@Test
	public void testPetByUser(){
		List<Pet> pet = ctxt.getBean(PetDAO.class).getByUser("pusheen");
		System.out.println(pet);
	}
	
	@Ignore
	@Test
	public void testInvoiceByUsername(){
		List<Invoice> invoices = ctxt.getBean(InvoiceDAO.class).getByUsername("pusheen");
		System.out.println(invoices);
	}
	
	@Ignore
	@Test
	public void testRatingByUsername(){
		List<Rating> ratings = ctxt.getBean(RatingDAO.class).getRatingByUser("pusheen");
		System.out.println(ratings);
	}
	
	@Ignore
	@Test
	public void testRatingByVet(){
		List<Rating> ratings = ctxt.getBean(RatingDAO.class).getRatingByVet("123unicorn");
		System.out.println(ratings);
	}
	
	@Ignore
	@Test
	public void testAppointmentByUser(){
		List<Appointment> appt = ctxt.getBean(AppointmentDAO.class).getAppointmentByUsername("pusheen");
		System.out.println(appt);
	}
	
	@Ignore
	@Test
	public void testAppointmentByPet(){
		List<Appointment> appt = ctxt.getBean(AppointmentDAO.class).getAppointmentByPet("Cucumber");
		System.out.println(appt);
	}
	
	@Ignore
	@Test
	public void testAppointmentByVet(){
		List<Appointment> appt = ctxt.getBean(AppointmentDAO.class).getAppointmentByVet("123unicorn");
		System.out.println(appt);
	}
	
	@Ignore
	@Test
	public void testPetByType2(){
		List<Pet> pets = ctxt.getBean(PetDAO.class).getByType("chicken");
		System.out.println(pets);
	}

}
