<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<%=path%>/resources/wyc/css/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path%>/resources/wyc/js/jquery-3.4.1.min.js"></script>
<script src="<%=path%>/resources/wyc/css/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>/resources/wyc/js/jquery-pdm.js"></script>
<script type="text/javascript" src="<%=path%>/resources/wyc/js/layer/layer.js"></script>
<link href="<%=path%>/resources/wyc/css/style.min.css" rel="stylesheet">
<link href="<%=path%>/resources/wyc/css/login.min.css" rel="stylesheet">
 
    
<title>英语学习平台</title>
</head>
<body class="signin">
    <div class="signinpanel">
        <div class="row">
            <div class="col-sm-7">
                <div class="signin-info">
                    <div class="logopanel m-b">
                        <h1>英语学习平台</h1>
                    </div>
                    <div class="m-b"></div>
                     <h4> </h4>
                    
                  
                    
                </div>
            </div>
            <div class="col-sm-5">
                <form action="#" method="post" >
                    <h4 class="no-margins"> </h4>
                    <p class="m-t-md">登录</p>
                    <div id="alert-error" class="alert alert-danger" style="padding:6px; display:none;">
                                                      用户名或密码错误
                    </div>
                    <input type="text" class="form-control username" placeholder="用户名" id="username" name="username"  >
                    <input type="password" class="form-control pword m-b" placeholder="密码" id="password" name="password"  >
			        <select class="form-control pword m-b" id="utype">
			           <option value="1">用户</option>
			           <option value="0">管理员</option>
			        </select>
                    <button class="btn btn-success btn-block" type="button" onclick="return login();" id="btnSubmit">登录</button>
                    <p class="text-muted text-center" style="margin: 10px 0;"> 
	               		<a href="<%=path%>/login/register" target="_self" style="color: #d2c9c9;">用户注册</a>
	               	</p>
                </form>
            </div>
        </div>
    </div>



   


</body>
<script type="text/javascript">
      function login(){
    	  var username = $('#username').val();
    	  var password = $('#password').val();
    	  var utype = $('#utype').val();
    	  if(!username){
    		  $('#alert-error').text("用户名不能为空");
    		  $('#alert-error').show();
    		  return false;
    	  }
    	  if(!password){
    		  $('#alert-error').text("密码不能为空");
    		  $('#alert-error').show();
    		  return false;
    	  }
    	  
    	  $.post(
    	      "<%=path%>/login/login.do",
              { username:username,password:password,utype:utype},
   			   function(data){
    		       
    		        datas = $.trim(data);
    		       
   			        if(datas=="false"){
   			            $('#alert-error').text("用户名密码错误");
   	    		        $('#alert-error').show();
   	    		        return false;
   			        }else{
   			            window.location.href = '<%=path%>/login/loginSuccess';
   			        	
   			        }
    		      
   		   });
    	  
      }
      
      function register(){
           layer.open({
		      type: 2,
		      title: '注册',
		      maxmin: false,
		      shadeClose: true, //点击遮罩关闭层
		      area : ['600px' , '550px'],
		      content: '<%=path%>/login/register'
		    });
      
      }
    
</script>
</html>
