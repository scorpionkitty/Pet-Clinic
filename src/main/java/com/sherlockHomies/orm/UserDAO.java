package com.sherlockHomies.orm;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sherlockHomies.beans.User;

public class UserDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public List<User> getAll(){
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public User getById(int id){
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

}
