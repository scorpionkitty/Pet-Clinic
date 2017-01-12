package com.sherlockHomies.beans;

import java.sql.Timestamp;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Appointment bean to be mapped to APPOINTMENT table in our relational database with the following columns:
 * 		APPT_ID, VET_ID, PET_ID, DESCRIPTION, PLACED_DATE, APPT_DATE, PRESCRIPTION
 */

@Cacheable
@Entity
@Table(name="APPOINTMENT")
public class Appointment {

	@Id
	@Column(name = "APPT_ID", nullable=false)
/*	@GeneratedValue(strategy = GenerationType.AUTO)*/
	@Digits(integer=999999, fraction=0)
	private int apptId;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="VET_ID", nullable = false)
	@ForeignKey(name="VET_ID_FK")
	@NotNull
	private User vet;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="PET_ID", nullable = false)
	@ForeignKey(name="PET_ID_FK")
	@NotNull
	private Pet pet;
	
	@Column(name="DESCRIPTION", length = 100)
	private String description;
	
	@Column(name="PLACED_DATE", nullable=false)
	@NotNull
	@JsonFormat(pattern="MM-dd-yyyy")
	private Timestamp placedDate;
	
	@Column(name="APPT_DATE", nullable=false)
	@NotNull
	@JsonFormat(pattern="MM-dd-yyyy")
	private Timestamp apptDate;
	
	@Column(name="PRESCRIPTION", length=100)
	private String prescription;

	public Appointment() {
		super();
	}
    
	public Appointment(int apptId, User vet, Pet pet, String description, Timestamp placedDate, 
			Timestamp apptDate) {
		super();
		this.apptId = apptId;
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
