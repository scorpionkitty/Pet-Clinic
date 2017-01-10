package com.sherlockHomies.orm;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.sherlockHomies.beans.Appointment;

@Repository(value="apptDao")
@Scope(value="prototype")
public class AppointmentDAO {
	
	private static int freeAptId = 1; //TODO Must fix!
	private UserDAO userDAO = null;
	private PetDAO petDAO = null;
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//Get all appointments as a list
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public List<Appointment> getAll(){
		return sessionFactory.getCurrentSession().createCriteria(Appointment.class).list();
	}
	
	//Get appointment by apptId...might delete this TODO
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public Appointment getById(int id){
		return (Appointment) sessionFactory.getCurrentSession().get(Appointment.class, id);
	}
	
	//Get all appointments as a list of a pet owner
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public List<Appointment> getAppointmentByUsername(String username){
		String HQL = "select A from Appointment A join A.pet P join P.owner U where U.username= :u";
		Query query = sessionFactory.getCurrentSession().createQuery(HQL);
		query.setString("u", username);
		return query.list();
	}
	
/*	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public List<Appointment> createAppt(int userId, String description, String cardNumber) {
		String HQL ="";
		Query query = sessionFactory.getCurrentSession().createQuery(HQL);
		query.setString("u", username);
		return query.list;
		
		//
		Appointment appt = new Appointment(userId, vet, pet, description, placedDate, apptDate)
		// open a session.. always use Session-per-HTTP-request
		Session session = sf.openSession();
				// begin a transaction
		Transaction tx = session.beginTransaction();
				// save the object
		session.save(appt);
				// commit
		tx.commit();
				// always close sessions before we send HTTP response
		session.close();
	}*/

	//Create an Appointment object
	//TODO Should make a trigger
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public Appointment createAppt(int ownerId, int vetId, int petId, String description, Timestamp currentTimeStamp,
			Timestamp apptDate) {
		return new Appointment(++freeAptId, userDAO.getById(vetId), petDAO.getById(petId), description, currentTimeStamp, apptDate);
	}
	
	//TODO get by pet
}
