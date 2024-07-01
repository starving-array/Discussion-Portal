package com.socialapp.discussion.model;

import java.time.LocalDateTime;

public class loginInfoShareDto {

	private String sessionToken;
	private int userid;
	private String email;
	private LocalDateTime logintime;
	private LocalDateTime logouttime;
	private boolean expired = true;

	public loginInfoShareDto() {
	}

	public String getSessionToken() {
		return sessionToken;
	}

	public int getUserid() {
		return userid;
	}

	public String getEmail() {
		return email;
	}

	public LocalDateTime getLogintime() {
		return logintime;
	}

	public LocalDateTime getLogouttime() {
		return logouttime;
	}

	public boolean isExpired() {
		return expired;
	}

	public loginInfoShareDto(String email) {
		this.email = email;
		this.logintime = LocalDateTime.now();
	}

}
