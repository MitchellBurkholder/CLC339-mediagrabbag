package com.grabbag.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabbag.data.LoginDataInterface;
import com.grabbag.data.LoginDataService;
import com.grabbag.model.LoginModel;

@Service
public class SecurityCheck implements LoginInterface{
	
	@Autowired
	private LoginDataInterface<LoginModel> loginService;
	
	public boolean authenticate(String username, String password) {
		
		return loginService.CheckCredentials(username, password);
	}
	
	public void create(String username, String password) {
		
		LoginModel login = new LoginModel();
		login.setPassword(password);
		login.setUsername(username);
		
		loginService.create(login);
	}
}
