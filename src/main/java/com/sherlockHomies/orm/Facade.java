package com.sherlockHomies.orm;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sherlockHomies.beans.Appointment;
import com.sherlockHomies.beans.Invoice;
import com.sherlockHomies.beans.Pet;
import com.sherlockHomies.beans.Rating;
import com.sherlockHomies.beans.User;

@Component(value = "facade")
public class Facade {

	private DAO dao;
	private AppointmentDAO apptDao;
	private UserDAO userDao = null;	
	private PetDAO petDao;
	private InvoiceDAO invoiceDao;
	private RatingDAO ratingDao;

	@Autowired
	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	@Autowired
	public void setApptDao(AppointmentDAO apptDao) {
		this.apptDao = apptDao;
	}

	@Autowired
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	@Autowired
	public void setPetDao(PetDAO petDao) {
		this.petDao = petDao;
	}

	@Autowired
	public void setInvoiceDao(InvoiceDAO invoiceDao) {
		this.invoiceDao = invoiceDao;
	}

	@Autowired
	public void setRatingDao(RatingDAO ratingDao) {
		this.ratingDao = ratingDao;
	}

	////////////APPOINTMENT//////////////
	
	/**
	 * Returns all appointments in database as a list
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Appointment> getAllAppointments() {
		return apptDao.getAll();
	}
	
	/**
	 * Returns all appointments as a list of a given user
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Appointment> getAllOwnerAppt(User owner){
		return apptDao.getAppointmentByUsername(owner.getUsername());
	}
	
	/**
	 * Returns all appointments as a list of a pet when given pet Id TODO
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Appointment> getAppointmentByPet(String petname) {
		return apptDao.getAppointmentByPet(petname);
	}
	
	/**
	 * Returns all appointments as a list of a vet when given vet Id TODO
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Appointment> getAppointmentByVet(String vetname) {
		return apptDao.getAppointmentByVet(vetname);
	}
	
	/**
	 * Returns an appointment when given an apptId
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public Appointment getAppointmentById(int id) {
		return apptDao.getById(id);
	}

	/**
	 * Creates and insert an appointment given an owner Id, vet Id, pet Id, description, appt date, card number
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public void createAndInsertAppt(int ownerId, int vetId, int petId, String description, String apptDate, String cardNumber) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss"); //TODO double check
		Date parsedDate = null;
		try {
			parsedDate = dateFormat.parse(apptDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Timestamp apptDateTimestamp = new java.sql.Timestamp(parsedDate.getTime());
		//to create an appointment object you need ownerId, vetId, date placed, date of appt, description 
		Appointment appt = apptDao.createAppt(ownerId, vetId, petId, description, getCurrentTimeStamp(), apptDateTimestamp);
		//return appt;
		dao.insert(appt);
		
		//TODO Invoice invoice = InvoiceDAO.createInvoice();
	}
	
	/**
	 * Deletes an appointment given an appt Id
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public void deleteAppt(int apptId){
		Appointment appt = getAppointmentById(apptId);
		apptDao.deleteAppt(appt);
	}
	
	///////////////////USER////////////////////////
	
	/**
	 * Returns all users as a list
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<User> getAllUsers() {
		return userDao.getAll();
	}
	
	/**
	 * Returns all users as a list when given a user role
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<User> getUsersByRole(String role) {
		return userDao.getUsersByRole(role);
	}
	
	/**
	 * Returns a user when given the user Id
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public User getUser(int id) {
		return userDao.getById(id);
	}
	
	/**
	 * Returns a user when given the user's username
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public User getUser(String username) {
		return userDao.getByUsername(username);
	}
	
/*	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public User getVetOfType(String petType) {
		return userDao.getOfAType TODO
	}*/
	
	////////////////////USER ROLE///////////////////

	/**
	 * Returns a string 'Vet' or 'Owner' when given a user
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public String userRole(User user) {
		if(user.getUserRole().getUserRole() == "Vet")
			return "Vet";
		else return "Owner";
	}

	///////////////////INVOICE//////////////////////
	
	/**
	 * Returns all invoices as a list
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Invoice> getAllInvoices() {
		return invoiceDao.getAll();
	}
	
	/**
	 * Returns all invoices as a list when given user's username
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Invoice> getInvoiceByUsername(String username) {
		return invoiceDao.getByUsername(username);
	}
	
	/**
	 * Returns an invoice when given a invoice Id
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public Invoice getInvoiceById(int id) {
		return invoiceDao.getById(id);
	}

	///////////////PET////////////////////////////
	
	/**
	 * Returns all pets as a list
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Pet> getAllPets() {
		return petDao.getAll();
	}
	
	/**
	 * Returns all pets of an owner as a list when given owner's username
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Pet> getByUser(String username) {
		return petDao.getByUser(username);
	}
	
	/**
	 * Returns all pets of a type as a list when given type Id
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Pet> getPetByTypeId(int typeId) {
		return petDao.getByType(typeId);
	}
	
	/**
	 * Returns all pets of a type as a list when given type name
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Pet> getPetByTypeName(String typeName) {
		return petDao.getByType(typeName);
	}
	
	/**
	 * Returns a pet when given pet Id
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public Pet getPetById(int id) {
		return petDao.getById(id);
	}

	////////////////////RATING//////////////////////
	
	/**
	 * Returns all ratings as a list
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Rating> getAllRatings() {
		return ratingDao.getAll();
	}

	/**
	 * Returns a rating when given a rating Id
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public Rating getRatingById(int id) {
		return ratingDao.getRatingById(id);
	}

	/**
	 * Returns all ratings by a user given owner's username
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Rating> getRatingByUser(String username) {
		return ratingDao.getRatingByUser(username);
	}

	/**
	 * Returns all ratings of a vet given vet's username TODO Check
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Rating> getRatingByVet(String vetname) {
		return ratingDao.getRatingByVet(vetname);
	}
	
	////////////HELPER METHODS////////////////
	
	/**
	 * Returns the current timestamp
	 */
	public static java.sql.Timestamp getCurrentTimeStamp(){
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Timestamp(today.getTime());
	}
}