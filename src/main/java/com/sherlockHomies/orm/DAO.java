package com.sherlockHomies.orm;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *  Using a Session Factory, opens a session to allow insertion of data onto our relational database.
 *  
 */

@Repository(value="dao")
@Scope(value="prototype") 
public class DAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void insert(Object obj){
		sessionFactory.getCurrentSession().saveOrUpdate(obj);
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void update(Object obj){
		sessionFactory.getCurrentSession().update(obj);
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void delete(Object obj){
		sessionFactory.getCurrentSession().delete(obj);
	}
	
/*	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void selectAppointment(Object obj){
		sessionFactory.getCurrentSession().delete(obj);
	}*/
	
}

