package com.sherlockHomies.orm;

import java.util.List;

import org.hibernate.SessionFactory;

import com.sherlockHomies.beans.Pet;

public class PetDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Pet> getAll(){
		return sessionFactory.getCurrentSession().createCriteria(Pet.class).list();
	}

}
