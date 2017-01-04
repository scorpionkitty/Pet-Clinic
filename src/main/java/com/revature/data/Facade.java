package com.revature.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.sherlockHomies.beans.User;


@Component(value="facade")
public class Facade {

	private SessionFactory sf;
	private ApplicationContext context;
	
	public Facade() {
		//get an instance of session factory
		sf = new HibernateSessionUtility().getSessionFactory();
	}
		
	//CRUD OPERATIONS START
	public List<User> getVetBySpecialty() {
		
		//SessionFactory call goes here
		Session session = sf.openSession();
		
		//Transaction
		VetDAO dao = context.getBean("vetdao", VetDAO.class);
		dao.setSession(session);
		
		//DAO
		//List<User> vet = VetDAO.getAll();
		
		
		return null;
	}
	
}
