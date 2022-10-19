<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<head>
  <base href="<%=basePath %>">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/login/loginInput">
  <p>用户名：<input type="text" name="username"></p>
  <p>密码：<input type="password" name="password"></p>
  <p><input type="submit" value="注册"></p>

</form>




<form method="post" action="<%=path%>/file/uploadMultipartFile" enctype="multipart/form-data">
  <input type="file" name="file" value="请选择上传的文件"/>
  <input type="submit" value="提交"/>
</form>


</body>
<script>
  window.onload=function () {
    setTimeout(()=>{
      window.location.href='<%=request.getContextPath() %>/login/loginInput'
    },500)
  };
</script>
</html>
