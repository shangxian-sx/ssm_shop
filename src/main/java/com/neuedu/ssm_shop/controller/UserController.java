package com.neuedu.ssm_shop.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.ssm_shop.pojo.User;
import com.neuedu.ssm_shop.service.UserService;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * @author Administrator
 *
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	//遍历用户
	@RequestMapping(value = "/findAll.user")
	public String findAll(HttpServletRequest request) {
		List<User> users = userService.findAll();
		request.setAttribute("users", users);
		return "user_list.jsp";
	}

	@RequestMapping(value = "/user")
	@ResponseBody
	public List<User> user() {
		System.out.println("=====================");

		return userService.findAll();
	}
	//更新业务中的findByid
	@RequestMapping(value = "/load.user")
	public String findByid(int id,HttpServletRequest request) {
		User user = userService.findById(id);
		System.out.println(user);
		request.setAttribute("user", user);
		System.out.println("==============走到了UserController的load。user方法======findByid=======");
		System.out.println(user);
		return "user_edit.jsp";
	}
	//更新业务
	@RequestMapping(value = "/update.user")
	public String update(User user, HttpServletRequest request) {
		User user1 = userService.findById(user.getId());
		System.out.println(user.getUserName());
		user1.setUserName(user.getUserName());
		user1.setUserPassword(user.getUserPassword());
		user1.setUserPhone(user.getUserPhone());
		user1.setUserAddr(user.getUserAddr());
		userService.update(user1);
		System.out.println("================走到了UserController中的update。user方法============");
		return "findAll.user";
	}
	//增加用户
	@RequestMapping("/insert.user")
	public String insert(String userName,String userPassword,String userPhone,String userAddr,HttpServletRequest request) {
		System.out.println("=============走到了UserController中的insert=======");
		User user = new User();
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		user.setUserPhone(userPhone);
		user.setUserAddr(userAddr);
		userService.insert(user);
		System.out.println(user);
		
		return "findAll.user";
	}
	//删除用户
	@RequestMapping("/delete.user")
	public String delete(int id,HttpServletRequest request) {
		id = Integer.parseInt(request.getParameter("id"));
		userService.delete(id);
		System.out.println("==========走到了UserController中的delete方法");
		return "findAll.user";
	}

}
