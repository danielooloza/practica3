package com.generation.jwd.p1.beans;

import java.io.Serializable;

public class User implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String surname;
	private String email;
	private String password;
	
	
	public User() {
		super();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

