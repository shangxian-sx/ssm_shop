<%@page import="java.sql.Time"%>
<%@page import="com.neuedu.ssm_shop.pojo.Admin"%>
<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"
	isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	//从session对象中获取admin对象
	Admin admin = (Admin)session.getAttribute("admin");
	if(admin == null){
		response.sendRedirect("admin_login.jsp");
		return;
	}
	
%>