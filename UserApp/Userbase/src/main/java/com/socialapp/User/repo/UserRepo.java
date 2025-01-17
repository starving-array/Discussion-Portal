package com.socialapp.User.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.socialapp.User.model.UserInfo;

public interface UserRepo extends JpaRepository<UserInfo, Integer> {

	@Query ("select e from UserInfo e where e.email=:email")
	UserInfo findByEmail(@Param("email") String email);

	List<UserInfo> findByName(String name);
	
	
	

}
