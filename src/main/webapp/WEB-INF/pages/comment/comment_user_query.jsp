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
	<form action="<%=path%>/comment/toQueryContentUser?id=${userId}" class="form-inline"
		  method="post">
		<div class="panel panel-default">
			<div class="panel-heading">
				评价列表
			</div>
			<div class="panel-body">
				<div class="pull-left">

					<div class="form-group qinfo">
						<label>
							内容查找：
						</label>
						<input name="content" class="form-control" type="text">
					</div>

					<button type="submit" class="btn btn-default">
						查询
					</button>
				</div>
			</div>
		</div>
	</form>
	<c:if test="${page!=null}">
		<div class="table-responsive">
			<table class="table table-striped table-hover"
				   style="text-align: center;">
				<thead>
				<tr>

					<th>id</th>
					<th>用户名</th>
					<th>用户姓名</th>
					<th>评论者</th>
					<th>评论时间</th>
					<th>评论内容</th>
					<th>操作</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${pageInfo.list}" var="comment">
					<tr>
						<td>
							<a style="color: #000000"
							   href="<%=path%>/comment/toView?id=${comment.id}">${comment.id}</a>
						</td>
						<td>${comment.user_username}</td>
						<td>${comment.user_name}</td>
						<td>${comment.admin_name}</td>
						<td>
							<fmt:formatDate value="${comment.aDate}" pattern="yyyy-MM-dd"/>
						</td>
						<td>${comment.content}</td>


						<td>
							<a href="<%=path%>/comment/toView?id=${comment.id}" class="btn btn-success">
								<span class="glyphicon glyphicon-eye-open"></span>
								查看</a>

							<a href="<%=path%>/comment/hideContent?id=${comment.id}" class="btn btn-warning">
								<span class="glyphicon glyphicon-ban-circle"></span>
								删除</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<div style="display:flex;justify-content:center; ">
				<nav aria-label="Page navigation">
					<ul class="pagination">
						<c:if test="${pageInfo.hasPreviousPage}">
							<li>
								<a href="${pageContext.request.contextPath}/comment/toQueryContentUser?page=${pageInfo.prePage}&rows=${pageInfo.pageSize}
									&content=${content}&id=${userId}" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span>
								</a>
							</li>
						</c:if>
						<c:forEach items="${pageInfo.navigatepageNums}" var="nav">
							<c:if test="${nav == pageInfo.pageNum}">
								<li><a href="#">${nav}</a></li>
							</c:if>

							<c:if test="${nav != pageInfo.pageNum}">
								<li>
									<a href="${pageContext.request.contextPath}/comment/toQueryContentUser?page=${nav}&rows=${pageInfo.pageSize}
										&content=${content}&id=${userId}">${nav}</a>
								</li>
							</c:if>
						</c:forEach>
						<c:if test="${pageInfo.hasNextPage}">
							<li>
								<a href="${pageContext.request.contextPath}/comment/toQueryContentList?page=${pageInfo.nextPage}&rows=${pageInfo.pageSize}
									&content=${content}&id=${userId}" aria-label="Next">
									<span aria-hidden="true">&raquo;</span>
								</a>
							</li>
						</c:if>
					</ul>
				</nav>
			</div>
		</div>
	</c:if>
</div>
</body>
</html>
<script type="text/javascript">
	function delInfo(id){
		if(confirm("是否确认删除？")){
			window.location.href = '<%=path%>/comment/delete?id=' + id;
		}
	}
</script>