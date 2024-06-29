package com.socialapp.User.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialapp.User.model.UserDto;
import com.socialapp.User.model.UserInfo;
import com.socialapp.User.model.UserShareDto;
import com.socialapp.User.repo.UserRepo;

@Service
public class userservImpl implements userService {

	@Autowired
	UserRepo userRepo;

	@Override
	public String createUser(UserDto userDto) {
		String msg = "User created";
		UserInfo userInput = new UserInfo(userDto.getName(), userDto.getEmail(), userDto.getPhone(),
				userDto.getPassword());
		userRepo.save(userInput);
		return msg;
	}

	@Override
	public String updateUserInfo(UserDto userDto) {
		String msg = "";
		// get id from active access token in login
		// for now using dummy id
		int id = 1;
		UserInfo userInfo = userRepo.getById(id);
		if (!userDto.getEmail().isEmpty()) {
			userInfo.setEmail(userDto.getEmail());
			msg = "Email updated";
		}
		;
		if (!userDto.getName().isEmpty()) {
			userInfo.setName(userDto.getName());
			msg += " + Name updated";
		}
		if (!userDto.getPhone().isEmpty()) {
			userInfo.setPhone(userDto.getPhone());
			msg += " + Phone updated";
		}
		if (!userDto.getPassword().isEmpty()) {
			userInfo.setPassword(userDto.getPassword());
			msg += " + Password updated";
		}

		userRepo.save(userInfo);

		return msg.contains("") ? "Nothing updated" : msg;
	}

	@Override
	public String deleteUser(int userid) {
		String msg = "Invalid user";
		// get id from active access token in login
		// for now using dummy id
		
		Optional<UserInfo> userInfo = userRepo.findById(userid);
		if(userInfo.isPresent()) {
			UserInfo u = userInfo.get();
			userRepo.delete(u);			
		}
		// for better security password can be asked here
		// if passed msg = "user deleted";
		return userInfo.isPresent()? "User deleted": msg;
	}

	@Override
	public List<UserShareDto> searchUserByName(String name) {
		List<UserInfo> userlist = userRepo.findByName(name);
		List<UserShareDto> list2 = new ArrayList<>();
		for(UserInfo li:userlist) {
			UserShareDto u = new UserShareDto(li.getName(), li.getEmail());
			list2.add(u);
		}
		return list2;
	}

	@Override
	public List<UserShareDto> showUserList() {
		List<UserInfo> list = userRepo.findAll();
		List<UserShareDto> list2 = new ArrayList<>();
		for(UserInfo li:list) {
			UserShareDto u = new UserShareDto(li.getName(), li.getEmail());
			list2.add(u);
		}
		return list2;
	}

	@Override
	public UserShareDto getUserByUserId(int userid) {
		UserInfo userinfo = userRepo.getById(userid);
		UserShareDto usershare = new UserShareDto(userinfo.getName(), userinfo.getEmail());
		;
		return usershare;
	}

}
