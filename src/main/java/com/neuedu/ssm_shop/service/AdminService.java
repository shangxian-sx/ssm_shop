package com.neuedu.ssm_shop.service;

import java.util.List;

import com.neuedu.ssm_shop.pojo.Admin;

public interface AdminService {
	List<Admin>findAll();
	
	Admin findById(int id);
	
	void update(Admin admin);
	
	void delete(int id);
	
	Admin login(String adminName,String adminPassword);
	
	void insert(Admin admin);
	
	Admin findByAname(String adminName);
	/**
	 * 重置密码
	 * @param id id
	 */
	void resetPassword(Integer id);
}
