package com.sherlockHomies.orm;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sherlockHomies.beans.Appointment;
import com.sherlockHomies.beans.Invoice;

public class AppointmentDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public List<Appointment> getAll(){
		return sessionFactory.getCurrentSession().createCriteria(Appointment.class).list();
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public Appointment getById(int id){
		return (Appointment) sessionFactory.getCurrentSession().get(Appointment.class, id);
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public List<Appointment> getAppointmentByUsername(String username){
		String HQL = "select A from Appointment A join A.pet P join P.owner U where U.username= :u";
		Query query = sessionFactory.getCurrentSession().createQuery(HQL);
		query.setString("u", username);
		return query.list();
	}
	
	//TODO get by pet
}
