<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/upload.do" enctype="multipart/form-data" method="post">
    上传用户：<input type="text" name="username"><br/>
    <p><input type="file" name="file1"></p>
    <p><input type="file" name="file1"></p>

    <p><input type="submit"> | <input type="reset"></p>
</form>



<form action="${pageContext.request.contextPath}/RegisterServlet.do" method="post">
    用户名：<input type="text" name = "username"><br/>
    密码： <input type="password" name="password"><br/>
    邮箱： <input type="text" name="email"><br/>
    <input type="submit" value="注册">
</form>
</body>
</html>
