package com.socialapp.User.service;

import java.util.List;

import com.socialapp.User.model.UserDto;
import com.socialapp.User.model.UserInfo;
import com.socialapp.User.model.UserShareDto;

public interface userService {

	public String createUser(UserDto userDto);

	public String updateUserInfo(UserDto userDto);

	public String deleteUser(int userid);

	public List<UserShareDto> searchUserByName(String name);

	public List<UserShareDto> showUserList();
	
	public UserShareDto getUserByUserId(int userid);

}
