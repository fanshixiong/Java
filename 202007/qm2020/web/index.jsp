<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  <link rel="stylesheet" href="css/base.css" type="text/css"></link>
  <link rel="stylesheet" href="css/index.css" type="text/css"></link>
  <link rel="stylesheet" href="css/reset.css" type="text/css"></link></head>
  
<body>
    <div class="outer clearfix">
        <div class="inner_wrapper clearfix">
            <p>酒店人力资源管理系统</p>
            <form action="./servlet/Login" method="post">
                <div class="inner_first">
                    <input type="text" name="username" id="username" placeholder="管理员姓名" autocomplete="off"><br>
                </div>
                <div class="inner_sec">
                    <input type="password" name="password" id="password" placeholder="管理员密码"><br>
                </div>
                <div class="inner_third">
                    <input type="submit" value="登 录" id="sign" />
                </div>
            </form>
        </div>
    </div>
</body>
</html>
