package beans;

public class PetType {

	private int petTypeId;
	private String petTypeName;
	
	public PetType() {
		super();
	}
	public PetType(int petTypeId, String petTypeName) {
		super();
		this.petTypeId = petTypeId;
		this.petTypeName = petTypeName;
	}
	public int getPetTypeId() {
		return petTypeId;
	}
	public void setPetTypeId(int petTypeId) {
		this.petTypeId = petTypeId;
	}
	public String getPetTypeName() {
		return petTypeName;
	}
	public void setPetTypeName(String petTypeName) {
		this.petTypeName = petTypeName;
	}
	@Override
	public String toString() {
		return "PetType [petTypeId=" + petTypeId + ", petTypeName=" + petTypeName + "]";
	}
}
