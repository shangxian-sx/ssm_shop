package com.neuedu.ssm_shop.mapper;

import java.util.List;

import com.neuedu.ssm_shop.pojo.Admin;



public interface AdminMapper {
	List<Admin> findAll();
	
	void insert(Admin admin);
	
	Admin findById(int id);
	
	void update(Admin admin);
	
	void delete(int id);
	
	/**
	 * 登录功能
	 */
	Admin findByAname(String adminName);
	/**
	 * 重置密码
	 * @param id id
	 */
	void resetPassword(Integer id);
	
}
