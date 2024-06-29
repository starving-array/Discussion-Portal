package com.socialapp.User.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialapp.User.helper.ObjStr;
import com.socialapp.User.model.in.model.Emailin;

@Entity
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String phone;

	private String email;

	private String password;

	UserInfo() {
	}

	public UserInfo(String name, String email, String phone, String password) {
		this.password = password;
		this.email = email;
		this.name = name;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
