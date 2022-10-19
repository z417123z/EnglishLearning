<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<%=path%>/resources/wyc/css/top.css" rel="stylesheet" type="text/css">
    <title>菜单栏</title>
</head>
<body>

<header id="header">
    <div id="menu">
        <div id="logo">
            <div>

            </div>
            <div id="system_title">
                英语单词学习平台

            </div>
        </div>
        <div id="rinfo">
            当前用户：
            <span>
                 
                 <c:if test="${sessionScope.utype==0}">${user.name}【管理员】</c:if>


                 <c:if test="${sessionScope.utype==1}">${user.name}【用户】

                     <button type="button" id="addToMyWord" class="btn btn-warning"
                             onclick="signIn('${sessionScope.userId}');">
							<span class="glyphicon glyphicon-pencil"></span>
							每日签到
                     </button>

                 </c:if>
             </span>


            <span id="exit">
				<a href="#" onclick="exit();">退出</a>
			</span>
        </div>
    </div>
</header>
<script type="text/javascript">
    function exit(){
        window.top.location.href = '<%=path%>/login/logout';
    }

    function signIn(id){
        $.ajax({
            url:'<%=path%>/user/signIn',
            type:'GET',//GET 或POST
            async:true,//false是否异步
            data:{id:id},
            dataType:'json',//返回的数据格式类型json/xml/html/script/jsonp/text
            // （返回的值很关键，如果不是text类型，页面可能会被重写）
            success:function(data){
                alert("签到成功！");
            },
            error:function(data){
                alert("今天已成功签到！！");
            }
        });
    }
</script>
</body>
</html>