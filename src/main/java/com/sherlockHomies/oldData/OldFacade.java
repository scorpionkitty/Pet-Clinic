package com.sherlockHomies.oldData;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sherlockHomies.beans.User;
import com.sherlockHomies.data.HibernateSessionUtility;


/**
 * 
 * @author David Sibrian
 * The facade class in charge of calling all the DAO classes
 *
 */
@Component(value="facade")
public class OldFacade {

	private SessionFactory sf;
	private ApplicationContext context;
	
	public OldFacade() {
		//get an instance of session factory
		sf = new HibernateSessionUtility().getSessionFactory();
	}
		
	//CRUD OPERATIONS START
	public List<User> getAllVets() {
		
		//SessionFactory call goes here
		Session session = sf.openSession();
		
		//Transaction
		OldUserDAO dao = context.getBean("userdao", OldUserDAO.class);
		dao.setSession(session);
		
		//DAO
		List<User> vetUsers = dao.getAll();
		session.close();
		
		return vetUsers;
	}
	
}
