package com.sherlockHomies.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sherlockHomies.beans.User;
import com.sherlockHomies.orm.Facade;

@Service(value="businessDelegate")
public class BusinessDelegate {

	//@Autowired
	private Facade facade;
	public void setFacade(Facade facade) {
		this.facade = facade;
	}
	
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getVetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getAllVets() {
		// TODO Auto-generated method stub
		return null;
	}

}
