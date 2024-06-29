package com.socialapp.User.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialapp.User.model.LogIn;

public interface LoginDetailsRepo extends JpaRepository<LogIn, String>{

}
