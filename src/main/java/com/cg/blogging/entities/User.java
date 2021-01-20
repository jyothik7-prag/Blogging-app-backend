package com.cg.blogging.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Table(name = "User123_Temp")
public class User {
    @Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
    
    //@Pattern(regexp="^[a-zA-Z0-9{5-10}",message="length must be between 5 - 10 characters")
    @Size(min=5,max=10,message="password must be minimun 5 chars and maximum 10")
    @NotBlank(message="password is mandatory")
	@Column(name = "password")
	private String password;
	
	
    //@NotBlank(message="role is mandatory")
	@Column(name = "role")
	private String role;
	
//	Constructor
	public User(int userId, String password, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
	}
	


	//Constructor for object creation
	public User(User user) {
		// TODO Auto-generated constructor stub
		this.userId=user.userId;
		this.password = user.password;
		this.role = user.role;
	}

	public User() {

	}
	
	
public User(
			@Size(min = 5, max = 10, message = "password must be minimun 5 chars and maximum 10") @NotBlank(message = "password is mandatory") String password,
			String role) {
		super();
		this.password = password;
		this.role = role;
	}



	//	Getters and Setters method
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

// To String method
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}
	
// HashCode method 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userId;
		return result;
	}

// Equals method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId != other.userId)
			return false;
		return true;
	}



	

}