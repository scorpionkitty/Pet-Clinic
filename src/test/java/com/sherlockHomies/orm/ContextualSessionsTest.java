package com.sherlockHomies.orm;

import java.sql.Timestamp;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sherlockHomies.beans.Appointment;
import com.sherlockHomies.beans.Invoice;
import com.sherlockHomies.beans.Pet;
import com.sherlockHomies.beans.PetType;
import com.sherlockHomies.beans.Rating;
import com.sherlockHomies.beans.User;
import com.sherlockHomies.beans.UserRole;

/**
 * Creates and tests our DAO beans using Hibernate ORM framework to map to our relational database. 
 * @author Karina Macancela
 *
 */

public class ContextualSessionsTest {

	private static ApplicationContext contxt;
	private static int userRoleId = 0;
	private static int userId = 0;
	private static int petTypeId = 0;
	private static int petId = 0;
	private static int apptId = 0;
	private static int invoiceId = 0;
	private static int ratingId = 0;
	
	@BeforeClass
	public static void setup(){
		contxt = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	/**
	 * Creates eight tables in our database: 
	 * 		Appointment, Users, User_Role, Invoice, Pet, Pet_Type, Specialization, Rating
	 * and populates them with data, printing 'Success!' to the console.
	 */
	
	@Test
	public void create(){
		UserRole vet = new UserRole(++userRoleId, "Vet");
		UserRole owner = new UserRole(++userRoleId, "Owner");
		contxt.getBean(DAO.class).insert(vet);
		contxt.getBean(DAO.class).insert(owner);
		
		User vet1 = new User(++userId, "123unicorn", "Tim", "Miller", "718-445-4444", "tmiller@vet.com", vet);
		User vet2 = new User(++userId, "burgers4me", "Jessica", "Adams", "718-900-8790", "jadams@gmail.com", vet);
		contxt.getBean(DAO.class).insert(vet1);
		contxt.getBean(DAO.class).insert(vet2);
		
		PetType cat = new PetType(++petTypeId, "cat");
		PetType chicken = new PetType(++petTypeId, "chicken");
		contxt.getBean(DAO.class).insert(cat);
		contxt.getBean(DAO.class).insert(chicken);
		
		User owner1 = new User(++userId, "pusheen", "Alex", "Franks", "917-225-6789", "afranks@gmail.com", owner);
		User owner2 = new User(++userId, "witcher", "Liz", "Torres", "347-789-0098", "ltorres@gmail.com", owner);
		contxt.getBean(DAO.class).insert(owner1);
		contxt.getBean(DAO.class).insert(owner2);
		
		Pet pet1 = new Pet(++petId, "Mr. Jenkins", owner1, chicken);
		Pet pet2 = new Pet(++petId, "Cucumber", owner2, cat);
		contxt.getBean(DAO.class).insert(pet1);
		contxt.getBean(DAO.class).insert(pet2);
		
		java.util.Date today = new java.util.Date();
		Timestamp placedDate = new java.sql.Timestamp(today.getTime());
		Timestamp apptDate = new java.sql.Timestamp(01-10-17);
		Appointment appt1 = new Appointment(++apptId, vet1, pet1, "Has a cold.", placedDate, apptDate);
		appt1.setPrescription("Get some sleep.");
		contxt.getBean(DAO.class).insert(appt1);
		
		Invoice invoice1 = new Invoice(++invoiceId, 40.00, appt1, false, "1234567890", null);
		contxt.getBean(DAO.class).insert(invoice1);
		
		Rating rating1 = new Rating(++ratingId, 4, appt1, "Loved it!");
		contxt.getBean(DAO.class).insert(rating1);
		
		System.out.println("Success!");
	}
}