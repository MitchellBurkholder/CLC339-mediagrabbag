package com.grabbag.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.grabbag.data.LoginDataInterface;
import com.grabbag.data.entity.LoginInfoEntity;
import com.grabbag.model.LoginModel;

@Service
public class SecurityCheck implements LoginInterface, UserDetailsService{
	
	@Autowired
	private LoginDataInterface<LoginModel> loginService;
	
	public void create(String username, String password) {
		
		LoginModel login = new LoginModel();
		login.setPassword(password);
		login.setUsername(username);
		
		loginService.create(login);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		LoginInfoEntity loginInfo = loginService.findByUsername(username);
		
		if(loginInfo != null) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("USER"));
			return new User(loginInfo.getUsername(), loginInfo.getPassword(), authorities);
		}else {
			throw new UsernameNotFoundException("Username Not Found");
		}
	}
}
