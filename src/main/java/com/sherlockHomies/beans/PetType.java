package com.sherlockHomies.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Cacheable
@Entity //Entity says it is going to be mapped by hibernate
@Table(name="PET_TYPE") //rename Physical table even though the bean is different
public class PetType {

	@Id
	@Column(name = "PET_TYPE_ID", nullable=false)
/*	@GeneratedValue(strategy = GenerationType.AUTO)*/
	private int petTypeId;
	
	@Column(name="PET_TYPE_NAME", nullable=false, updatable=false)
	@NotNull
	private String petTypeName;
	
	@ManyToMany
	@JoinTable(name="SPECIALIZATION", joinColumns = @JoinColumn(name = "VET_ID"), inverseJoinColumns = @JoinColumn(name = "PET_TYPE_NAME"))
	private Set<User> vetSpecialization = new HashSet<>();
	
	@OneToMany(mappedBy="petType")
	private Set<Pet> petsOfThisType = new HashSet<>();
	

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
