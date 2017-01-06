package com.sherlockHomies.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Cacheable
@Entity //Entity says it is going to be mapped by hibernate
@Table(name = "USER_ROLE") //rename Physical table even though the bean is different
public class UserRole {

	@Id
	@Column(name = "USER_ROLE_ID", nullable=false)
/*	@GeneratedValue(strategy = GenerationType.AUTO)*/
	private int userRoleId;
	
	@Column(name="USER_ROLE", nullable=false)
	private String userRole;
	
	@OneToMany(mappedBy="userRole")
	private Set<User> usersofThisRole = new HashSet<>();

	public UserRole() {
		super();
	}

	public UserRole(int userRoleId, String userRole) {
		super();
		this.userRoleId = userRoleId;
		this.userRole = userRole;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", userRole=" + userRole + "]";
	}
}
