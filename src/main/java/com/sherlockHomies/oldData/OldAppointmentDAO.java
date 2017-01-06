package com.sherlockHomies.oldData;

import java.util.List;

import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.sherlockHomies.beans.Appointment;

/**
 * DAO that performs crud operations on appointments
 * will add more methods as we go on
 * @author Sam
 *
 */
@Repository(value="appointmentdao")
@Scope(value="prototype")
public class OldAppointmentDAO {
	
	private Session session;

	public Appointment getAppointment(int id){
		return (Appointment) session.get(Appointment.class, id);
	}
	
	public void setSession(Session session){
		this.session = session;
	}
	
	public List<Appointment> getAll(){
		return session.createCriteria(Appointment.class).list();
	}
	
	public void insert(Appointment appointment){
		session.save(appointment);
	}

}
