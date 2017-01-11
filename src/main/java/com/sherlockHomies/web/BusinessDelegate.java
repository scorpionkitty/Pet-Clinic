package com.sherlockHomies.web;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

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

	//returns if the owner is a vet or not
	public boolean isVet(User user){
		if(facade.userRole(user) == "Vet")
			return true;
		else return false;
	}
	
	public List<User> getAllVets() {
		List<User> vets = context.getBean(Facade.class).getUserByRole("Vet");
		return vets;
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
	}

	//returns a User object when given userId
	public User getUserById(int id) {
		User user = context.getBean(Facade.class).getUser(id);
		if(user == null){
			System.out.println("User not found");
			return null;
		}
		return user;
	}
	
/*	public User getVetById(int id) {
		User user = context.getBean(Facade.class).getUser(id);
		if(user.getUserRole().getUserRole().equalsIgnoreCase("vet")){
			return user;
		}else
			return null;
	}*/
}
