<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<%=path%>/resources/wyc/css/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/resources/wyc/css/left.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path%>/resources/wyc/js/jquery-3.4.1.min.js"></script>
<script src="<%=path%>/resources/wyc/css/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>/resources/wyc/js/jquery-pdm.js"></script>
<title>英语学习平台</title>
</head>
<body>
	<div id="topDiv"></div>
	<div id="contentDiv" style="margin-top: 90px;"></div>
</body>

<script type="text/javascript">
      $(function(){
        $("#topDiv").load("<%=path%>/login/top");
        $("#contentDiv").load("<%=path%>/login/left");
    });

</script>

</html>