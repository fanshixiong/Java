<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
success!
<%
 /*   Object user_session = request.getSession().getAttribute("USER_SESSION");
    if(user_session == null){
        response.sendRedirect("login.jsp");
    }*/
%>
<p><a href="/servlet/logout">注销</a> </p>
</body>
</html>
