package com.sherlockHomies.interfaces;

import java.util.List;

import com.sherlockHomies.beans.Invoice;

public interface InvoiceDAOInterface {
	
	public List<Invoice> getAll();
	
	public void insert(Invoice invoice);

}
