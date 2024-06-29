package com.socialapp.discussion.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.socialapp.discussion.model.UserShareDto;

@FeignClient(name = "userdatabase", url = "http://localhost:8010/")
public interface UserClient {

	@GetMapping("/user/{id}")
    UserShareDto getUserById(@PathVariable("id") int id);
}
