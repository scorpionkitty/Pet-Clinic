package com.sherlockHomies.web;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.sherlockHomies.beans.Appointment;
import com.sherlockHomies.beans.User;
import com.sherlockHomies.orm.Facade;

@Service(value="businessDelegate")
public class BusinessDelegate {

	@Autowired
	private Facade facade;
	
	private ClassPathXmlApplicationContext context;
	
	public void setFacade(Facade facade) {
		this.facade = facade;
	}
	
	
	public void setup(){
		context = new ClassPathXmlApplicationContext("beans.xml");
	}

	//returns a User object when given userId
	public User getUserById(int id) {
		setup();
		User user = context.getBean(Facade.class).getUser(id);//.facade.getUser(id);
		if(user == null){
			System.out.println("User not found");
			return null;
		}
		return user;
	}

	//returns if the owner i
	public boolean isVet(User user){
		setup();
		if(facade.userRole(user) == "Vet")
			return true;
		else return false;
	}
	
	public List<User> getAllVets() {
		setup();
		List<User> vets = context.getBean(Facade.class).getUserByRole("Vet");
		return vets;
	}

	
	public User findUser(String username) {
		setup();
		User user = facade.getUser(username);
		if(user == null){
			System.out.println("User not found");
			return null;
		}
		return user;
	}

	public void insertAppt(int userId, int vetId, int petId, String description, String apptDate, String cardNumber){
		setup();
		facade.createAndInsertAppt(userId, vetId, petId, description, apptDate, cardNumber);
		//facade.insertAppt(appt);
	}

	public User getVetById(int id) {
		setup();
		User user = context.getBean(Facade.class).getUser(id);
		if(user.getUserRole().getUserRole().equalsIgnoreCase("vet")){
			return user;
		}else
			return null;
	}

}
