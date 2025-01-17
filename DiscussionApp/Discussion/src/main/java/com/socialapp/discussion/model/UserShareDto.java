package com.socialapp.discussion.model;

public class UserShareDto {
	
	
	@Override
	public String toString() {
		return "UserShareDto [name=" + name + ", email=" + email + "]";
	}

	private String name;
	private String email;

	public UserShareDto() {
		
	}
	
	public UserShareDto(String name, String email){
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
