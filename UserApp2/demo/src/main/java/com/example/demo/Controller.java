package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	service service;
	
	@PostMapping("/add/{name}/{email}/{phone}/{pass}")
	public ResponseEntity<String> createAccount(@PathVariable("name")String name, @PathVariable("email")String email, @PathVariable("phone")String phone, @PathVariable("pass")String pass){
		String msg = service.CreateAccount(name, phone, email, pass);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/get/{name}")
	public ResponseEntity<List<String>> getByName(@PathVariable ("name") String name){
		List<String> list = service.getByName(name);
		return new ResponseEntity<List<String>>(list, HttpStatus.OK);
	}
	@GetMapping("/gettwo/{name}")
	public ResponseEntity<List<TwoMemberDto>> getByNamePhone(@PathVariable ("name") String name){
		List<TwoMemberDto> list = service.getByNamePhone(name);
		return new ResponseEntity<List<TwoMemberDto>>(list, HttpStatus.OK);
	}
}
