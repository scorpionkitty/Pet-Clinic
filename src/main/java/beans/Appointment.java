package beans;

import java.sql.Timestamp;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Cacheable
@Entity //Entity says it is going to be mapped by hibernate
@Table(name = "APPOINTMENT") //rename Physical table even though the bean is different
public class Appointment {

	@Id
	@Column(name = "APPT_ID", nullable=false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int apptId;
	
	@JoinColumn(name="VET_ID", nullable = false)
	private User vet;
	
	@OneToOne
	@JoinColumn(name="PET_ID", nullable = false)
	private Pet pet;
	
	@OneToOne
	@Column(name="DESCRIPTION", length = 100)
	private String description;
	
	@OneToOne
	@Column(name="PLACED_DATE", nullable=false, updatable = false)
	private Timestamp placedDate;
	
	@OneToOne
	@Column(name="APPT_DATE", nullable=false)
	private Timestamp apptDate;
	
	@OneToOne
	@Column(name="PRESCRIPTION", length=100)
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
