package com.socialapp.User.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialapp.User.helper.ConvertHash;
import com.socialapp.User.model.LogIn;
import com.socialapp.User.model.UserInfo;
import com.socialapp.User.repo.LoginDetailsRepo;
import com.socialapp.User.repo.UserRepo;

@Service
public class logInServImpl implements LogInServ {

	@Autowired
	LoginDetailsRepo loginDetailsRepo;

	@Autowired
	UserRepo userRepo;

	@Override
	public String login(String email, String password) {
		String msg = "Login Details Invalid";
		UserInfo userInfo = userRepo.findByEmail(email);

		if (userInfo!=null && password.equals(userInfo.getPassword())) {
			// new login create
			LogIn newLogin = new LogIn(email);
			// create hash and assign
			String accessToken = email + password + LocalDateTime.now().toString();
			ConvertHash hashText = new ConvertHash(accessToken);
			accessToken = hashText.getHash(accessToken);
			newLogin.setSessionToken(accessToken);
			newLogin.setUserid(userInfo.getId());
			newLogin.setExpired(false);
			loginDetailsRepo.save(newLogin);
			msg = "Login successful";
		}
		return msg;
	}

	@Override
	public String logout(String accessToken) {
		String msg = "Invalid token";
		LogIn loginDetail = loginDetailsRepo.getById(accessToken);
		if (!loginDetail.isExpired()) {
			loginDetail.setExpired(true);
			loginDetail.setLogouttime(LocalDateTime.now());
			loginDetailsRepo.save(loginDetail);
			msg = "Logout successfull";
		}
		return msg;
	}

	@Override
	public LogIn getLoginDetail(String accessToken) {
		Optional<LogIn> loginOpt = loginDetailsRepo.findById(accessToken);
		if(loginOpt.isPresent()) {
			return loginOpt.get();
		}
		return null;
	}
	
	

}
