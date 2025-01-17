package com.socialapp.discussion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialapp.discussion.feignService.UserClient;
import com.socialapp.discussion.model.Discuss;
import com.socialapp.discussion.model.DiscussDto;
import com.socialapp.discussion.model.DiscussOutputDTO;
import com.socialapp.discussion.model.loginInfoShareDto;
import com.socialapp.discussion.repository.DiscussionRepo;

@Service
public class DiscussionServImpl implements DiscussionService {

	@Autowired
	DiscussionRepo discussionRepo;

	@Autowired
	UserClient userClient;

	private Integer getUserIdByToken(String token) {
		loginInfoShareDto loginDetail = userClient.getLoginInfoDetail(token);
		Integer userid = loginDetail != null ? loginDetail.getUserid() : -1;
		return userid;
	}

	@Override
	public String createDiscussion(String token, DiscussDto discussDto) {
		Integer userid = getUserIdByToken(token);
		Discuss discuss = new Discuss(userid, discussDto.getCaption(), discussDto.getBodytext(),
				discussDto.getHashtag());
		if (userid != -1)
			discussionRepo.save(discuss);
		return userid == -1 ? "Nothing added" : "Discussion added";
	}

	@Override
	public String updateDiscussion(String usertoken, DiscussDto discussDto) {
		Integer userid = getUserIdByToken(usertoken);
		Optional<Discuss> discussOp = discussionRepo.findById(discussDto.getDiscussId());
		Discuss discuss = discussOp.get();
		Boolean stat = discussOp.isPresent() && discuss.getUserId() == userid;
		if (stat) {
			if (!discussDto.getBodytext().isEmpty())
				discuss.setBody(discussDto.getBodytext());
			if (!discussDto.getCaption().isEmpty())
				discuss.setCaption(discussDto.getCaption());
			if (!discussDto.getBodytext().isEmpty())
				discuss.setBody(discussDto.getBodytext());
			discussionRepo.save(discuss);
		}
		return stat ? "Discussion updated" : "Discussion not updated";
	}

	@Override
	public String deleteDiscussion(String usertoken, int discussionId) {
		Integer userid = getUserIdByToken(usertoken);
		Optional<Discuss> discussOp = discussionRepo.findById(discussionId);
		Discuss discuss = discussOp.get();
		Boolean stat = discussOp.isPresent() && discuss.getUserId() == userid;
		if (stat)
			discussionRepo.delete(discuss);
		return stat ? "Discussion deleted" : "Discussion not deleted";

	}

	@Override
	public List<DiscussOutputDTO> getListOfDiscussionOnTag(String hashtag) {
		List<Discuss> discuss = discussionRepo.findByHashtag(hashtag);
		return null;
	}

	@Override
	public List<DiscussOutputDTO> getListOfDiscussionBasedOnKeyword(String keyword) {
		return null;
	}


}
