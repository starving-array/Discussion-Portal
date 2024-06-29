package com.socialapp.discussion.model.in.model;

import javax.persistence.Embeddable;

import com.socialapp.discussion.model.in.BasicText;

@Embeddable
public class Caption extends BasicText {

	
	public Caption(String text) {
		super(text);
		
	}

}
