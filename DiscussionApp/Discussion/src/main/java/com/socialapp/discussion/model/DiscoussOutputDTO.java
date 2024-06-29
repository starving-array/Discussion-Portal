package com.socialapp.discussion.model;

import java.time.LocalDateTime;

import javax.persistence.Embeddable;

@Embeddable
public class DiscoussOutputDTO {
	
	private String caption;
	private String body;
	private String author;
	private LocalDateTime creationTime;
	

}
