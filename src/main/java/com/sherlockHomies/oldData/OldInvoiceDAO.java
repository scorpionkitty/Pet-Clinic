package com.sherlockHomies.oldData;

import java.util.List;

import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.sherlockHomies.beans.Invoice;

/**
 * DAO that performs crud operations on appointments
 * will add more methods as we go on
 * @author Sam
 *
 */
@Repository(value="invoicedao")
@Scope(value="prototype")
public class OldInvoiceDAO {
	
	private Session session;

	public Invoice getInvoice(int id){
		return (Invoice) session.get(Invoice.class, id);
	}
	
	public void setSession(Session session){
		this.session = session;
	}
	
	public List<Invoice> getAll(){
		return session.createCriteria(Invoice.class).list();
	}

	
	public void insert(Invoice pet){
		session.save(pet);
	}

}
