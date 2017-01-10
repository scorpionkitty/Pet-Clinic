package com.sherlockHomies.orm;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sherlockHomies.beans.Invoice;
import com.sherlockHomies.beans.User;

@Repository(value="invoiceDao")
@Scope(value="prototype")
public class InvoiceDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public List<Invoice> getAll(){
		return sessionFactory.getCurrentSession().createCriteria(Invoice.class).list();
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public Invoice getById(int id){
		return (Invoice) sessionFactory.getCurrentSession().get(Invoice.class, id);
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public List<Invoice> getByUsername(String username){
		String HQL = "select I from Invoice I join I.appt A join A.pet P join P.owner U where U.username= :u";
		Query query = sessionFactory.getCurrentSession().createQuery(HQL);
		query.setString("u", username);
		return query.list();
	}
	
}
