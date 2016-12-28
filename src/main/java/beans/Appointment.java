package beans;

import java.sql.Timestamp;

public class Appointment {

	private int apptId;
	private int doctorId;
	private int petId;
	private String description;
	private Timestamp placedDate;
	private Timestamp apptDate;
	private double invoiceId;
	private String prescription;
	
	public Appointment() {
		super();
	}
	public Appointment(int apptId, int doctorId, int petId, String description, Timestamp placedDate,
			Timestamp apptDate, double invoiceId, String prescription) {
		super();
		this.apptId = apptId;
		this.doctorId = doctorId;
		this.petId = petId;
		this.description = description;
		this.placedDate = placedDate;
		this.apptDate = apptDate;
		this.invoiceId = invoiceId;
		this.prescription = prescription;
	}
	public int getApptId() {
		return apptId;
	}
	public void setApptId(int apptId) {
		this.apptId = apptId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
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
	public double getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(double invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	@Override
	public String toString() {
		return "Appointment [apptId=" + apptId + ", doctorId=" + doctorId + ", petId=" + petId + ", description="
				+ description + ", placedDate=" + placedDate + ", apptDate=" + apptDate + ", invoiceId=" + invoiceId
				+ ", prescription=" + prescription + "]";
	}
}
