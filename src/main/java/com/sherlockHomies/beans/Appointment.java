package com.sherlockHomies.beans;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Cacheable
@Entity
@Table(name="APPOINTMENT")
public class Appointment {

	@Id
	@Column(name = "APPT_ID", nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Digits(integer=999999, fraction=0)
	private int apptId;
	
	@ManyToOne //one vet has many appointments
	@JoinColumn(name="VET_ID", nullable = false)
	@NotNull
	private User vet;
	
	@ManyToOne //one pet has many appointments
	@JoinColumn(name="PET_ID", nullable = false)
	@NotNull
	private Pet pet;
	
	@Column(name="DESCRIPTION", length = 100)
	private String description;
	
	@Column(name="PLACED_DATE", nullable=false)
	@NotNull
	private Timestamp placedDate;
	
	@Column(name="APPT_DATE", nullable=false)
	@NotNull
	private Timestamp apptDate;
	
	@Column(name="PRESCRIPTION", length=100)
	@NotNull
	private String prescription;

	public Appointment() {
		super();
	}
    
	public Appointment(User vet, Pet pet, String description, Timestamp placedDate, Timestamp apptDate) {
		super();
		this.vet = vet;
		this.pet = pet;
		this.description = description;
		this.placedDate = placedDate;
		this.apptDate = apptDate;
	}

	public int getApptId() {
		return apptId;
	}

	public void setApptId(int apptId) {
		this.apptId = apptId;
	}
    
	public User getVet() {
		return vet;
	}
    
	public void setVet(User vet) {
		this.vet = vet;
	}
    
	public Pet getPet() {
		return pet;
	}
    
	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getPlacedDate() {
		return placedDate;
	}

	public void setPlacedDate(Timestamp placedDate) {
		this.placedDate = placedDate;
	}

	public Timestamp getApptDate() {
		return apptDate;
	}

	public void setApptDate(Timestamp apptDate) {
		this.apptDate = apptDate;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	@Override
	public String toString() {
		return "Appointment [apptId=" + apptId + ", vet=" + vet + ", pet=" + pet + ", description="
				+ description + ", placedDate=" + placedDate + ", apptDate=" + apptDate 
				+ ", prescription=" + prescription + "]";
	}

}
