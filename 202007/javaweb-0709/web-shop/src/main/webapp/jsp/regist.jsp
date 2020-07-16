
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form id="userForm" name="userForm" action="${pageContext.request.contextPath }/jsp/regist.do">
        <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
        <input type="hidden" value="add">
        <div>
            <label for="userName">用户名称：</label>
            <input type="text" name="userName" id="userName" value="">
            <font color="red"></font>
        </div>
        <div>
            <label for="userPassword">用户密码：</label>
            <input type="password" name="userPassword" id="userPassword" value="">
            <font color="red"></font>
        </div>
        <div>
            <label for="ruserPassword">确认密码：</label>
            <input type="password" name="ruserPassword" id="ruserPassword" value="">
            <font color="red"></font>
        </div>
        <div>
            <label for="userEmail">邮箱：</label>
            <input type="text" name="userEmail" id="userEmail" value="">
            <font color="red"></font>
        </div>

        <div>
            <input type="button" id="add" name = "add" value="注册"/>
            <input type="button" id="back" name="back" value="返回" >
            <input type="reset" value="重置"/>
        </div>
    </form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"  charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js"  charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/regist.js"  charset="utf-8"></script>
</body>
</html>
