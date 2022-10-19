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
	<form id="wordForm" class="form-inline" action="<%=path%>/word/userQueryName" method="post">
		<div class="panel panel-default">
			<div class="panel-heading">
				单词列表
			</div>
			<div class="panel-body">
				<div class="pull-left">
					<div class="form-group qinfo">
						<label>
							单词：
						</label>
						<input name="name" class="form-control">
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
				<th>单词</th>
				<th>释义</th>
				<th>操作</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${pageInfo.list}" var="word">
				<tr>
					<td>${word.name}</td>
					<td>${word.translation}</td>
					<td>
						<button type="button" id="addToMyWord" class="btn btn-info btn-xs"
								onclick="addMyWord('${word.id}');">
							<span class="glyphicon glyphicon-edit"></span>
							加入我的单词表
						</button>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>

		<nav aria-label="Page navigation">
			<ul class="pagination">
				<c:if test="${pageInfo.hasPreviousPage}">
					<li>
						<a href="${pageContext.request.contextPath}/word/userQueryName?page=${pageInfo.prePage}
						&rows=${pageInfo.pageSize}&name=${name}" aria-label="Previous">
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
							<a href="${pageContext.request.contextPath}/word/userQueryName?page=${nav}
							&rows=${pageInfo.pageSize}&name=${name}">${nav}</a>
						</li>
					</c:if>
				</c:forEach>
				<c:if test="${pageInfo.hasNextPage}">
					<li>
						<a href="${pageContext.request.contextPath}/word/userQueryName?page=${pageInfo.nextPage}
						&rows=${pageInfo.pageSize}&name=${name}" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</c:if>
			</ul>
		</nav>

		</c:if>

	</div>
</body>
<script type="text/javascript">
	function addMyWord(id){
		$.ajax({
			url:'<%=path%>/memory/add',
			type:'GET',//GET 或POST
			async:true,//false是否异步
			data:{wordId:id},
			dataType:'json',//返回的数据格式类型json/xml/html/script/jsonp/text
			// （返回的值很关键，如果不是text类型，页面可能会被重写）
			success:function(data){
				alert("成功");
			},
			error:function(data){
				alert("失败");
			}
		});
	}
</script>
</html>