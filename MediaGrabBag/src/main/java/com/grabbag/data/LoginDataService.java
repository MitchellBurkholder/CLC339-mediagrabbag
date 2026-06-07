package com.grabbag.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.grabbag.data.repo.LoginRepo;
import com.grabbag.model.LoginModel;

@Service
public class LoginDataService implements DataAccessInterface<LoginModel>{
	
	@Autowired
	private LoginRepo loginRepo;
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public LoginDataService(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<LoginModel> findAll() {
		
		//will implement later
		return null;
	}

	@Override
	public LoginModel findById(int id) {
		
		// will implement later
		
		return null;
	}
	
	
	
	public boolean CheckCredentials(String username, String password) {
		
		
		String sql = "SELECT * FROM logininfo WHERE USERNAME = ? AND PASSWORD = ?";
		
		
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class, username, password);
		
		
		return (count != null || count > 0);
	}
	
	

	@Override
	public boolean create(LoginModel login) {
		
		String sql = "INSERT INTO\r\n"
				+ "logininfo(USERNAME, PASSWORD) VALUES(?, ?)";
				
		try 
		{
			jdbcTemplate.update(sql, login.getUsername(), login.getPassword());
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public boolean update(LoginModel login) {
		// for now unimplemented, may be used or removed in later milestones
		return false;
	}

	@Override
	public boolean delete(LoginModel login) {
		// for now unimplemented, may be used or removed in later milestones
		return false;
	}
	
}
