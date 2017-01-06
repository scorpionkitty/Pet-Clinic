package com.sherlockHomies.beans;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Cacheable
@Entity //Entity says it is going to be mapped by hibernate
@Table(name = "USERS") //rename Physical table even though the bean is different
public class User {

	@Id
	@Column(name = "USER_ID", nullable=false, updatable = false)
/*	@GeneratedValue(strategy = GenerationType.AUTO)*/
	private int userId;
	
	@Column(name="USERNAME", nullable=false, updatable=false)
	private String username;
	
	@Column(name="FNAME", nullable=false)
	private String firstName;
	
	@Column(name="LNAME", nullable=false)
	private String lastName;
	
	@Column(name="PHONE", nullable=false)
	private String phone;
	
	@Column(name="EMAIL", length=50, nullable=false)
	private String email;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="USER_ROLE_ID", nullable=false, updatable=false)
	@ForeignKey(name="USER_ROLE_ID_FK")
	private UserRole userRole;
	
	@OneToMany(mappedBy="vet")
	private Set<Appointment> vetAppointments = new HashSet<>();
	
	@OneToMany(mappedBy="owner")
	private Set<Pet> ownerPets = new HashSet<>();
	
	@ManyToMany(mappedBy="vetSpecialization")
	private Set<PetType> vetSpecialization = new HashSet<>();
	
	public User() {
		super();
	}
    
	public User(int userId, String username, String firstName, String lastName, String phone, String email, UserRole userRole) {
		super();
		this.userId = userId;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.userRole = userRole;
		//this.userRole.setUserRoleId(userRoleId);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + ", phone=" + phone + ", email=" + email + ", userRole=" + userRole + "]";
	}

}
