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
	private UserDAO userdao;
	private PetDAO petdao;
	private AppointmentDAO appointmentdao;
	private InvoiceDAO invoicedao;
	private RatingDAO ratingdao;

	
	public void setDao(DAO dao) {
		this.dao = dao;
	}

	public void setUserdao(UserDAO userdao) {
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
	}

	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public void insertUserRole(List<UserRole> userRole){
		for(UserRole role : userRole)
			dao.insert(role); //also requires NEW. Creates a subtransaction. We don't want this. Change to REQUIRED.
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public void insertUser(List<User> user){
		for(User u : user)
			dao.insert(u); //also requires NEW. Creates a subtransaction. We don't want this. Change to REQUIRED.
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public void insertPetType(List<PetType> petType){
		for(PetType pt : petType)
			dao.insert(pt); //also requires NEW. Creates a subtransaction. We don't want this. Change to REQUIRED.
	}
	
/*	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public void insertOwner(List<User> user){
		for(User u : user)
			dao.insert(u); //also requires NEW. Creates a subtransaction. We don't want this. Change to REQUIRED.
	}*/
	
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public void insertPet(List<Pet> pet){
		for(Pet p : pet)
			dao.insert(p); //also requires NEW. Creates a subtransaction. We don't want this. Change to REQUIRED.
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public void insertAppt(List<Appointment> appt){
		for(Appointment a : appt)
			dao.insert(a); //also requires NEW. Creates a subtransaction. We don't want this. Change to REQUIRED.
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public void insertInvoice(List<Invoice> invoice){
		for(Invoice i : invoice)
			dao.insert(i); //also requires NEW. Creates a subtransaction. We don't want this. Change to REQUIRED.
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public void insertRating(List<Rating> rating){
		for(Rating r : rating)
			dao.insert(r); //also requires NEW. Creates a subtransaction. We don't want this. Change to REQUIRED.
	}
	
	public List<Appointment> getAllAppointments() {
		return appointmentdao.getAll();
	}

	public Appointment getAppointmentById(int id) {
		return appointmentdao.getById(id);
	}

	public List<Appointment> getAppointmentByUsername(String username) {
		return appointmentdao.getAppointmentByUsername(username);
	}

	public List<Appointment> getAppointmentByPet(String petname) {
		return appointmentdao.getAppointmentByPet(petname);
	}

	public List<Appointment> getAppointmentByVet(String vetname) {
		return appointmentdao.getAppointmentByVet(vetname);
	}

	public List<Invoice> getAllInvoices() {
		return invoicedao.getAll();
	}

	public Invoice getInvoiceById(int id) {
		return invoicedao.getById(id);
	}

	public List<Invoice> getInvoiceByUsername(String username) {
		return invoicedao.getByUsername(username);
	}

	public List<Pet> getAllPets() {
		return petdao.getAll();
	}

	public Pet getPetById(int id) {
		return petdao.getById(id);
	}

	public List<Pet> getPetByTypeId(int typeId) {
		return petdao.getByType(typeId);
	}

	public List<Pet> getByUser(String username) {
		return petdao.getByUser(username);
	}

	public List<Pet> getPetByTypeName(String typeName) {
		return petdao.getByType(typeName);
	}

	public List<Rating> getAllRatings() {
		return ratingdao.getAll();
	}

	public Rating getRatingById(int id) {
		return ratingdao.getRatingById(id);
	}

	public List<Rating> getRatingByUser(String username) {
		return ratingdao.getRatingByUser(username);
	}

	public List<Rating> getRatingByVet(String vetname) {
		return ratingdao.getRatingByVet(vetname);
	}

	public List<User> getAllUsers() {
		return userdao.getAll();
	}

	public User getUserById(int id) {
		return userdao.getById(id);
	}

	public List<User> getUserByRole(String role) {
		return userdao.getUserByRole(role);
	}

}
