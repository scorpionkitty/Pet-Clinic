package com.sherlockHomies.orm;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sherlockHomies.beans.Invoice;
import com.sherlockHomies.beans.Rating;

public class RatingDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<Rating> getAll() {
		return sessionFactory.openSession().createCriteria(Rating.class).list();
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Rating getRatingById(int id){
		return (Rating) sessionFactory.openSession().get(Rating.class, id);
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public List<Rating> getRatingByUser(String username){
		String HQL = "select R from Rating R join R.appt A join A.pet P join P.owner U where U.username= :u";
		Query query = sessionFactory.getCurrentSession().createQuery(HQL);
		query.setString("u", username);
		return query.list();
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public List<Rating> getRatingByVet(String vetname){
		String HQL = "select R from Rating R join R.appt A join A.vet V where V.username= :v";
		Query query = sessionFactory.getCurrentSession().createQuery(HQL);
		query.setString("v", vetname);
		return query.list();
	}
	

}
