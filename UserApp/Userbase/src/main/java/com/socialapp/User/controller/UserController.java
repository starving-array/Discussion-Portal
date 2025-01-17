package com.socialapp.User.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialapp.User.model.UserDto;
import com.socialapp.User.model.UserShareDto;
import com.socialapp.User.service.userService;

@RestController
@RequestMapping
public class UserController {

	@Autowired
	userService userService;

	@PostMapping("/add/")
	public ResponseEntity<String> addUser(@RequestBody UserDto userDto) {
		String userInfo = userService.createUser(userDto);
		return new ResponseEntity<String>(userInfo, HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public ResponseEntity<List<UserShareDto>> showUserList() {
		return new ResponseEntity<List<UserShareDto>>(userService.showUserList(), HttpStatus.OK);
	}

	@GetMapping("/get/name/{name}")
	public ResponseEntity<List<UserShareDto>> showUserByName(@PathVariable("name") String name) {
		return new ResponseEntity<List<UserShareDto>>(userService.searchUserByName(name), HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<UserShareDto> getUserById(@PathVariable("id") Integer id) {
		UserShareDto user = userService.getUserByUserId(id);
		return new ResponseEntity<UserShareDto>(user, HttpStatus.OK);
	}

	@PutMapping("/update/")
	public ResponseEntity<String> upadteUserInfo(@RequestBody UserDto userDto) {
		String userInfo = userService.updateUserInfo(userDto);
		return new ResponseEntity<String>(userInfo, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/del/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id) {
	    String msg = userService.deleteUser(id);
	    return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	

}
