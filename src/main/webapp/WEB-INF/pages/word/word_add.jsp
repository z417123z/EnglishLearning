<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>新增</title>
<link href="<%=path%>/resources/wyc/css/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
<script src="<%=path%>/resources/wyc/js/jquery-3.4.1.min.js"></script>
<script src="<%=path%>/resources/wyc/css/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=path%>/resources/wyc/js/jquery.validate.min.js"></script>
<script src="<%=path%>/resources/wyc/js/jquery.validate.extend.js"></script>
<script src="<%=path%>/resources/wyc/js/jquery.validate.method.js"></script>
<script language="javascript" type="text/javascript" src="<%=path%>/resources/wyc/js/My97DatePicker/WdatePicker.js"></script>
<link href="<%=path%>/resources/wyc/css/pdmcontent01.css" rel="stylesheet">
</head>
<body>
	<div class="page-content">
		<div class="panel panel-default">
			<div class="panel-heading">新增</div>
			<div class="panel-body">
				<form action="<%=path%>/word/add" method="post" id="addForm">
					<div class="container-fluid">
						<div class="row rowmargin">
							<div class="col-sm-7">
								<div class="form-group">
									<label class="col-sm-3 control-label">
										<font color="red">*</font>
										单词
									</label>
									<div class="col-sm-9 form-inline">
										<input id="name" name="name" size="35" class="form-control" type="text" value="" tip="请输入用户名" />
									</div>
								</div>
							</div>
						</div>

						<div class="row rowmargin">
							<div class="col-sm-7">
								<div class="form-group">
									<label class="col-sm-3 control-label">释义 </label>
									<div class="col-sm-9 form-inline">
										<input id="translation" name="translation" size="35" class="form-control" type="text" value="" tip="请输入姓名" />
									</div>
								</div>
							</div>
						</div>

						
						<div class="row">
							<div class="col-sm-2"></div>
							<div class="col-sm-4" style="margin-left: 20px;">
								<button type="submit" class="btn btn-primary" style="margin-top: 40px;">提交</button>
								<button type="button" id="rebackBtn" class="btn btn-default" style="margin-top: 40px; margin-left: 20px;">返回</button>
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
		$("#rebackBtn").click(function() {
			window.history.go(-1);
		});
		$("#addForm").validate({
			submitHandler : function(form) {//验证通过后的执行方法
				form.submit();
			},
			rules : {
				username : {
					required : true,
				    remote: {
	                    url: "<%=path%>/word/nameExist",
							type : "post",
							dataType : "json",
							data : {
								name : function() {
									return $("#name").val();
								}
							},
							dataFilter : function(data) {
								return data;
							}
						}
				},
				translation : {
					required : true,
				},
			},
			messages : {
				name : {
					required : '单词不能为空',
					remote : '此单词已存在',
				},
				translation : {
					required : '释义不能为空',
				},
			}
		});
	});
</script>
</html>