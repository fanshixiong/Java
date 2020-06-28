<%--
  Created by IntelliJ IDEA.
  User: 樊世雄
  Date: 2020/6/7
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
<h1>login</h1>
<div style="text-align: center">
    <%--这里表单表示的意思：以post方式提交表单，提交到login请求--%>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名：<input type="text", name="username"> <br>
        密码：<input type="password" name="password"> <br>
        性别：
        <input type="checkbox", name="gender", value="男"> 男
        <input type="checkbox", name="gender", value="女"> 女
        <br>

        <input type="submit">
    </form>
</div>
</body>
</html>
