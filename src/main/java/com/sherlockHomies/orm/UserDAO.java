package com.sherlockHomies.orm;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
	
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public List<User> getUserByRole(String role){
		String HQL = "select U FROM User U JOIN U.userRole UR WHERE UR.userRole= :r";
		Query query = sessionFactory.getCurrentSession().createQuery(HQL);
		query.setString("r", role);
		return query.list();
	}
	
	
}
