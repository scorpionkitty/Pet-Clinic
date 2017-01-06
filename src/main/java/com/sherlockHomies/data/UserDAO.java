package com.sherlockHomies.data;

import java.util.List;

import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.sherlockHomies.beans.User;

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
	
	public User getUserById(int id) {
		return (User) session.get(User.class, id);
	}

	public List<User> getAll() {
		return session.createCriteria(User.class).list();
	}
}
