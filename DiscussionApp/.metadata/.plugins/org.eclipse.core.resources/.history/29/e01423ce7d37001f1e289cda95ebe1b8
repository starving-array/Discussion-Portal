package com.socialapp.discussion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.socialapp.discussion.model.DiscussDto;
import com.socialapp.discussion.service.DiscussionService;

@RestController
public class DiscussionController {

	
	@Autowired
	DiscussionService discussionService;
	
	
	@PostMapping(path = "/add/{userid}")
	public ResponseEntity<String> addDiscussion(@PathVariable("userid") Integer userid, @RequestBody DiscussDto discussdto){
		String msg = discussionService.createDiscussion(userid, discussdto);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	
	
}
