package com.sherlockHomies.orm;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sherlockHomies.beans.Appointment;
import com.sherlockHomies.beans.User;

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
	
	//Get all appointments as a list | TODO: Need?
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public List<Appointment> getAll(){
		return sessionFactory.getCurrentSession().createCriteria(Appointment.class).list();
	}
	
	//Get an appointment by apptId
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public Appointment getById(int id){
		return (Appointment) sessionFactory.getCurrentSession().get(Appointment.class, id);
	}
	
	//Get all appointments as a list of a specific pet owner
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public List<Appointment> getAppointmentByUsername(String username){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Appointment.class).add(Restrictions.eq("apptId", username));
		return criteria.list();
	}
/*	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public List<Appointment> getAppointmentByUsername(String username){
		String HQL = "select A from Appointment A " + 
					 "join A.pet P join P.owner U " + 
					 "where U.username= :u";
		Query query = sessionFactory.getCurrentSession().createQuery(HQL);
		query.setString("u", username);
		return query.list();
	}*/
	
/*	DELETE? TODO
 * @Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
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

	//creates an Appointment object given the owner ID, vet ID, pet ID, description, current date, 
	//and appointment date
	//TODO: Should make a trigger
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public Appointment createAppt(int ownerId, int vetId, int petId, String description, 
			Timestamp currentTimeStamp, Timestamp apptDate) {
		return new Appointment(++freeAptId, userDAO.getById(vetId), petDAO.getById(petId), description, 
				currentTimeStamp, apptDate);
	}
	
	//returns a list of appointments of a pet given the pet's name
	//TODO: Need to change parameter to "int petId" instead of "String petname"
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public List<Appointment> getAppointmentByPet(String petname){
		String HQL = "select A from Appointment A " + 
					 "join A.pet P " + 
					 "where P.petName= :pn";
		Query query = sessionFactory.getCurrentSession().createQuery(HQL);
		query.setString("pn", petname);
		return query.list();
	}
	
	//returns a list of appointments of a vet given the vet's username
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public List<Appointment> getAppointmentByVet(String vetname){
		String HQL = "select A from Appointment A " + 
					 "join A.vet V " + 
					 "where V.username=:n";
		Query query = sessionFactory.getCurrentSession().createQuery(HQL);
		query.setString("n", vetname);
		return query.list();
	}
	
	//Deletes an appointment of a particular user
/*	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void deleteApptFromOwner(User user, Appointment appt){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Appointment.class)
				.add(Restrictions.eq("user", user)).add(Restrictions.eq("appt", appt));
		Appointment apptToDelete = (Appointment) criteria.uniqueResult();
		sessionFactory.getCurrentSession().delete(apptToDelete);
	}*/
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void deleteAppt(Appointment appt){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Appointment.class)
				.add(Restrictions.eq("apptId", appt));
		Appointment apptToDelete = (Appointment) criteria.uniqueResult();
		sessionFactory.getCurrentSession().delete(apptToDelete);
	}
}
