<%--
  Created by IntelliJ IDEA.
  User: ������
  Date: 2020/7/22
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
  <span>上传方式1：</span>
  <form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/>
    <input type="submit" value="upload">
  </form>
  <br>
  <span>上传方式2：</span>
  <form action="${pageContext.request.contextPath}/upload2" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/>
    <input type="submit" value="upload2">
  </form>
  <br>
  <span>文件下载：</span>
  <a href="/download">点击下载</a>
  <a  href="${pageContext.request.contextPath}/statics/img/1.jpg" download="">下载图片</a>
</body>
</html>
