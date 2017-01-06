package com.sherlockHomies.beans;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Cacheable
@Entity //Entity says it is going to be mapped by hibernate
@Table(name = "PET") //rename Physical table even though the bean is different
public class Pet {

	@Id
	@Column(name = "PET_ID", nullable=false)
/*	@GeneratedValue(strategy = GenerationType.AUTO)*/
	private int petId;
	
	@Column(name="PET_NAME", nullable=false)
	private String petName;
	
	@ManyToOne(cascade = CascadeType.REMOVE) //one owner has many pets
	@JoinColumn(name="OWNER_ID", nullable=false, updatable=false)
	@ForeignKey(name="OWNER_ID_FK")
	private User owner;
	
	@ManyToOne(cascade = CascadeType.REMOVE) //one petType has many pets
	@JoinColumn(name="PET_TYPE_ID", nullable=false, updatable=false)
	@ForeignKey(name="PET_TYPE_ID_FK")
	private PetType petType;
	
	@OneToMany(mappedBy="pet")
	private Set<Appointment> petAppointments = new HashSet<Appointment>();
	
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
