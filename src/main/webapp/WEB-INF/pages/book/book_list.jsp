<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
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
	<form action="<%=path%>/book/queryName" class="form-inline"
		  method="post">
		<div class="panel panel-default">
			<div class="panel-heading">
				单词书列表
			</div>
			<div class="panel-body">
				<div class="pull-left">
					<div class="form-group qinfo">
						<label>
							书名：
						</label>
						<input name="name" type="text" class="form-control">
					</div>
					<button type="submit" class="btn btn-default">
						查询
					</button>
				</div>
				<div class="pull-right">
					<button type="button" id="addBtn" class="btn btn-info">新增</button>
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

					<th>图片</th>
					<th>ID</th>
					<th>书名</th>
					<th>年级</th>
					<th>操作</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${pageInfo.list}" var="book">
					<tr>
						<td>
							<img src="<%=path%>/${book.picture}" alt="图片找不到" width="100" height="100" />
						</td>
						<td>${book.id}</td>
						<td>${book.name}</td>
						<td>${book.grade}</td>

						<td>
							<a href="<%=path%>/book/toUpdate?bookId=${book.id}"
							   class="btn btn-info btn-xs"><span
									class="glyphicon glyphicon-edit"></span>编辑</a>
							<a href="javascript:void();"
							   onclick="delInfo('${book.id}');"
							   class="btn btn-danger btn-xs"><span
									class="glyphicon glyphicon-trash"></span>删除</a>
							<a href="<%=path%>/word/adminWords?bookId=${book.id}"
							   class="btn btn-success btn-xs">
								<span class="glyphicon glyphicon-eye-open"></span>查看
							</a>

						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<nav aria-label="Page navigation">
				<ul class="pagination">
					<c:if test="${pageInfo.hasPreviousPage}">
						<li>
							<a href="${pageContext.request.contextPath}/book/list?page=${pageInfo.prePage}&rows=${pageInfo.pageSize}
									&name=${queryParam.name}&grade=${queryParam.grade}" aria-label="Previous">
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
								<a href="${pageContext.request.contextPath}/book/list?page=${nav}&rows=${pageInfo.pageSize}
										&name=${queryParam.name}&grade=${queryParam.grade}">${nav}</a>
							</li>
						</c:if>
					</c:forEach>
					<c:if test="${pageInfo.hasNextPage}">
						<li>
							<a href="${pageContext.request.contextPath}/book/list?page=${pageInfo.nextPage}&rows=${pageInfo.pageSize}
									&name=${queryParam.name}&grade=${queryParam.grade}" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					</c:if>
				</ul>
			</nav>

		</div>
	</c:if>
</div>
</body>
</html>
<script type="text/javascript">
	$(document).ready(function(){
		$("#addBtn").click(function(){
			window.location.href = '<%=path%>/book/toAdd';
		});
	});
	function delInfo(id){
		if(confirm("是否确认删除？")){
			window.location.href = '<%=path%>/book/delete?id=' + id;
		}
	}
	$(document).ready(function(){
		$("#checkWord").click(function(){
			window.location.href = '<%=path%>/word/list';
		});
	});
</script>