package com.neuedu.ssm_shop.service;

import java.util.List;
import com.neuedu.ssm_shop.pojo.User;

public interface UserService {
	List<User>findAll();
	
	User findById(int id);
	
	void update(User user);
	
	void delete(int id);
	
	User login(String userName,String userPassword);
	
	void insert(User user);
	
	User findByUsername(String userName);
}
