package beans;

public class Specialization {

	private int specializationId;
	private int doctorId;
	private int petTypeId;
	
	public Specialization() {
		super();
	}
	public Specialization(int specializationId, int doctorId, int petTypeId) {
		super();
		this.specializationId = specializationId;
		this.doctorId = doctorId;
		this.petTypeId = petTypeId;
	}
	public int getSpecializationId() {
		return specializationId;
	}
	public void setSpecializationId(int specializationId) {
		this.specializationId = specializationId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public int getPetTypeId() {
		return petTypeId;
	}
	public void setPetTypeId(int petTypeId) {
		this.petTypeId = petTypeId;
	}
	@Override
	public String toString() {
		return "Specialization [specializationId=" + specializationId + ", doctorId=" + doctorId + ", petTypeId="
				+ petTypeId + "]";
	}
}
