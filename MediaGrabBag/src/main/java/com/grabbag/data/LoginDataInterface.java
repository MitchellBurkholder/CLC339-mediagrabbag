package com.grabbag.data;

import java.util.List;

import com.grabbag.data.entity.LoginInfoEntity;

public interface LoginDataInterface <T> {
	public List<T> findAll();
	public T findById(int id);
	public LoginInfoEntity findByUsername(String username);
	public boolean create(T t);
	public boolean update(T t);
	public boolean delete(T t);
	public boolean CheckCredentials(String username, String password);
}
