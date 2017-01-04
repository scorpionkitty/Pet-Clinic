package com.sherlockHomies.beans;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Cacheable
@Entity //Entity says it is going to be mapped by hibernate
@Table(name = "PET") //rename Physical table even though the bean is different
public class Pet {

	@Id
	@Column(name = "PET_ID", nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int petId;
	
	@Column(name="PET_NAME", nullable=false)
	private String petName;
	
	@OneToOne
	@JoinColumn(name="OWNER_ID", nullable=false, updatable=false)
	private User owner;
	
	@OneToMany
	@JoinColumn(name="PET_TYPE_ID", nullable=false, updatable=false)
	private PetType petType;
	
	public Pet() {
		super();
	}
	public Pet(String petName, User owner, PetType petType) {
		super();
		this.petName = petName;
		this.owner = owner;
		this.petType = petType;
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
	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", petName=" + petName + ", owner=" + owner + ", petType=" + petType + "]";
	}
}
