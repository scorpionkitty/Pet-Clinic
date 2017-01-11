package com.sherlockHomies.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * A class to generate new Sessions in the event one is not active. 
 */

public class HibernateSessionUtility {
	private Configuration config;
	private SessionFactory sf;
	private Session session;
	
	public SessionFactory getSessionFactory() {
		if (session == null) {
			config = new Configuration();
			sf = config.configure().buildSessionFactory();
		}
		return sf;
	}
} 
