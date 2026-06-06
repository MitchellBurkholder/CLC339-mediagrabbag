package com.grabbag.data.repo;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import com.grabbag.model.LoginModel;

public interface LoginRepo extends CrudRepository<LoginModel, Long>{
	@Override
	@Query(value = "SELECT * FROM logininfo")
	public List<LoginModel> findAll();
}
