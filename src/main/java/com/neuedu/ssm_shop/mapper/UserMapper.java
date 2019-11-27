package com.neuedu.ssm_shop.mapper;

import java.util.List;
import com.neuedu.ssm_shop.pojo.User;

public interface UserMapper {
	
	List<User> findAll();

	void insert(User user);

	User findById(int id);

	void update(User user);

	void delete(int id);

	/**
	 * 登录功能
	 */
	User findByUsername(String userName);
}
