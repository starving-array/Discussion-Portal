package com.socialapp.discussion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialapp.discussion.model.Discuss;
import com.socialapp.discussion.model.DiscussDto;
import com.socialapp.discussion.model.UserShareDto;
import com.socialapp.discussion.repository.DiscussionRepo;

@Service
public class DiscussionServImpl implements DiscussionService {

	@Autowired
	DiscussionRepo discussionRepo;
	
	@Autowired
	UserClient userClient;

	@Override
	public String createDiscussion(int userid, DiscussDto discussDto) {
		String msg = "Nothing added";
		Discuss discuss = new Discuss(userid, discussDto.getCaption(), discussDto.getBodyText(),
				discussDto.getHashtag());
		discussionRepo.save(discuss);
		msg = "Discussion added";
		UserShareDto user = userClient.getUserById(4);
		System.out.println(user);
		return msg;

	}

	@Override
	public void uppdateDiscussion(DiscussDto discussDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteDiscussion(String discussionId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DiscussDto> getListOfDiscussionOnTag(String hashtag) {
		// TODO Auto-generated method stub``
		return null;
	}

	@Override
	public List<DiscussDto> getListOfDiscussionBasedOnKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}