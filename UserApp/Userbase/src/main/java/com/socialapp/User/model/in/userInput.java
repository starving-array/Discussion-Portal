package com.socialapp.User.model.in;

import java.time.LocalDateTime;

public class userInput {

	protected String userInput;
	protected String date;

	public userInput(String userinput) {
		this.userInput = userinput;
		this.date = LocalDateTime.now().toString();
	}

	public String getUserInput() {
		return userInput;
	}

	public void setUserInput(String userInput) {
		this.userInput = userInput;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
