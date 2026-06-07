package com.grabbag.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Table("logininfo")
public class LoginModel {
	
	@Id
	private long id;

	@NotNull(message="User name is required field")
	@Size(min=1, max=32, message="User name must be bewteen 1 & 32 characters")
	@Column("USERNAME")
	private String username;
	
	@NotNull(message="Password is required field")
	@Size(min=1, max=32, message="Password must be bewteen 1 & 32 characters")
	@Column("PASSWORD")
	private String password;
	
	//empty constructor 
	public LoginModel() {
		
	}
	
	public LoginModel(long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
