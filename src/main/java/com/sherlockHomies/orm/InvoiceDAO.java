package com.sherlockHomies.orm;

import java.util.List;

import org.hibernate.SessionFactory;

import com.sherlockHomies.beans.Invoice;

public class InvoiceDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Invoice> getAll(){
		return sessionFactory.getCurrentSession().createCriteria(Invoice.class).list();
	}

}
