<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>详情</title>
<link href="<%=path%>/resources/wyc/css/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
<script src="<%=path%>/resources/wyc/js/jquery-3.4.1.min.js"></script>
<script src="<%=path%>/resources/wyc/css/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=path%>/resources/wyc/js/jquery.validate.min.js"></script>
<script src="<%=path%>/resources/wyc/js/jquery.validate.extend.js"></script>
<link href="<%=path%>/resources/wyc/css/pdmcontent01.css" rel="stylesheet">
</head>
<body>
	<div class="page-content">
		<div class="panel panel-default">
			<div class="panel-heading">详情</div>
			<div class="panel-body">
				<div class="container-fluid">
					<div class="row rowmargin">
						<div class="col-sm-7">
							<div class="form-group">
								<label class="col-sm-3 control-label">
									<font color="red">*</font>
									书名
								</label>
								<div class="col-sm-9 form-inline">
									<input id="username" name="username" size="35" value="${book.name}" readonly="readonly" class="form-control" type="text" />
								</div>
							</div>
						</div>
					</div>
					<div class="row rowmargin">
						<div class="col-sm-7">
							<div class="form-group">
								<label class="col-sm-3 control-label">
									<font color="red">*</font>
									适用年级
								</label>
								<div class="col-sm-9 form-inline">
									<input id="password" name="password" size="35" value="${book.grade}" readonly="readonly" class="form-control" type="text" />
								</div>
							</div>
						</div>
					</div>
					<div class="row rowmargin">
						<div class="col-sm-7">
							<div class="form-group">
								<label class="col-sm-3 control-label">
									<font color="red">*</font>
									书中单词量
								</label>
								<div class="col-sm-9 form-inline">
									<input id="name" name="name" size="35" value="${pageInfo.total}" readonly="readonly" class="form-control" type="text" />
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-2"></div>
						<div class="col-sm-4" style="margin-left: 20px;">
							<button type="button" id="rebackBtn" class="btn btn-default" style="margin-top: 40px; margin-left: 20px;">返回</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$("#rebackBtn").click(function() {
			window.history.go(-1);
		});
	});
</script>
</html>
