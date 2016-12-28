package beans;

public class Pet {

	private int petId;
	private String petName;
	private int ownerId;
	private int petTypeId;
	
	public Pet() {
		super();
	}
	public Pet(int petId, String petName, int ownerId, int petTypeId) {
		super();
		this.petId = petId;
		this.petName = petName;
		this.ownerId = ownerId;
		this.petTypeId = petTypeId;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public int getownerId() {
		return ownerId;
	}
	public void setownerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public int getPetTypeId() {
		return petTypeId;
	}
	public void setPetTypeId(int petTypeId) {
		this.petTypeId = petTypeId;
	}
	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", petName=" + petName + ", ownerId=" + ownerId + ", petTypeId=" + petTypeId + "]";
	}
}
