package com.socialapp.User.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LogIn {

	@Id
	private String sessionToken;
	private int userid;
	private String email;
	private LocalDateTime logintime;
	private LocalDateTime logouttime;
	private boolean expired = true;

	public LogIn() {
	}

	public LogIn(String email) {
		this.email = email;
		this.logintime = LocalDateTime.now();
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getSessionToken() {
		return sessionToken;
	}

	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
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

	public void setLogouttime(LocalDateTime logouttime) {
		this.logouttime = logouttime;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

}
