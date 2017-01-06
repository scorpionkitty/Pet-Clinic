package com.sherlockHomies.orm;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *  Using a Session Factory, opens a session to allow insertion of data onto our relational database.s
 * @author Karina Macancela
 *
 */

public class DAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void insert(Object obj){
		sessionFactory.getCurrentSession().saveOrUpdate(obj);
	}
	
}

