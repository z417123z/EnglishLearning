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
	<c:if test="${page!=null}">
	<div class="table-responsive">
		<table class="table table-striped table-hover"
			   style="text-align: center;">
			<thead>
			<tr>
				<th>单词</th>
				<th>释义</th>
				<th>操作</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${pageInfo.list}" var="word">
				<tr>
					<td>${word.name}</td>
					<td>
						<div class="pull-left">
							<button type="button" class="btn btn-default checkTrans" data-container="body" data-toggle="popover"
									data-placement="right" data-content="${word.translation}">
								点击查看
							</button>
						</div>

					</td>
					<td>
						<a href="<%=path%>/memory/delete?wordId=${word.id}"
						   class="btn btn-info btn-xs"><span
								class="glyphicon glyphicon-trash"></span>从单词表内删除</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>

		<nav aria-label="Page navigation">
			<ul class="pagination">
				<c:if test="${pageInfo.hasPreviousPage}">
					<li>
						<a href="${pageContext.request.contextPath}/memory/test?page=${pageInfo.prePage}&rows=${pageInfo.pageSize}
									&name=${queryParam.name}&translation=${queryParam.translation}&bookId=${bookId}" aria-label="Previous">
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
							<a href="${pageContext.request.contextPath}/memory/test?page=${nav}&rows=${pageInfo.pageSize}
										&name=${queryParam.name}&translation=${queryParam.translation}&bookId=${bookId}">${nav}</a>
						</li>
					</c:if>
				</c:forEach>
				<c:if test="${pageInfo.hasNextPage}">
					<li>
						<a href="${pageContext.request.contextPath}/memory/test?page=${pageInfo.nextPage}&rows=${pageInfo.pageSize}
									&name=${queryParam.name}&translation=${queryParam.translation}&bookId=${bookId}" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</c:if>
			</ul>
		</nav>
		</c:if>
		<div class="pull-right">
			<button type="button" id="rebackBtn" class="btn btn-default" style="margin-top: 40px; margin-left: 20px;">
				返回</button>
		</div>
	</div>
</body>
<script type="text/javascript">

	$('.checkTrans').popover()
</script>
</html>