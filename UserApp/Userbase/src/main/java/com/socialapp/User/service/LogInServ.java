package com.socialapp.User.service;

public interface LogInServ {

	String login(String email, String password);
	
	String logout(String accessToken);
	
	
}
