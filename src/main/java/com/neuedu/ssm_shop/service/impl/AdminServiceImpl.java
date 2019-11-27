package com.neuedu.ssm_shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ssm_shop.mapper.AdminMapper;
import com.neuedu.ssm_shop.mapper.util.ServletUtil;
import com.neuedu.ssm_shop.pojo.Admin;
import com.neuedu.ssm_shop.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMapper mapper;

	public List<Admin> findAll() {
		System.out.println("遍历admin_list业务===============");
		return mapper.findAll();
	}

	public Admin findById(int id) {
		if (id <= 0) {

		}
		if (mapper.findById(id) == null) {

			return null;
		}

		return mapper.findById(id);
	}

	public void update(Admin admin) {
		System.out.println("更新的业务");
		mapper.update(admin);
	}

	public void delete(int id) {
		System.out.println("删除管理员的业务");
		mapper.delete(id);
	}

	/**
	 * 登录的业务实现
	 */
	public Admin login(String adminName, String adminPassword) {
		
		Admin admin = mapper.findByAname(adminName);
		
		if (admin != null) {
			if (admin.getAdminPassword().equals(ServletUtil.md5(adminPassword))) {
				System.out.println("密码和用户名正确+++++++++++++++++++++++++++++++++++++++++++++");
				return admin;
			} else {
				System.out.println("密码错误========================");
				return null;
			}
		} else {
			System.out.println("用户名不存在=================");
			return null;
		}

	}

	public Admin findByAname(String adminName) {

		return mapper.findByAname(adminName);
	}

	public void insert(Admin admin) {
		System.out.println("insert添加的业务========================================");
		Admin findByAname = this.findByAname(admin.getAdminName());
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(admin.getAdminName());
		System.out.println("---------------------------------------------");
		if (findByAname == null) {
			mapper.insert(admin);
			System.out.println("执行了添加的业务****************************************************************");
		} else {
			System.out.println("没有执行添加的业务+++++++++++++++++++++++++++++++++++++++++++");
		}
	}

	public void resetPassword(Integer id) {
		mapper.resetPassword(id);
	}
}
