package com.neuedu.ssm_shop.service;

import java.util.List;

import com.neuedu.ssm_shop.pojo.Category;


public interface CategoryService {
	// 添加根节点
	void insertRoot(String name,String descr);

	// 添加子节点
	void insertChild(String name, String descr, int pid);

	// 按照数据表的顺序查询所有
	List<Category> findAll();

	// 显示为树状结构
	List<Category> findToTree();
	//使用递归完成删除
//	void delete(int id, int pid);
	void delete(int id);
	Category findById(int id);
	
	Category findByPid(int pid);
	
}
