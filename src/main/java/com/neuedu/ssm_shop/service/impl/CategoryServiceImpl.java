package com.neuedu.ssm_shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.ssm_shop.mapper.CategoryMapper;
import com.neuedu.ssm_shop.pojo.Category;
import com.neuedu.ssm_shop.pojo.CategoryBean;
import com.neuedu.ssm_shop.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryMapper mapper;

	//
	public void insertRoot(String name, String descr) {
		mapper.insertRoot(new CategoryBean(name, descr));
	}

	public void insertChild(String name, String descr, int pid) {
		// 为了拿父类级别grade的值，查询
		int grade = mapper.findParentGradeByPid(pid);
		// 添加一条新的类别
		mapper.insertChild(new Category(name, descr, pid, grade + 1));
		// 更新父节点的leaf为非叶子节点
		mapper.updateParent(pid);
	}

	// 查找所有---弃用
	public List<Category> findAll() {

		return mapper.findAll();
	}

	// 以树状查找所有类别
	public List<Category> findToTree() {

		return mapper.findToTree();
	}
	// 递归删除类别

//	public void delete(int id, int pid) {
//		System.out.println("进入了ServiceImpl==============");
//		mapper.delete(id, pid);
//		System.out.println("mapper执行成功");
//	}

	public void delete(int id) {
		System.out.println("进入了ServiceImpl==============");
		mapper.delete(id);
		System.out.println("mapper执行成功");
	}

	public Category findById(int id) {
		return mapper.findById(id);
	}

	/**
	 * 没有用到
	 * 
	 * @param pid
	 * @return
	 */
	public int findParentGradeByPid(int pid) {
		return mapper.findParentGradeByPid(pid);
	}

	public Category findByPid(int pid) {
		System.out.println("进入了ServiceImpl中的findByPid=====");
		System.out.println("pid=" + pid);
		return mapper.findByPid(pid);
	}

}
