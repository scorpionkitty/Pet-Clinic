package com.sherlockHomies.orm;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
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

@Component(value = "facade")
/*@Repository(value="facade")
@Scope(value="prototype")*/
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
	
	//OTHER
	
	//get appointments as a list of a pet owner
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Appointment> getAllOwnerAppt(User owner){
		return apptDao.getAppointmentByUsername(owner.getUsername());
	}
	
	//get User object given the userId entered
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public User getUser(int id) {
		return userDao.getById(id);
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public User getUser(String username) {
		return userDao.getByUsername(username);
	}

	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public String userRole(User user) {
		if(user.getUserRole().getUserRole() == "Vet")
			return "Vet";
		else return "Owner";
	}

	//create an appointment object
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public void createAndInsertAppt(int ownerId, int vetId, int petId, String description, String apptDate, String cardNumber) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss"); //TODO double check
		Date parsedDate = null;
		try {
			parsedDate = dateFormat.parse(apptDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp apptDateTimestamp = new java.sql.Timestamp(parsedDate.getTime());
		//to create an appointment object you need ownerId, vetId, date placed, date of appt, description 
		Appointment appt = apptDao.createAppt(ownerId, vetId, petId, description, getCurrentTimeStamp(), apptDateTimestamp);
		//return appt;
		dao.insert(appt);
		
		//TODO Invoice invoice = InvoiceDAO.createInvoice();
	}
	
	//HELPER METHODS
	
	//returns the current timestamp
	public static java.sql.Timestamp getCurrentTimeStamp(){
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Timestamp(today.getTime());
	}
	
	//Sam's part
	
	//TODO need?
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Appointment> getAllAppointments() {
		return apptDao.getAll();
	}

	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public Appointment getAppointmentById(int id) {
		return apptDao.getById(id);
	}

	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Appointment> getAppointmentByPet(String petname) {
		return apptDao.getAppointmentByPet(petname);
	}

	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Appointment> getAppointmentByVet(String vetname) {
		return apptDao.getAppointmentByVet(vetname);
	}

	//TODO need?
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Invoice> getAllInvoices() {
		return invoiceDao.getAll();
	}

	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public Invoice getInvoiceById(int id) {
		return invoiceDao.getById(id);
	}

	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Invoice> getInvoiceByUsername(String username) {
		return invoiceDao.getByUsername(username);
	}

	//TODO need?
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Pet> getAllPets() {
		return petDao.getAll();
	}

	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public Pet getPetById(int id) {
		return petDao.getById(id);
	}

	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Pet> getPetByTypeId(int typeId) {
		return petDao.getByType(typeId);
	}

	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Pet> getByUser(String username) {
		return petDao.getByUser(username);
	}

	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Pet> getPetByTypeName(String typeName) {
		return petDao.getByType(typeName);
	}

	//TODO need?
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Rating> getAllRatings() {
		return ratingDao.getAll();
	}

	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public Rating getRatingById(int id) {
		return ratingDao.getRatingById(id);
	}

	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Rating> getRatingByUser(String username) {
		return ratingDao.getRatingByUser(username);
	}

	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<Rating> getRatingByVet(String vetname) {
		return ratingDao.getRatingByVet(vetname);
	}

	//TODO need?
	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<User> getAllUsers() {
		return userDao.getAll();
	}

	@Transactional(isolation=Isolation.READ_COMMITTED, rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW)
	public List<User> getUserByRole(String role) {
		return userDao.getUserByRole(role);
	}
}
