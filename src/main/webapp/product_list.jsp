<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />

<title>电商平台后台管理</title>
<link rel="stylesheet" href="css1/bootstrap.css" />
<link rel="stylesheet" href="css1/bootstrap-responsive.css" />
<link rel="stylesheet" href="css1/styles.css" />
<link rel="stylesheet" href="css1/toastr.css" />
<link rel="stylesheet" href="css1/fullcalendar.css" />
<script src="js1/jquery.min.js"></script>
<script src="js1/bootstrap.js"></script>
<script src="js1/jquery.knob.js"></script>
<script src="js1/d3.v3.min.js"></script>
<script src="js1/jquery.sparkline.min.js"></script>
<script src="js1/toastr.js"></script>
<script src="js1/jquery.tablesorter.min.js"></script>
<script src="js1/jquery.peity.min.js"></script>
<script src="js1/fullcalendar.min.js"></script>
<script src="js1/gcal.js"></script>
<script src="js1/setup.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#normalprice").blur(function(){
			$("#memberprice").val(Math.round($("#normalprice").val()*.8*100.00)/100.00);
		});
		
		$("#pname").blur(function(){
			$("#pdescr").val($("#pname").val())
		});
		
		$.ajax({
			url:"findThree.product",
			success:function(data){
				for(let i=0;i<data.length;i++){
					$("#category").append("<option value="+data[i].id+">"+data[i].categoryName+"</option>");
				}
			}
		});
	});
</script>
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="page">
		<div class="page-container">
			<div class="container">
				<div class="row">
					<div class="span12">
						<a href="#newUserModal" data-toggle="modal" class="btn pull-right">添加新商品</a>
						<h4 class="header">商品列表</h4>
						<form action="search_product_simple_complete.html" method="post">
							<input type="text" name="keywords" class="form-control" placeholder="请输入搜索关键字">&nbsp;
							<input class="btn btn-info" type="submit" value="搜索">
						</form>
						<table class="table table-striped sortable">
							<thead>
								<tr>
									<th>商品ID</th>
									<th>商品名称</th>
									<th>商品描述</th>
									<th>普通价格</th>
									<th>会员价格</th>
									<th>上架日期</th>
									<th>所属类别</th>
									<!-- <th>图片路径</th> -->
									<th width="100">图片</th>
								</tr>
							</thead>
							<tbody>
								
								<c:forEach items="${products }" var="p">
								<tr>
									<td>${p.id }</td>
									<td>${p.name }</td>
									<td>${p.descr }</td>
									<td>${p.normalprice }</td>
									<td>${p.memberprice }</td>
									<td>${p.pdate }</td>
									<td>${p.category.categoryName }</td>
									<td>
										<img src="<%=path%>${p.imgPath}" >
									</td>
									<td>
										<div class="btn-group">
											<button class="btn">操作</button>
											<button data-toggle="dropdown" class="btn dropdown-toggle">
												<span class="caret"></span>
											</button>
											<ul class="dropdown-menu">
												<li><a href="#">修改</a> <a id="confirm_delete${p.id }"
													href="javascript:void(0);">删除</a></li>
											<script>
												$(document).ready(function(){
													$("#confirm_delete"+${p.id }).click(function(){
														if(confirm("你确定要删除么？")){
															$(location).attr('href', "delete.product?id="+${p.id});
														};
													});
												});
											</script>
											</ul>
										</div>
									</td>
									
								</tr>
								</c:forEach>
								
							</tbody>
						</table>
						<div class="pagination pagination-centered">
							<ul>
								<li class="disabled"><a href="#">&laquo;</a></li>
								<li class="active"><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#">&raquo;</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div id="newUserModal" class="modal hide fade">
				<div class="modal-header">
					<button type="button" data-dismiss="modal" aria-hidden="true"
						class="close">&times;</button>
					<h3>添加新商品</h3>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" action="insert.product" method="post" enctype="multipart/form-data">
						<div class="control-group">
							<label for="inputEmail"  class="control-label">商品名称</label>
							<div class="controls">
								<input id="pname" name="name" type="text" placeholder="请输入商品名称" />
							</div>
						</div>
						<div class="control-group">
							<label for="inputCurrentPassword"  class="control-label">商品描述
							</label>
							<div class="controls">
								<input id="pdescr" name="descr" type="text"
									placeholder="请输入商品描述" />
							</div>
						</div>
						<div class="control-group">
							<label for="inputCurrentPassword" class="control-label">普通价格
							</label>
							<div class="controls">
								<input id="normalprice" name="normalprice" type="text"
									placeholder="普通价格" />
							</div>
						</div>
						<div class="control-group">
							<label for="inputCurrentPassword" class="control-label">会员价格
							</label>
							<div class="controls">
								<input id="memberprice" type="text" name="memberprice"
									placeholder="会员价格" readonly="readonly"/>
							</div>
						</div>
						<!-- 图片 -->
						<div class="control-group">
							<label for="inputCurrentPassword" class="control-label">图片上传
							</label>
							<div class="controls">
								<input id="img" type="file" name="file"
									placeholder="请上传图片" />
							</div>
						</div>
						
						<div class="control-group">
							<label for="inputCurrentPassword" class="control-label">商品类别
							</label>
							<div class="controls">
							<select id="category" name="categoryid">
								<option value="-1">--商品类别--</option>
							</select>
							</div>
							
						</div>
						<div class="modal-footer">
							<a href="#" data-dismiss="modal" class="btn">关闭</a><input
								type="submit" class="btn btn-primary"
								value="添加商品" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
<script src="js/d3-setup.js"></script>
</html>