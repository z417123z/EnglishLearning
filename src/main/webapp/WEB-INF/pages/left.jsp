<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="<%=path%>/resources/wyc/css/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
	<link href="<%=path%>/resources/wyc/css/left.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="<%=path%>/resources/wyc/js/jquery-3.4.1.min.js"></script>
	<script src="<%=path%>/resources/wyc/css/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/wyc/js/jquery-pdm.js"></script>
	<title>菜单栏</title>
</head>
<body>

<!--main-->
<div class="container-fluid mybody">
	<div class="main-wapper">
		<!--菜单-->
		<div id="siderbar" class="siderbar-wapper">

			<div class="panel-group menu" id="accordion" role="tablist" aria-multiselectable="true">

				<%--管理员--%>
				<c:if test="${sessionScope.utype == 0}">
					<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="headingOne">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
									<span class="glyphicon glyphicon-list-alt"></span>
									系统管理
								</a>
							</h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
							<div class="list-group list-group-self">
								<a href="<%=path%>/admin/list" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									管理员列表
								</a>
								<a href="<%=path%>/admin/upwd" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									修改密码
								</a>
							</div>
						</div>
					</div>

					<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="headingSeven">
							<h4 class="panel-title">
								<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseSeven" aria-expanded="false" aria-controls="collapseSeven">
									<span class="glyphicon glyphicon-th-large"></span>
									用户信息管理
								</a>
							</h4>
						</div>
						<div id="collapseSeven" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingSeven">
							<div class="list-group list-group-self">
								<a href="<%=path%>/user/list" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									用户信息管理
								</a>
							</div>
						</div>
					</div>

					<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="headingTwo">
							<h4 class="panel-title">
								<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
									<span class="glyphicon glyphicon-th"></span>
									图书信息管理
								</a>
							</h4>
						</div>
						<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
							<div class="list-group list-group-self">
								<a href="<%=path%>/book/list" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									图书管理
								</a>
								<a href="<%=path%>/word/list" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									单词管理
								</a>
							</div>
						</div>
					</div>

					<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="headingN1">
							<h4 class="panel-title">
								<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseN1" aria-expanded="false" aria-controls="collapseN1">
									<span class="glyphicon glyphicon-th"></span>
									评论留言管理
								</a>
							</h4>
						</div>
						<div id="collapseN1" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingN1">
							<div class="list-group list-group-self">
								<a href="<%=path%>/comment/list" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									留言总表
								</a>
								<a href="<%=path%>/comment/allUserList" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									用户查看表
								</a>
							</div>
						</div>
					</div>
				</c:if>






				<%--用户--%>
				<c:if test="${sessionScope.utype == 1}">
					<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="headingOne">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
									<span class="glyphicon glyphicon-list-alt"></span>
									用户信息
								</a>
							</h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
							<div class="list-group list-group-self">
								<a href="<%=path%>/user/user_info?id=${sessionScope.user.id}" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									用户个人信息
								</a>
								<a href="<%=path%>/bookshelf/list" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									我的书架
								</a>
								<a href="<%=path%>/memory/list" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									我的单词表
								</a>
							</div>
						</div>
					</div>

					<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="headingTwo">
							<h4 class="panel-title">
								<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
									<span class="glyphicon glyphicon-th"></span>
									图书信息
								</a>
							</h4>
						</div>
						<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
							<div class="list-group list-group-self">
								<a href="<%=path%>/book/userBook" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									单词书查看
								</a>
								<a href="<%=path%>/word/userAllWords" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									查看单词列表
								</a>

							</div>
						</div>
					</div>

					<div class="panel panel-inner">
						<div class="panel-heading panel-heading-self" role="tab" id="headingN2">
							<h4 class="panel-title">
								<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseN2" aria-expanded="false" aria-controls="collapseTwo">
									<span class="glyphicon glyphicon-th"></span>
									查看评价
								</a>
							</h4>
						</div>
						<div id="collapseN2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingN2">
							<div class="list-group list-group-self">

								<a href="<%=path%>/comment/userList?id=${sessionScope.userId}" target="appiframe" class="list-group-item">
									<span class="glyphicon glyphicon-menu-right"></span>
									评价表
								</a>

							</div>
						</div>
					</div>

				</c:if>









			</div>
		</div>
		<!--菜单-->
		<!--内容-->
		<div id="content" class="main-content">

			<c:if test="${sessionScope.utype==0}">
				<iframe src="<%=path%>/admin/list" style="width: 100%; height: 100%;" id="appiframe" name="appiframe" frameborder="0"></iframe>
			</c:if>

			<c:if test="${sessionScope.utype==1}">
				<iframe src="<%=path%>/user/user_info?id=${user.id}" style="width: 100%; height: 100%;" id="appiframe" name="appiframe" frameborder="0"></iframe>
			</c:if>



		</div>
		<!--内容-->
	</div>

</div>

<!--main-->

</body>
</html>