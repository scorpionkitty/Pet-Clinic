package com.sherlockHomies.data;

import java.util.List;

import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.sherlockHomies.beans.Pet;

/**
 * DAO that performs crud operations on appointments
 * will add more methods as we go on
 * @author Sam
 *
 */
@Repository(value="appointmentdao")
@Scope(value="prototype")
public class PetDAO {
	
	private Session session;

	public Pet getAppointment(int id){
		return (Pet) session.get(Pet.class, id);
	}
	
	public void setSession(Session session){
		this.session = session;
	}
	
	public List<Pet> getAll(){
		return session.createCriteria(Pet.class).list();
	}
	
	//TODO add get pet by owner;
	
	public void insert(Pet pet){
		session.save(pet);
	}

}
