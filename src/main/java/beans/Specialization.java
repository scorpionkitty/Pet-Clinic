package beans;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Cacheable
@Entity //Entity says it is going to be mapped by hibernate
@Table(name = "SPECIALIZATION") //rename Physical table even though the bean is different
public class Specialization {

	@Id
	@Column(name = "SPECIALIZATION_ID", nullable=false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	//spring -- @Digits(integer=999999, fraction=0)
	private int specializationId;
	
	//should be many to one
	@JoinColumn(name="VET_ID", nullable=false, updatable=false)
	private User vet;
	
	//should be many to one
	@JoinColumn(name="PET_TYPE_ID", nullable=false, updatable=false)
	private PetType petType;
	
	public Specialization() {
		super();
	}
    
	public Specialization(User vet, PetType petType) {
		super();
		this.vet = vet;
		this.petType = petType;
	}

	public int getSpecializationId() {
		return specializationId;
	}

	public void setSpecializationId(int specializationId) {
		this.specializationId = specializationId;
	}

	public User getVet() {
		return vet;
	}
    
	public void setVet(User vet) {
		this.vet = vet;
	}
    
	public PetType getPetType() {
		return petType;
	}
    
	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	@Override
	public String toString() {
		return "Specialization [specializationId=" + specializationId + ", vet=" + vet + ", petType="
				+ petType + "]";
	}

}
