package com.revature.data;

import java.util.List;
import org.hibernate.Session;
import com.sherlockHomies.beans.User;

public class VetDAO {
	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}

	public List<User> getAll() {
		return session.createCriteria(User.class).list();
	}
}
