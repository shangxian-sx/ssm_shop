package com.neuedu.ssm_shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.neuedu.ssm_shop.pojo.Category;
import com.neuedu.ssm_shop.pojo.CategoryBean;
import com.neuedu.ssm_shop.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	/*
	 * @RequestMapping("/findToTree") public String findToTree(HttpServletRequest
	 * request,HttpServletResponse response) throws IOException { List<Category>
	 * categorys = categoryService.findToTree(); PrintWriter out =
	 * response.getWriter(); out.print(JSON.toJSONString(categorys)); return
	 * "category_list.jsp"; }
	 */
	/**
	 * 树状列表显示
	 * 
	 * @return
	 */
	@RequestMapping("/findToTree.category")
	@ResponseBody
	public List<Category> findToTree() {
		return categoryService.findToTree();
	}

	/**
	 * 添加根类别
	 */
	@RequestMapping("/insertRoot.category")
	public String insertRoot(String categoryName, String categoryDescription) {
		categoryService.insertRoot(categoryName, categoryDescription);

		return "redirect:category_list.jsp";
	}

	/**
	 * 添加子类别
	 * 
	 * @return
	 */
	@RequestMapping("insertChild.category")
	public String insertChild(String categoryName, String categoryDescription, int categoryParentId) {
		categoryService.insertChild(categoryName, categoryDescription, categoryParentId);
		return "redirect:category_list.jsp";
	}

	/**
	 * 根据id查找数据
	 * 
	 * @return
	 */
	@RequestMapping("/load.category")
	public String load(Integer id, ModelMap map) {
		Category category = categoryService.findById(id);
		System.out.println(id);
		System.out.println(category.getCategoryName());
		map.addAttribute("category", category);
		
		return "category_insertChild.jsp";
	}

	/**
	 * 删除类别 递归删除
	 */

	@RequestMapping("/delete.category")
	public String delete(int id) {
		System.out.println("进入了category的delete方法=============");
		Category category = categoryService.findById(id);
		int pid = category.getCategoryParentId();
		
		System.out.println("id = " + id + " ; pid = " + pid);
		System.out.println();
		if(category.getLeaf() == true) {
			System.out.println("进入了 叶子节点 业务");
			categoryService.delete(id);
			System.out.println("service执行成功");
		}else {
			/*
			 * int p_category = categoryService.findParentGradeByPid(pid = id);
			 * System.out.println("查到不是叶子节点，");
			 */
			System.out.println("进入了  非叶子节点 的业务==========");
			System.out.println("pid="+pid);
			System.out.println("id="+id);
			pid = id;
			System.out.println("找儿子==输入 pid" + pid); 
			System.out.println("===============");
			Category category1 = categoryService.findByPid(pid);
			System.out.println("=============-----------");
			System.out.println(category1);
		}
		
		return "index.jsp";
	}

}
