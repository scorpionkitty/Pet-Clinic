package com.sherlockHomies.orm;

import java.util.List;

import org.hibernate.SessionFactory;

import com.sherlockHomies.beans.Appointment;

public class AppointmentDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Appointment> getAll(){
		return sessionFactory.getCurrentSession().createCriteria(Appointment.class).list();
	}

}
