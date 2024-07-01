package com.socialapp.discussion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialapp.discussion.model.Discuss;

public interface DiscussionRepo extends JpaRepository<Discuss, Integer> {

	
	List<Discuss> findByHashtag(String hashtag);
}
