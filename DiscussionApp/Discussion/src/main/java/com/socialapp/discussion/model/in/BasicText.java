package com.socialapp.discussion.model.in;

import java.time.LocalDateTime;

import javax.persistence.Embeddable;

@Embeddable
public class BasicText {

	private String text;
	private String updateDate;

	public BasicText() {
		// TODO Auto-generated constructor stub
	}
	public BasicText(String text) {
		this.text = text;
		this.updateDate = LocalDateTime.now().toString();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

}
