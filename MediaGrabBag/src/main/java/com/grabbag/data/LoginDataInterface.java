package com.grabbag.data;

import java.util.List;

import com.grabbag.data.entity.LoginInfoEntity;

public interface LoginDataInterface <T> {
	public LoginInfoEntity findByUsername(String username);
	public boolean create(T t);
}
