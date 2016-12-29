package beans;

import java.sql.Timestamp;

public class Appointment {

	private int apptId;
	private User doctor;
	private Pet pet;
	private String description;
	private Timestamp placedDate;
	private Timestamp apptDate;
	private String prescription;

	public Appointment() {
		super();
	}

	public Appointment(int apptId, User doctor, Pet pet, String description, Timestamp placedDate, Timestamp apptDate,
			String prescription) {
		super();
		this.apptId = apptId;
		this.doctor = doctor;
		this.pet = pet;
		this.description = description;
		this.placedDate = placedDate;
		this.apptDate = apptDate;
		this.prescription = prescription;
	}

	public int getApptId() {
		return apptId;
	}

	public void setApptId(int apptId) {
		this.apptId = apptId;
	}

	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
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
		return "Appointment [apptId=" + apptId + ", Doctor=" + doctor + ", pet=" + pet + ", description=" + description
				+ ", placedDate=" + placedDate + ", apptDate=" + apptDate + ", prescription=" + prescription + "]";
	}

}
