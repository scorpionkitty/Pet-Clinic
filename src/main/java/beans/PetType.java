package beans;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Cacheable
@Entity //Entity says it is going to be mapped by hibernate
@Table(name = "PET_TYPE") //rename Physical table even though the bean is different
public class PetType {

	@Id
	@Column(name = "PET_TYPE_ID", nullable=false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int petTypeId;
	
	//@OneToOne
	@Column(name="PET_TYPE_NAME", nullable=false, updatable=false)
	private String petTypeName;

	public PetType() {
		super();
	}

	public PetType(String petTypeName) {
		super();
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
