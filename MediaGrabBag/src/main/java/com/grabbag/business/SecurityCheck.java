package com.grabbag.business;

import org.springframework.stereotype.Service;

@Service
public class SecurityCheck implements LoginInterface{
	public boolean authenticate(String username, String password) {
		if(username.equals("admin") && password.equals("123")) {
			return true;
		}
		return false;
	}
}
