<%@page import="jdk.internal.util.xml.impl.Input"%>
<%@page import="com.neuedu.ssm_shop.pojo.Admin"%>
<%@page import="java.util.List"%>
<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"
	isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="admin_input.jsp"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>类别列表</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="css/font.css">
<link rel="stylesheet" href="css/xadmin.css">
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="js/xadmin.js"></script>
<script type="text/javascript">
	$(function() {
		$.ajax({
			url : "findToTree.category",
			dataType : "json",
			success : function(categories) {
				findToTree(categories);
				
			}
		});
		//定义一个递归函数
		function findToTree(categories) {
			var str = "";
			//递归遍历结果集
			for ( let i in categories) {
			
			let c = categories[i];
			if(c.grade == 1){
				str = "";
			}else if(c.grade == 2){
				str = "----";
			}else if(c.grade == 3){
				str = "--------";
			}
			var tr = "<tr><td><div class='layui-unselect layui-form-checkbox' lay-skin='primary' data-id='2'><i class='layui-icon'>&#xe605;</i></div></td>"
			+ "<td>"
			+ c.id 
			+ "</td><td>"
			+ (str+c.categoryName)
			+ "</td><td>"
			+ c.categoryDescription
			+ "</td><td>"
			+ c.categoryParentId
			+ "</td><td>"
			+ c.leaf
			+ "</td><td>"
			+ c.grade
			+ "</td>"
			+ "<td class='td-manage'><a title='添加子类别' onclick='x_category_show('添加子类别','load.category?id=${category.id}')'"
			+ "href='load.category?id="
			+ c.id
			+ "&pid="
			+ c.categoryParentId
			+ "'> <i class='layui-icon'>&#xe642;</i>"
			+ "</a> <a title='删除' onclick='category_del(this,'delete.category?id=${category.id}')'"
			+ "href='delete.category?id="
			+ c.id
			+ "&pid="
			+ c.categoryParentId
			+ "'> <i class='layui-icon'>&#xe640;</i>"
		+"</a></td>"
	+"</tr>";
				//不是叶子节点  递归
				//href='delete.category？id="+ c.id + 
				//显示到html页面中
				if (!c.leaf) {
					$(tr).appendTo("#categories");
					//递归
					findToTree(c.children);
				} else {
					$(tr).appendTo("#categories");
				}
			}
		}
	});
</script>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="">首页</a> <a href="">演示</a>
			<a> <cite>导航元素</cite></a>
		</span> <a class="layui-btn layui-btn-primary layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 38px">ဂ</i></a>
	</div>
	<div class="x-body">
		<div class="layui-row">
			<form class="layui-form layui-col-md12 x-so">
				<input class="layui-input" placeholder="开始日" name="start" id="start">
				<input class="layui-input" placeholder="截止日" name="end" id="end">
				<input type="text" name="user_name" placeholder="请输入用户名"
					autocomplete="off" class="layui-input">
				<button class="layui-btn" lay-submit="" lay-filter="sreach">
					<i class="layui-icon">&#xe615;</i>
				</button>
			</form>
		</div>
		<xblock>
		<button class="layui-btn layui-btn-danger" onclick="delAll()">
			<i class="layui-icon"></i>批量删除
		</button>
		<button class="layui-btn"
			onclick="x_admin_show('添加用户','category_insertRoot.jsp')">
			<i class="layui-icon"></i>添加
		</button>
		<span class="x-right" style="line-height: 40px">共有数据：88 条</span> </xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>
						<div class="layui-unselect header layui-form-checkbox"
							lay-skin="primary">
							<i class="layui-icon">&#xe605;</i>
						</div>
					</th>
					<th>类别ID</th>
					<th>类别名称</th>
					<th>类别描述</th>
					<th>父类别ID</th>
					<th>是否是叶子节点</th>
					<th>类别级别</th>
					<th>修改操作</th>
			</thead>
			<tbody id="categories">
				<%-- <tr>
					<td>
						<div class="layui-unselect layui-form-checkbox" lay-skin="primary"
							data-id='2'>
							<i class="layui-icon">&#xe605;</i>
						</div>
					</td>
					<!-- 循环admins对象的所有数据 -->
					<td>${admin.id}</td>
					<td>${admin.adminName}</td>
					<td>${admin.adminPassword}</td>
					<td class="td-manage"><a title="编辑"
						onclick="x_admin_show('编辑','load.admin?id=${admin.id}')"
						href="javascript:;"> <i class="layui-icon">&#xe642;</i>
					</a> <a title="删除" onclick="admin_del(this,'${admin.id}')"
						href="javascript:;"> <i class="layui-icon">&#xe640;</i>
					</a></td>
				</tr> --%>
				<%-- <% }%> --%>
			</tbody>
		</table>
		<div class="page">
			<div>
				<a class="prev" href="">&lt;&lt;</a> <a class="num" href="">1</a> <span
					class="current">2</span> <a class="num" href="">3</a> <a
					class="num" href="">489</a> <a class="next" href="">&gt;&gt;</a>
			</div>
		</div>

	</div>
	<script>
		layui.use('laydate', function() {
			var laydate = layui.laydate;

			//执行一个laydate实例
			laydate.render({
				elem : '#start' //指定元素
			});

			//执行一个laydate实例
			laydate.render({
				elem : '#end' //指定元素
			});
		});

		/*用户-停用*/
		function member_stop(obj, id) {
			layer.confirm('确认要停用吗？', function(index) {

				if ($(obj).attr('title') == '启用') {

					//发异步把用户状态进行更改
					$(obj).attr('title', '停用')
					$(obj).find('i').html('&#xe62f;');

					$(obj).parents("tr").find(".td-status").find('span')
							.addClass('layui-btn-disabled').html('已停用');
					layer.msg('已停用!', {
						icon : 5,
						time : 1000
					});

				} else {
					$(obj).attr('title', '启用')
					$(obj).find('i').html('&#xe601;');

					$(obj).parents("tr").find(".td-status").find('span')
							.removeClass('layui-btn-disabled').html('已启用');
					layer.msg('已启用!', {
						icon : 5,
						time : 1000
					});
				}

			});
		}

		/*用户-删除*/
		function category_del(obj, id) {
			layer.confirm('确认要删除吗？', function(index) {
				//发异步删除数据
				$(obj).parents("tr").remove();
				$.ajax({
					url : 'delete.category',
					data : {
						"id" : id
					},
					traditional : true,
					type : "POST"
				});
				layer.msg('已删除!', {
					icon : 1,
					time : 1000
				});
			});
		}

		function delAll(argument) {

			var data = tableCheck.getData();

			layer.confirm('确认要删除吗？' + data, function(index) {
				//捉到所有被选中的，发异步进行删除
				layer.msg('删除成功', {
					icon : 1
				});
				$(".layui-form-checked").not('.header').parents('tr').remove();
			});
		}
	</script>
</body>

</html>