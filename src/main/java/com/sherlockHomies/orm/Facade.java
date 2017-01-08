package com.sherlockHomies.orm;

import java.util.List;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.sherlockHomies.beans.Appointment;
import com.sherlockHomies.beans.Invoice;
import com.sherlockHomies.beans.Pet;
import com.sherlockHomies.beans.PetType;
import com.sherlockHomies.beans.Rating;
import com.sherlockHomies.beans.User;
import com.sherlockHomies.beans.UserRole;

public class Facade {

	private DAO dao;
/*	private UserDAO userdao;
	private PetDAO petdao;
	private AppointmentDAO appointmentdao;
	private InvoiceDAO invoicedao;
	private RatingDAO ratingdao;*/

	
	public void setDao(DAO dao) {
		this.dao = dao;
	}

/*	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}
	
	public void setPetdao(PetDAO petdao) {
		this.petdao = petdao;
	}
	
	public void setAppointmentdao(AppointmentDAO appointmentdao) {
		this.appointmentdao = appointmentdao;
	}

	public void setInvoicedao(InvoiceDAO invoicedao) {
		this.invoicedao = invoicedao;
	}

	public void setRatingdao(RatingDAO ratingdao) {
		this.ratingdao = ratingdao;
	}*/

	//INSERTS
	
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public void insertUserRole(List<UserRole> userRole){
		for(UserRole role : userRole)
			dao.insert(role);
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public void insertUser(List<User> user){
		for(User u : user)
			dao.insert(u);
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public void insertPetType(List<PetType> petType){
		for(PetType pt : petType)
			dao.insert(pt);
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public void insertPet(List<Pet> pet){
		for(Pet p : pet)
			dao.insert(p);
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public void insertAppt(List<Appointment> appt){
		for(Appointment a : appt)
			dao.insert(a);
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public void insertInvoice(List<Invoice> invoice){
		for(Invoice i : invoice)
			dao.insert(i);
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public void insertRating(List<Rating> rating){
		for(Rating r : rating)
			dao.insert(r);
	}
	
	// UPDATES
	
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public void updateAppointment(List<Appointment> appt){
		for(Appointment a : appt)
			dao.update(a);
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public void updateInvoice(List<Invoice> invoice){
		for(Invoice i : invoice)
			dao.update(i);
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public void updatePet(List<Pet> pet){
		for(Pet p : pet)
			dao.update(p);
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public void updateUser(List<User> user){
		for(User u : user)
			dao.update(u);
	}
	
	//DELETES
	
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public void deleteAppointment(List<Appointment> appt){
		for(Appointment a : appt)
			dao.delete(a);
	}
	
	//
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Appointment> getAllAppt(User vetId){
		
	}

	public User getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
