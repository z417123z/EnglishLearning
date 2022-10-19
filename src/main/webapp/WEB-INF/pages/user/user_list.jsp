<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="<%=path%>/resources/wyc/css/bootstrap/css/bootstrap.css"
		  rel="stylesheet" type="text/css">
	<link href="<%=path%>/resources/wyc/css/left.css" rel="stylesheet" type="text/css">
	<link href="<%=path%>/resources/wyc/css/pdmcontent01.css" rel="stylesheet"
		  type="text/css">
	<script type="text/javascript" src="<%=path%>/resources/wyc/js/jquery-3.4.1.min.js"></script>
	<script language="javascript" type="text/javascript"
			src="<%=path%>/resources/wyc/js/My97DatePicker/WdatePicker.js"></script>
	<script src="<%=path%>/resources/wyc/css/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/wyc/js/jquery-pdm.js"></script>
	<title>菜单栏</title>
</head>
<body>
<div class="page-content">
	<form action="<%=path%>/user/list" class="form-inline"
		  method="post">
		<div class="panel panel-default">
			<div class="panel-heading">
				用户列表
			</div>
			<div class="panel-body">
				<div class="pull-left">
					<div class="form-group qinfo">
						<label>
							账号：
						</label>
						<input name="username" value="${username}" class="form-control">
					</div>
					<div class="form-group qinfo">
						<label>
							姓名：
						</label>
						<input name="name" value="${name}" class="form-control">
					</div>

					<button type="submit" class="btn btn-default">
						查询
					</button>
				</div>
				<div class="pull-right">
					<button type="button" id="addBtn" class="btn btn-info">新增</button>
				</div>
			</div>
			<pg:pager url="/user/list" items="${itemSize}"
					  maxPageItems="${pageItem}" maxIndexPages="${pageItem}"
					  isOffset="${true}" export="offset,currentPageNumber=pageNumber"
					  scope="request">
				<pg:param name="username" value="${username}" />
				<pg:param name="name" value="${name}" />

				<div class="table-responsive">
					<table class="table table-striped table-hover"
						   style="text-align: center;">
						<thead>
						<tr>
							<td>
								编号
							</td>
							<td>
								账号
							</td>
							<td>
								姓名
							</td>
							<td>
								密码
							</td>
							<td>
								性别
							</td>
							<td>
								电话
							</td>
							<td>
								年级
							</td>
							<td>
								最后一次签到时间
							</td>
							<td>
								签到次数
							</td>

						</tr>
						</thead>
						<tbody>
						<c:forEach items="${list}" var="info">
							<tr>
								<td>
									<a style="color: #000000"
									   href="<%=path%>/user/userUpdate?userId=${info.id}">${info.id}</a>
								</td>
								<td>
										${info.username}
								</td>
								<td>
										${info.name}
								</td>
								<td>
										${info.password}
								</td>
								<td>
										${info.sex}
								</td>
								<td>
										${info.tel}
								</td>
								<td>
										${info.grade}
								</td>
								<td>
									<fmt:formatDate value="${info.signInTime}" pattern="yyyy-MM-dd"/>
								</td>
								<td>
										${info.signInNumber}
								</td>
								<td>
									<a href="<%=path%>/user/userUpdate?userId=${info.id}"
									   class="btn btn-info">
										<span class="glyphicon glyphicon-edit"></span>编辑</a>
									<a href="javascript:void();"
									   onclick="delInfo('${info.id}');"
									   class="btn btn-danger">
										<span class="glyphicon glyphicon-trash"></span>删除</a>

									<a href="<%=path%>/comment/toAdd?userId=${info.id}&username=${info.username}&name=${info.name}"
									   class="btn btn-success">
										<span class="glyphicon glyphicon-pencil"></span>留言</a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					<div class="panel-footer clearfix">

						<nav class="pull-right">
							<pg:index>
								<jsp:include page="/login/tag" flush="true" />
							</pg:index>
						</nav>
					</div>
				</div>
			</pg:pager>
		</div>
	</form>
</div>
</body>
</html>
<script type="text/javascript">
	$(document).ready(function(){
		$("#addBtn").click(function(){
			window.location.href = '<%=path%>/user/toAdd';
		});
	});
	function delInfo(id){
		if(confirm("是否确认删除？")){
			window.location.href = '<%=path%>/user/delete?id=' + id;
		}
	}
</script>