<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"
	isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>登录注册表单界面</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<script src="js/jquery.min.js" type="text/javascript"></script>
<style type="text/css">
.error_msg {
	color: red;
}
</style>
</head>
<body>
	<!-- <p class="center">登录用户名为：admin，密码为admin</p>
<p class="center">在用户名和密码错误时，点击登录按钮可以看到表单的摇晃效果。</p> -->
	<div id="wrapper" class="login-page">
		<div id="login_form" class="form">
			<form class="register-form" action="#" method="post">
				<input type="text" placeholder="用户名" name="aname" value="admin"
					id="r_user_name" /> <input type="password" placeholder="密码"
					name="apwd" value="apwd" id="r_password" />
				<button id="create">创建账户</button>
				<p class="message">
					已经有了一个账户? <a href="#">立刻登录</a>
				</p>
			</form>
			<form class="login-form" action="login.admin" method="post">
				<h2>管理登录</h2>
				<input type="text" placeholder="用户名" name="adminName" value="admin"
					id="user_name" /><span class="error_msg">${msg}</span> <input
					type="password" placeholder="密码" name="adminPassword" value="apwd"
					id="password" /> <input type="text" placeholder="验证码" name="code"
					id="inputvalidate" style="width: 100px" /> 
					<a id="changeCode" href="javascript:;">
					<img src="code.code" id="img">看不清，换一个</a>
				<script type="text/javascript">
					$(function() {
						$("#changeCode").click(function() {
							//点击时再次访问CodeServlet 随机生成一个验证码
							//document.getElementById("img").src = "code.code?"+Math.random();
							$("#img").attr("src","code.code?code="+new Date().getTime());
							
						})
					})
				</script>

				<button id="login">登 录</button>
				<p class="message">
					还没有账户? <a href="#">立刻创建</a>
				</p>
			</form>
		</div>
	</div>
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<script type="text/javascript">
		/* function check_login()
		{
		 var name=$("#user_name").val();
		 var pass=$("#password").val();
		 if(name=="admin" && pass=="admin")
		 {
		  alert("登录成功！");
		  $("#user_name").val("");
		  $("#password").val("");
		   $(location).attr('href', 'index.html');
		 }
		 else
		 {
		  $("#login_form").removeClass('shake_effect');  
		  setTimeout(function()
		  {
		   $("#login_form").addClass('shake_effect')
		  },1);  
		 }
		}
		function check_register(){
			var name = $("#r_user_name").val();
			var pass = $("#r_password").val();
			if(name!="" && pass=="")
			 {
			  alert("注册成功！");
			  $("#user_name").val("");
			  $("#password").val("");
			 }
			 else
			 {
			  $("#login_form").removeClass('shake_effect');  
			  setTimeout(function()
			  {
			   $("#login_form").addClass('shake_effect')
			  },1);  
			 }
		}
		$(function(){
			$("#create").click(function(){
				check_register();
				return false;
			})
			$("#login").click(function(){
				check_login();
				return false;
			})
			$('.message a').click(function () {
			    $('form').animate({
			        height: 'toggle',
			        opacity: 'toggle'
			    }, 'slow');
			});
		}) */
	</script>
</body>
</html>