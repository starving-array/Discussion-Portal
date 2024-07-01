package com.socialapp.User.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialapp.User.model.LogIn;
import com.socialapp.User.service.LogInServ;

@RestController
@RequestMapping()
public class LoginController {

	@Autowired
	LogInServ logInServ;

	@PostMapping("/login/{email}/{password}")
	public ResponseEntity<String> login(@PathVariable("email") String email,
			@PathVariable("password") String password) {
		String msg = logInServ.login(email, password);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	@PutMapping("/logout/{token}")
	public ResponseEntity<String> login(@PathVariable("token") String token) {
		String msg = logInServ.logout(token);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	@GetMapping("/logindetail/{token}")
	public ResponseEntity<LogIn> getLoginDetail(@PathVariable("token") String token) {
		return new ResponseEntity<LogIn>(logInServ.getLoginDetail(token), HttpStatus.OK);
	}
}
