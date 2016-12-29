package beans;

public class Pet {

	private int petId;
	private String petName;
	private User owner;
	private PetType petType;

	public Pet() {
		super();
	}

	public Pet(int petId, String petName, User owner, PetType petType) {
		super();
		this.petId = petId;
		this.petName = petName;
		this.owner = owner;
		this.petType = petType;
	}

	public int getPetId() {
		return petId;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
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

	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", petName=" + petName + ", owner=" + owner + ", petType=" + petType + "]";
	}

}
