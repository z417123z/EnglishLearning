<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>修改</title>
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
					修改
				</div>
				<div class="panel-body">
					<form action="<%=path%>/user/update" method="post"
						id="addForm">
						<input name="id" type="hidden" value="${sessionScope.user.id}" />
						<div class="container-fluid">
							<div class="row rowmargin">
								<div class="col-sm-7">
									<div class="form-group">
										<label class="col-sm-3 control-label">
											<font color="red">*</font>编号
										</label>
										<div class="col-sm-9 form-inline">
											<input id="id" name="id" size="35" readonly="readonly"
												class="form-control" type="text" value="${sessionScope.user.id}"
												/>
										</div>
									</div>
								</div>
							</div>
							<div class="row rowmargin">
								<div class="col-sm-7">
									<div class="form-group">
										<label class="col-sm-3 control-label">
											<font color="red">*</font>账号
										</label>
										<div class="col-sm-9 form-inline">
											<input id="username" name="username" size="35" class="form-control" readonly="readonly"
												type="text" value="${sessionScope.user.username}" tip="请输入账号" />
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
												type="text" value="${sessionScope.user.name}" tip="请输入姓名" />
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
											<input id="password" name="password" size="35" class="form-control"
												type="text" value="${sessionScope.user.password}" tip="请输入密码" />
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
												type="text" value="${sessionScope.user.tel}" tip="请输入电话" />
										</div>
									</div>
								</div>
							</div>
							<%--<div class="row rowmargin">
								<div class="col-sm-7">
									<div class="form-group">
										<label class="col-sm-3 control-label">
											<font color="red">*</font>出生日期
										</label>
										<div class="col-sm-9 form-inline">
											<input id="chusheng" name="chusheng" size="35"
												class="form-control" readonly="readonly"
												onClick="WdatePicker()" type="text" value="${user.chusheng}"
												tip="请输入出生日期" />
										</div>
									</div>
								</div>
							</div>--%>
							<%--<div class="row rowmargin">
								<div class="col-sm-7">
									<div class="form-group">
										<label class="col-sm-3 control-label">
											<font color="red">*</font>头像
										</label>
										<div class="col-sm-9 form-inline">
											<input id="url" readonly="readonly" name="url"
												value="${user.url}" size="35" class="form-control"
												type="text" tip="请上传文件" />
											<input type="button" value="上传" onclick="up('url',0)" />
										</div>
									</div>
								</div>
							</div>--%>
							<div class="row">
								<div class="col-sm-2">
								</div>
								<div class="col-sm-4" style="margin-left: 20px;">
									<button type="submit" class="btn btn-primary"
										style="margin-top: 40px;">
										提交
									</button>
									<button type="button" id="rebackBtn" class="btn btn-default"
										style="margin-top: 40px; margin-left: 20px;">
										返回
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
$(document).ready(function(){
	$("#rebackBtn").click(function(){
	    window.history.go(-1); 
	});
    $("#addForm").validate({
        submitHandler:function(form){//验证通过后的执行方法
			form.submit();
			},
		rules: {
			id:{
				required:true,
			},
			username:{
				required:true,
			},
			name:{
				required:true,
			},
			password:{
				required:true,
			},
			tel:{
				telphone:true,
			},
		},
    messages:{
		id:{
			required:'编号不能为空',
		},
		username:{
			required:'账号不能为空',
		},
		name:{
			required:'姓名不能为空',
		},
		password:{
			required:'密码不能为空',
		},
		tel:{
			telphone:'电话格式错误',
		},

    }
});
});
        var pop;
    function up(fname,type)
    {
        pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:200});
        pop.setContent("contentUrl","<%=path %>/login/upload?fname="+fname + "&pt=" + type);
        pop.setContent("title","文件上传");
        pop.build();
        pop.show();
    }
    function popupClose(){
        pop.close();
    }
    </script>
</html>