<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>当前有 <span style="color: #6073ff"><%=this.getServletConfig().getServletContext().getAttribute("OnLineCount")%></span>人在线</h1>
</body>
</html>
