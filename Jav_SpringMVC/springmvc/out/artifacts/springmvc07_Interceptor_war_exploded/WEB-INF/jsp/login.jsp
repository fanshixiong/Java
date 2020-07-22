<%--
  Created by IntelliJ IDEA.
  User: 樊世雄
  Date: 2020/7/22
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>登录</h1>

<form action="${pageContext.request.contextPath}/user/login" method="post">
    用户名 ： <input type="text" name="username">
    密码 ： <input type="text" name="pwd">
    <input type="submit" value="提交">
</form>
</body>
</html>
