package com.socialapp.discussion.model;

import javax.persistence.Embeddable;

@Embeddable
public class DiscussDto {

	private int discussId;
	private String caption;
	private String bodytext;
	private String hashtag;

	public DiscussDto(int id, String caption, String bodytext, String hashtag) {
		this.caption = caption;
		this.bodytext = bodytext;
		this.hashtag = hashtag;
		this.discussId = id;
	}

	public DiscussDto() {

	}

	public int getDiscussId() {
		return discussId;
	}

	public String getBodytext() {
		return bodytext;
	}

	public void setBodytext(String bodytext) {
		this.bodytext = bodytext;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

}
