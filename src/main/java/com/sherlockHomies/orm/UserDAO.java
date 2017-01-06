package com.sherlockHomies.orm;

import java.util.List;

import org.hibernate.SessionFactory;

import com.sherlockHomies.beans.User;

public class UserDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<User> getAll(){
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

}
