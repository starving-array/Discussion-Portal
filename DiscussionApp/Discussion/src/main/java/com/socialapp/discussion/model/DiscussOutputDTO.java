package com.socialapp.discussion.model;

import java.time.LocalDateTime;

import javax.persistence.Embeddable;

@Embeddable
public class DiscussOutputDTO {

	private String caption;
	private String body;
	private LocalDateTime creationTime;
	private String author;
	private String email;

	public DiscussOutputDTO() {
		// TODO Auto-generated constructor stub
	}

	public DiscussOutputDTO(String caption, String body, String author, String email, LocalDateTime time) {
		this.caption = caption;
		this.body = body;
		this.creationTime = time;
		this.author = author;
		this.email = email;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
