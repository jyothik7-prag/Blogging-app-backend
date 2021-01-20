package com.cg.blogging.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto
{
		private int userId;
		
		@Pattern(regexp="^(?=.*\\d).{4,8}$",message="Password length must be between 4-8 characters ,should contain uppercase letter and number")
		private String password;
		
		
	    //@NotBlank(message="role is mandatory")
		@Column(name = "role")
		private String role;


		public UserDto() {
			super();
			// TODO Auto-generated constructor stub
		}


		public UserDto(int userId,
				@Size(min = 5, max = 10, message = "password must be minimun 5 chars and maximum 10") @NotBlank(message = "password is mandatory") String password,
				String role) {
			super();
			this.userId = userId;
			this.password = password;
			this.role = role;
		}


		public int getUserId() {
			return userId;
		}


		public void setUserId(int userId) {
			this.userId = userId;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getRole() {
			return role;
		}


		public void setRole(String role) {
			this.role = role;
		}
		
		
}
