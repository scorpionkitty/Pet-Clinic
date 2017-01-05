package com.sherlockHomies.interfaces;

import java.util.List;

import com.sherlockHomies.beans.Appointment;

public interface AppointmentDAOInterface {
	
	public List<Appointment>getAll();
	
	public void insert(Appointment appointment);

	//more as they are needed
}
