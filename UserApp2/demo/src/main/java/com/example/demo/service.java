package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class service {

	@Autowired
	Repo repo;
	
	public String CreateAccount(String name, String phone, String email, String pass) {
		Model model = new Model(name, email, phone, pass);
		model.setId(1110);
		repo.save(model);
		return "account created";
	}
	
	
	public List<String> getByName(String name){
		List<String> list = repo.findDetailByName(name);
		return list;
	}
	public List<TwoMemberDto> getByNamePhone(String name){
		List<TwoMemberDto> list = repo.findDetailByNamePhone(name);
		return list;
	}
	
}
