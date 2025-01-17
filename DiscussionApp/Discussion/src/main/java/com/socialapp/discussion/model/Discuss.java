package com.socialapp.discussion.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.socialapp.discussion.helper.ObjStr;
import com.socialapp.discussion.model.in.model.BodyText;
import com.socialapp.discussion.model.in.model.Caption;

@Entity
public class Discuss {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int discussId;

	private int userId;

	private LocalDateTime postTime;

	private String caption;

	private String body;

	private String hashtag;

	public Discuss(int userid, String caption, String bodytext, String hashtag) {
		this.userId = userid;
		ObjStr cap = new ObjStr(new Caption(caption));
		this.caption = cap.objToString();
		cap.setObj(new BodyText(bodytext));
		this.body = cap.objToString();
		this.hashtag = hashtag;
		this.postTime = LocalDateTime.now();
	}

	public int getDiscussId() {
		return discussId;
	}

	public int getUserId() {
		return userId;
	}

	public LocalDateTime getPostTime() {
		return postTime;
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
		ObjStr cap = new ObjStr(body);
		this.body = cap.objToString();
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

}
