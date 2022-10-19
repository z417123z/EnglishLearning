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
			<form action="<%=path%>/book/update" method="post"
				  id="addForm" enctype="multipart/form-data">
				<input name="id" type="hidden" value="${book.id}" />
				<div class="container-fluid">
					<div class="row rowmargin">
						<div class="col-sm-7">
							<div class="form-group">
								<label class="col-sm-3 control-label">
									<font color="red">*</font>书名
								</label>
								<div class="col-sm-9 form-inline">
									<input id="name" name="name" size="35" class="form-control"
										   type="text" value="${book.name}" tip="请输入书名" />
								</div>
							</div>
						</div>
					</div>
					<div class="row rowmargin">
						<div class="col-sm-7">
							<div class="form-group">
								<label class="col-sm-3 control-label">
									<font color="red">*</font>适用年级
								</label>
								<div class="col-sm-9 form-inline">
									<select id="grade" name="grade" class="form-control">
										<option <c:if test="${book.grade=='大学'}">selected</c:if>
												value="大学">
											大学
										</option>
										<option <c:if test="${book.grade=='高中'}">selected</c:if>
												value="高中">
											高中
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
									<font color="red">*</font>图书封面
								</label>
								<div class="col-sm-9 form-inline">
									<input id="picture" readonly="readonly" name="picture" size="35" class="form-control"
										   type="text" tip="请上传文件" />
									<input  type="file" value="请选择" onchange="upload(event)" />
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
								提交
							</button>

							<button type="button" id="rebackBtn" class="btn btn-default"
									style="margin-top: 40px; margin-left: 20px;">
								返回
							</button>
						</div>
					</div>
					<hr>
					<a href="<%=path%>/word/toAddWords?bookId=${book.id}">添加单词</a>
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
				name:{
					required:true,
				},
				grade:{
					required:true,
				},
			},
			messages:{
				name:{
					required:'姓名不能为空',
				},
				grade:{
					required:'年级不能为空',
				},
			}
		});
	});
	// 上传核心方法
	function upload(event) {
		let _file = event.target.files[0];
		let formData = new FormData();
		// HTML 文件类型input，由用户选择
		formData.append("file", _file);  //这里的file只是后台接收时的名字，可自行与后台沟通
		let xhr = new XMLHttpRequest(); // XMLHttpRequest 对象
		xhr.open("post", "<%=path%>/file/uploadMultipartFile", true);
		//post方式，url为服务器请求地址，true 该参数规定请求是否异步处理。
		//请求完成
		xhr.onload = (res) => {
			console.log("请求完成");
		};
		//上传开始执行方法
		xhr.upload.onloadstart = () => {
			console.log('上传中...');
		};
		xhr.send(formData);
	}


</script>
</html>