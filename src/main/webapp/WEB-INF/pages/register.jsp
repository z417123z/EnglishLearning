<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>用户注册</title>
	<link href="<%=path%>/resources/wyc/css/bootstrap/css/bootstrap.css"
		  rel="stylesheet" type="text/css">
	<script src="<%=path%>/resources/wyc/js/jquery-3.4.1.min.js"></script>
	<script src="<%=path%>/resources/wyc/css/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=path%>/resources/wyc/js/jquery.validate.min.js"></script>
	<script src="<%=path%>/resources/wyc/js/jquery.validate.extend.js"></script>
	<script src="<%=path%>/resources/wyc/js/jquery.validate.method.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/wyc/js/popup.js"></script>
	<script language="javascript" type="text/javascript"
			src="<%=path%>/resources/wyc/js/My97DatePicker/WdatePicker.js"></script>
	<link href="<%=path%>/resources/wyc/css/pdmcontent01.css" rel="stylesheet">
</head>
<body>
<div class="page-content">
	<div class="panel panel-default">
		<div class="panel-heading">
			注册
			<p class="text-muted text-center"><small>已经有账户了？</small><a href="<%=path%>/login/loginInput" target="_self">点此登录</a>
			</p>
		</div>
		<div class="panel-body">
			<form action="<%=path%>/login/userReg" method="post" id="addForm">
				<div class="container-fluid">
					<div class="row rowmargin">
						<div class="col-sm-7">
							<div class="form-group">
								<label class="col-sm-3 control-label">
									<font color="red">*</font>账号
								</label>
								<div class="col-sm-9 form-inline">
									<input id="username" name="username" size="35" class="form-control"
										   type="text" value="" tip="请输入账号" />
								</div>
							</div>
						</div>
					</div>
					<div class="row rowmargin">
						<div class="col-sm-7">
							<div class="form-group">
								<label class="col-sm-3 control-label">
									<font color="red">*</font>姓名
								</label>
								<div class="col-sm-9 form-inline">
									<input id="name" name="name" size="35" class="form-control"
										   type="text" value="" tip="请输入姓名" />
								</div>
							</div>
						</div>
					</div>
					<div class="row rowmargin">
						<div class="col-sm-7">
							<div class="form-group">
								<label class="col-sm-3 control-label">
									<font color="red">*</font>密码
								</label>
								<div class="col-sm-9 form-inline">
									<input id="password" name="password" type="password" size="35" class="form-control"
										   value="" tip="请输入密码" />
								</div>
							</div>
						</div>
					</div>
					<div class="row rowmargin">
						<div class="col-sm-7">
							<div class="form-group">
								<label class="col-sm-3 control-label">
									性别
								</label>
								<div class="col-sm-9 form-inline">
									<select id="sex" name="sex" class="form-control">
										<option value="男">
											男
										</option>
										<option value="女">
											女
										</option>
									</select>
								</div>
							</div>
						</div>
					</div>
					<div class="row rowmargin">
						<div class="col-sm-7">
							<div class="form-group">
								<label class="col-sm-3 control-label">
									<font color="red">*</font>电话
								</label>
								<div class="col-sm-9 form-inline">
									<input id="tel" name="tel" size="35" class="form-control"
										   type="text" value="" tip="请输入电话" />
								</div>
							</div>
						</div>
					</div>
					<div class="row rowmargin">
						<div class="col-sm-7">
							<div class="form-group">
								<label class="col-sm-3 control-label">
									<font color="red">*</font>年级
								</label>
								<div class="col-sm-9 form-inline">
									<select id="grade" name="grade" class="form-control">
										<option value="高中">
											高中
										</option>
										<option value="大学">
											大学
										</option>
									</select>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-2">
						</div>
						<div class="col-sm-4" style="margin-left: 20px;">
							<button type="submit" class="btn btn-primary"
									style="margin-top: 40px;">
								注册
							</button>

						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$("#rebackBtn").click(function () {
			window.history.go(-1);
		});
	});
	$("#addForm").validate({
		submitHandler:function(form){//验证通过后的执行方法
			form.submit();
		},
		rules: {
			username:{
				required:true,
				remote: {
					url: "<%=path%>/user/usernameExist",
					type: "get",
					async:false,
					dataType: "json",
					data: {
						username: function (){ return $("#username").val();}
					},
					dataFilter: function (data) {
						return data;
					}
				}
			},
			name:{
				required:true,
			},
			password:{
				required:true,
			},
		},
		messages:{

			username:{
				required:'账号不能为空',
				remote:'账号已存在',
			},
			name:{
				required:'姓名不能为空',
			},
			password:{
				required:'密码不能为空',
			},

		}
	});
</script>
</html>