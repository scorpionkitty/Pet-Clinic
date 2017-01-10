package com.sherlockHomies.web;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sherlockHomies.beans.Appointment;
import com.sherlockHomies.beans.User;
import com.sherlockHomies.orm.Facade;

@Service(value="businessDelegate")
public class BusinessDelegate {

	//@Autowired
	private Facade facade;
	@Autowired
	public void setFacade(Facade facade) {
		this.facade = facade;
	}
	
	//returns a User object when given userId
	public User getUserById(int id) {
		User user = facade.getUser(id);
		if(user == null){
			System.out.println("User not found");
			return null;
		}
		return user;
	}

	//returns if the owner i
	public boolean isVet(User user){
		if(facade.userRole(user) == "Vet")
			return true;
		else return false;
	}
	
	public List<User> getAllVets() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public User findUser(String username) {
		User user = facade.getUser(username);
		if(user == null){
			System.out.println("User not found");
			return null;
		}
		return user;
	}

	public void insertAppt(int userId, int vetId, int petId, String description, String apptDate, String cardNumber){
		facade.createAndInsertAppt(userId, vetId, petId, description, apptDate, cardNumber);
		//facade.insertAppt(appt);
	}

	public User getVetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
