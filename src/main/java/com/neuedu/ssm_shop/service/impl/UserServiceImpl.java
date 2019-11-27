package com.neuedu.ssm_shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ssm_shop.mapper.UserMapper;
import com.neuedu.ssm_shop.pojo.User;
import com.neuedu.ssm_shop.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper mapper;

	public List<User> findAll() {
		System.out.println("遍历user_list业务==========================================");
		return mapper.findAll();
	}

	public User findById(int id) {
		if (id <= 0) {

		}
		if (mapper.findById(id) == null) {

			return null;
		}

		return mapper.findById(id);
	}

	public void update(User user) {
		System.out.println("更新用户的业务=============");
		mapper.update(user);
	}

	public void delete(int id) {
		System.out.println("删除用户的业务=================");
		mapper.delete(id);
	}

	/**
	 * 登录的业务实现
	 */
	public User login(String username, String password) {
		User user = mapper.findByUsername(username);
		if (user != null) {
//			if (user.getUserPassword().equals(ServletUtil.md5(password))){
//				System.out.println("密码和用户名正确+++++++++++++++++++++++++++++++++++++++++++++");
//				return user;
//			} else {
				return null;
//			}
		}else {
			return null;
		}
	}

	public User findByUsername(String username) {

		return mapper.findByUsername(username);
	}

	public void insert(User user) {
		System.out.println("insert添加的业务========================================");
		User findByUsername = mapper.findByUsername(user.getUserName());
		System.out.println(user);
		System.out.println("==========11111111111================");
		if (findByUsername == null) {
			mapper.insert(user);
			System.out.println("执行了添加的方法");
		} else {

		}
	}

}
