package com.sherlockHomies.web;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.sherlockHomies.beans.Appointment;
import com.sherlockHomies.beans.User;
import com.sherlockHomies.orm.Facade;

@Service(value="businessDelegate")
public class BusinessDelegate implements ApplicationContextAware{

	private Facade facade;
	private ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}
	
	/////////// USER ///////////
	/**
	 * Returns a user when given a username, if username is found
	 */
	public User findUser(String username) {
		User user = facade.getUser(username);
		if(user == null){
			System.out.println("User not found");
			return null;
		}
		return user;
	}
	
	/**
	 * Returns a user when given userId
	 */
	public User getUserById(int id) {
		return context.getBean(Facade.class).getUser(id);
	}
	
	/**
	 * Returns if the owner is a vet or not when given a user
	 */
	public boolean isVet(User user){
		if(facade.userRole(user) == "Vet")
			return true;
		else return false;
	}
	
	//TODO deleted List<User> vets = context.getBean(Facade.class).getUserByRole("Vet");
	public List<User> getAllVets() { //TODO Dont need
		return context.getBean(Facade.class).getUsersByRole("Vet");
	}

	//////////////// Appointment ////////////////////
	
	/**
	 * Inserts an appointment when given a user Id, vet Id, pet Id, description, appt date, and card number
	 */
	public void insertAppt(int userId, int vetId, int petId, String description, String apptDate, 
			String cardNumber){
		facade.createAndInsertAppt(userId, vetId, petId, description, apptDate, cardNumber);
	}

/*	public List<User> getVetsOfASpecialty(String petType) { TODO
		facade.
	}*/

	public User getUserByUsername(String username) {
		return facade.getUser(username);
	}
	
	/*public List<Appointment> getApptById(int apptId){
		List<Appointment> listAppt;
		return listAppt.add(context.getBean(Facade.class).getAppointmentById(apptId));
	}*/

	
}
