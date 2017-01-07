package com.sherlockHomies.orm;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *  Using a Session Factory, opens a session to allow insertion of data onto our relational database.s
 * @author Karina Macancela
 *
 */

@Repository(value="dao")
@Scope(value="prototype") 
//@Qualifier("sessionFactory")
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

