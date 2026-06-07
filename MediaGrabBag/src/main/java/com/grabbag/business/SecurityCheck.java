package com.grabbag.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabbag.data.LoginDataService;

@Service
public class SecurityCheck implements LoginInterface{
	
	@Autowired
	private LoginDataService loginService;
	
	public boolean authenticate(String username, String password) {
		
		return loginService.CheckCredentials(username, password);
	}
}
