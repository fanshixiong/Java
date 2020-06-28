<%--
  Created by IntelliJ IDEA.
  User: 樊世雄
  Date: 2020/6/13
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--@include会将两个页面合二为一--%>
    <%@include file="common/header.jsp"%>
    <h1>boder</h1>
    <%@include file="common/footer.jsp"%>

    <hr>

    <%--jsp标签--%>
    <%--jSP标签
    jsp:include：拼接页面，本质还是三个
    --%>
    <jsp:include page="common/header.jsp"/>
    <h1>zhuti</h1>
    <jsp:include page="common/footer.jsp"/>

</body>
</html>
