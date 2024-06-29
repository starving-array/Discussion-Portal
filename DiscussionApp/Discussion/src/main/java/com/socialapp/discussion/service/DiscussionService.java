package com.socialapp.discussion.service;

import java.util.List;

import com.socialapp.discussion.model.DiscussDto;

public interface DiscussionService {
	
	String createDiscussion(int userid, DiscussDto discussDto);
	
	void uppdateDiscussion(DiscussDto discussDto);
	
	void deleteDiscussion(String discussionId);
	
	List<DiscussDto> getListOfDiscussionOnTag(String hashtag);
	
	List<DiscussDto> getListOfDiscussionBasedOnKeyword(String keyword);
}