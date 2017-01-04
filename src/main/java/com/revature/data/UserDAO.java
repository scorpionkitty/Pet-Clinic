package com.revature.data;

import java.util.List;

import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import beans.User;

/**
 * DAO to perform actions on the DB.
 * Only operation on the User table will go here
 * @author David Sibrian
 *
 */
@Repository(value="userdao")
@Scope(value="prototype")
public class UserDAO {
	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}

	public List<User> getAll() {
		return session.createCriteria(User.class).list();
	}
}
