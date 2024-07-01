package com.socialapp.discussion.service;

import java.util.List;

import com.socialapp.discussion.model.DiscussDto;
import com.socialapp.discussion.model.DiscussOutputDTO;

public interface DiscussionService {
	
	String createDiscussion(String token, DiscussDto discussDto);
	
	String updateDiscussion(String userToken, DiscussDto discussDto);
	
	String deleteDiscussion(String token ,int discussionId);
	
	List<DiscussOutputDTO> getListOfDiscussionOnTag(String hashtag);
	
	List<DiscussOutputDTO> getListOfDiscussionBasedOnKeyword(String keyword);

}
