package com.sherlockHomies.orm;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sherlockHomies.beans.User;

@Repository(value="userDao")
@Scope(value="prototype")
public class UserDAO {
	
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public List<User> getAll(){
		//return sessionFactory.getCurrentSession().createCriteria(User.class).list();
		return new ArrayList<User>(sessionFactory.getCurrentSession().createCriteria(User.class).list());
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public User getById(int id){
/*		Session session  = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.idEq(id));
		return (User)criteria.uniqueResult();*/ //TODO delete if still works
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.idEq(id));
		return (User) criteria.uniqueResult();
	}
	
	//TODO Fix this
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public List<User> getUsersByRole(String role){
		String HQL = "select U FROM User U JOIN U.userRole UR WHERE UR.userRole= :r";
		Query query = sessionFactory.getCurrentSession().createQuery(HQL);
		query.setString("r", role);
		return query.list();
	}

	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public User getByUsername(String username) {
		//return (User) sessionFactory.getCurrentSession().get(User.class, username); //TODO works?
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("username", username));
		return (User) criteria.uniqueResult();
	}
	
	
}
