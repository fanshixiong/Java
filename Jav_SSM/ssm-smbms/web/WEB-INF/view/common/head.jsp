<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt' %>
<!DOCTYPE html>
<html>
<head lang="en">
    <title>超市订单管理系统</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/static/css/style.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/static/css/public.css" />
</head>
<body>
<!--头部-->
    <header class="publicHeader">
        <h1>超市订单管理系统</h1>
        <div class="publicHeaderR">
            <p><span>下午好！</span><span style="color: #fff21b"> ${userSession.userName}</span> , 欢迎你！</p>
            <a href="${pageContext.request.contextPath }/user/exit.do">退出</a>
        </div>
    </header>
<!--时间-->
    <section class="publicTime">
        <span id="time">2015年1月1日 11:11  星期一</span>
        <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
    </section>
 <!--主体内容-->
 <section class="publicMian ">
     <div class="left">
         <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
         <nav>
             <ul class="list">
              <li><a href="${pageContext.request.contextPath }/bill/management.do">订单管理</a></li>
              <li><a href="${pageContext.request.contextPath }/provider/management.do">供应商管理</a></li>
              <li><a href="${pageContext.request.contextPath }/user/management.do">用户管理</a></li>
              <li><a href="${pageContext.request.contextPath }/user/pwdmodify.do">密码修改</a></li>
              <li><a href="${pageContext.request.contextPath }/user/exit.do">退出系统</a></li>
             </ul>
         </nav>
     </div>
     <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
     <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>"/>
 </section>
</body>
