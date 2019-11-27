package com.neuedu.ssm_shop.mapper;

import java.util.List;

import com.neuedu.ssm_shop.pojo.Category;
import com.neuedu.ssm_shop.pojo.CategoryBean;

public interface CategoryMapper {

	// 添加根节点
	void insertRoot(CategoryBean categoryBean);

	// 添加子节点
	void insertChild(Category category);

	// 按照数据表的顺序查询所有
	List<Category> findAll();

	// 现实为树状结构
	List<Category> findToTree();

	// 使用递归完成删除

//	void delete(int id, int pid);
	 void delete(int id);

	int findParentGradeByPid(int pid);

	void updateParent(int pid);

	Category findById(int id);
	
	Category findByPid(int pid);

	/* 类级别为3的所有类别 */
	List<Category> findThree();

	/* List<Category> find(int grade); */
}
