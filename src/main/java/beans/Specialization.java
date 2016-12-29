package beans;

public class Specialization {

	private int specializationId;
	private User doctor;
	private PetType petType;

	public Specialization() {
		super();
	}

	public Specialization(int specializationId, User doctor, PetType petType) {
		super();
		this.specializationId = specializationId;
		this.doctor = doctor;
		this.petType = petType;
	}

	public int getSpecializationId() {
		return specializationId;
	}

	public void setSpecializationId(int specializationId) {
		this.specializationId = specializationId;
	}

	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	@Override
	public String toString() {
		return "Specialization [specializationId=" + specializationId + ", doctor=" + doctor + ", petType=" + petType
				+ "]";
	}

}
