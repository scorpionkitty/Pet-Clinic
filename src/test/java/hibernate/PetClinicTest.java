package hibernate;

import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import beans.Appointment;
import beans.Pet;
import beans.PetType;
import beans.Specialization;
import beans.User;
import beans.UserRole;

public class PetClinicTest {

	private SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	@Test
	public void testMappings(){
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		UserRole vet = new UserRole("Vet");
		UserRole owner = new UserRole("Pet owner");
		
		User vet1 = new User("123unicorn", "Tim", "Miller", "718-445-4444", "tmiller@vet.com", vet);
		User vet2 = new User("burgers4me", "Jessica", "Adams", "718-900-8790", "jadams@gmail.com", vet);
		
		PetType cat = new PetType("cat");
		PetType chicken = new PetType("chicken");
		
		Specialization timCat = new Specialization(vet1, cat);
		Specialization timChicken = new Specialization(vet1, chicken);
		Specialization jessicaCat = new Specialization(vet2, cat);
		
		User owner1 = new User("pusheen", "Alex", "Franks", "917-225-6789", "afranks@gmail.com", owner);
		User owner2 = new User("witcher", "Liz", "Torres", "347-789-0098", "ltorres@gmail.com", owner);
		
		Pet pet1 = new Pet("Mr. Jerkins", owner1, chicken);
		Pet pet2 = new Pet("Cucumber", owner2, cat);
		
		java.util.Date today = new java.util.Date();
		Timestamp placedDate = new java.sql.Timestamp(today.getTime());
		Timestamp apptDate = new java.sql.Timestamp(01-10-17);
		
		Appointment appt1 = new Appointment(vet1, pet1, "Has a cold.", placedDate, apptDate);
		
		
	}
}
