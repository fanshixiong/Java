<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login.do" name="actionForm" id="actionForm"
          method="post">
<%--        <div>${error}</div>--%>
        <div>
            <label>用户名：</label>
            <input type="text" id="userName" name="userName" placeholder="请输入用户名" required/>
        </div>
        <div>
            <label>密码：</label>
            <input type="password" id="userPassword" name="userPassword" placeholder="请输入密码" required/>
        </div>
        <div>

            <input type="submit" value="登录"/>
            <input type="reset" value="重置"/>
        </div>
    </form>
    <br/>
    <a href="jsp/regist.jsp">注册</a>
</body>
</html>
