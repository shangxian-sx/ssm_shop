package com.neuedu.ssm_shop.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuedu.ssm_shop.pojo.Admin;
import com.neuedu.ssm_shop.service.AdminService;



@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	//遍历用户
	@RequestMapping("/findAll.admin")
	public String findAll(HttpServletRequest request){
		List<Admin> admins = adminService.findAll();
		request.setAttribute("admins", admins);
		return "admin_list.jsp";
	}
	
	//添加用户
	@RequestMapping("insert.admin")
	public String insert(Admin admin,HttpServletRequest request) {
		adminService.insert(admin);
		System.out.println("=========走到了adminController中的insert方法=====");
		return "findAll.admin";
	}
	
	//查找findByid
	@RequestMapping("/load.admin")
	public String findByid(int id,HttpServletRequest request) {
		Admin admin = adminService.findById(id);
		System.out.println(admin);
		request.setAttribute("admin", admin);
		
		return "admin_edit.jsp";
	}
	
	//更新用户
	@RequestMapping("/update.admin")
	public String update(int id ,Admin admin, HttpServletRequest request) {
		System.out.println("=========走到了adminController中的update方法中====");
		Admin admin1 = adminService.findById(id);
		admin1.setAdminName(admin.getAdminName());
		admin1.setAdminPassword(admin.getAdminPassword());
		adminService.update(admin1);
		System.out.println(admin1);
		return "findAll.admin";
	}
	
	//删除用户
	@RequestMapping("/delete.admin")
	public String delete(int id,HttpServletRequest request) {
		System.out.println("=============delete+++++++++++");
		id = Integer.parseInt(request.getParameter("id"));
		adminService.delete(id);
		System.out.println("=========走到了AdminController中delete方法======");
		return "findAll.admin";
	}
	
	//用户登录
	@RequestMapping("/login.admin")
	public String login(Admin admin,HttpServletRequest request) {
		Admin admin1 = adminService.login(admin.getAdminName(), admin.getAdminPassword());
		String code = request.getParameter("code");
		HttpSession session = request.getSession();
		String checkcode = (String)session.getAttribute("code");
		String f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		System.out.println(f);
		if(admin1 != null) {
			if(checkcode.equals(code)) {
				session.setAttribute("admin", admin);
				System.out.println("验证码正确=============");
				System.out.println("登陆成功============");
				return "redirect:index.jsp";
			}else {
				request.setAttribute("code_msg", "验证码有误，请重新输入！");
				System.out.println("验证码有误================");
				return "admin_login.jsp";
			}
		}else {
			System.out.println("用户名不存在===============");
			return "admin_login.jsp";
		}
		
	}
	
	//用户登出
	@RequestMapping("/login-out.admin")
	public String login_out(HttpServletRequest request) {
		request.getSession().invalidate();
		return "login.admin";
	}
	
}
