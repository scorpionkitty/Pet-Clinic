package com.sherlockHomies.web;

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
	
	public User getUserById(int id) {
		return facade.getUser(id);
	}

	public boolean ownerOrVet(String username){
		return facade.userRole(username);
	}
	
	public List<User> getAllVets() {
		// TODO Auto-generated method stub
		return null;
	}

	public User findUser(String username) {
		User user = facade.getUser(username);
		if(user == null){
			System.out.println("User not found");
		}
	}

	public void insertAppt(int userId, String description, String cardNumber){
		Appointment appt = facade.createAppt(userId, description, cardNumber);
		facade.insertAppt(appt);
	}
}
