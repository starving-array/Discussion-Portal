package com.socialapp.User.service;

import com.socialapp.User.model.LogIn;

public interface LogInServ {

	public String login(String email, String password);
	
	public String logout(String accessToken);
	
	public LogIn getLoginDetail(String accessToken);
	
	
}
