package com.socialapp.User.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialapp.User.model.UserInfo;

public interface UserRepo extends JpaRepository<UserInfo, Integer> {

	UserInfo findByEmail(String email);

	List<UserInfo> findByName(String name);
	
	
	

}