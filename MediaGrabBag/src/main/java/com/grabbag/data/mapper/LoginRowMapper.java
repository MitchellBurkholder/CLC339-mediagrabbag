package com.grabbag.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.grabbag.model.LoginModel;

public class LoginRowMapper implements RowMapper<LoginModel>{

	@Override
	public LoginModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new LoginModel(rs.getLong("ID"),  rs.getString("USERNAME"), rs.getString("PASSWORD"));
	}
	
}
