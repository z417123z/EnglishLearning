<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>新增</title>
	<link href="<%=path%>/resources/wyc/css/bootstrap/css/bootstrap.css"
		  rel="stylesheet" type="text/css">
	<script src="<%=path%>/resources/wyc/js/jquery-3.4.1.min.js"></script>
	<script src="<%=path%>/resources/wyc/css/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=path%>/resources/wyc/js/jquery.validate.min.js"></script>
	<script src="<%=path%>/resources/wyc/js/jquery.validate.extend.js"></script>
	<script src="<%=path%>/resources/wyc/js/jquery.validate.method.js"></script>
	<script language="javascript" type="text/javascript"
			src="<%=path%>/resources/wyc/js/My97DatePicker/WdatePicker.js"></script>
	<link href="<%=path%>/resources/wyc/css/pdmcontent01.css" rel="stylesheet">
</head>
<body>
<div class="page-content">
	<div class="panel panel-default">
		<div class="panel-heading">
			新增
		</div>
		<div class="panel-body">
			<form action="<%=path%>/comment/add?userId=${userId}" method="post"
				  id="addForm">
				<div class="container-fluid">

					<div class="row rowmargin">
						<div class="col-sm-7">
							<div class="form-group">
								<label class="col-sm-3 control-label">
									给&nbsp&nbsp${name}&nbsp评论
								</label>
							</div>
						</div>
					</div>
					<div class="row rowmargin">
						<div class="col-sm-7">
							<div class="form-group">
								<label class="col-sm-3 control-label">
									用户名：
								</label>
								<div class="col-sm-9 form-inline">
									<input id="name" name="name" size="35"
										   value="${username}" readonly="readonly"
										   class="form-control" type="text" />
								</div>
							</div>
						</div>
					</div>

					<div class="row rowmargin">
						<div class="col-sm-7">
							<div class="form-group">
								<label class="col-sm-3 control-label">
									评论内容
								</label>
								<div class="col-sm-9 form-inline">
											<textarea rows="5" cols="80" id="content" name="content"  maxlength="500"
													  class="form-control" tip="请输入评论内容"></textarea>
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
				content : {
					required : true,
				},
			},
			messages:{
				content : {
					required : '评论不能为空',
				},
			}
		});
	});
</script>
</html>