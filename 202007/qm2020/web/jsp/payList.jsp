<%@ page language="java" import="java.util.*,entity.staff"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>工资表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/fa/css/all.css"
	type="text/css" charset="utf-8"></link>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/reset.css" type="text/css"
	charset="utf-8"></link>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/base.css" type="text/css"
	charset="utf-8"></link>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/first.css" type="text/css"
	charset="utf-8"></link>

</head>
<body>
		<div class="outer">
			<div class="nav_wrap">
				<div class="nav_inner">
					<div class="nav_left">
						<img src="${pageContext.request.contextPath}/img/2.png"></img> <span>酒店人力资源管理系统</span>
					</div>
					<div class="nav_right">
						<div class="search">
							<form action="./jsp/sh.jsp" method="post">
								<input type="number" placeholder="请输入您要搜索的员工编号" name="payid"
									οnkeyup="if(/\D/.test(this.value)){alert('只能输入数字');this.value='';}">
								<button type="submit">
									<i class="fas fa-search"></i>
								</button>
							</form>
						</div>
						<div class="exit">
							<a class="aa"
								href="javascript:if(confirm('确认退出登录吗?'))window.location='index.jsp'">
								退出系统 </a>
						</div>
						<div class="pay">
							<a class="aa" href="<%=path%>/servlet/ListStaff"> 员工信息表 </a>
						</div>
					</div>
				</div>
			</div>
			<div class="down_wrap">
				<table class="table">
					<tr>
						<th>编号</th>
						<th>请假天数</th>
						<th>迟到次数</th>
						<th>旷工天数</th>
						<th>基本工资</th>
						<th>奖金</th>
						<th>应扣工资</th>
						<th>实际工资</th>
						<th>修改信息</th>
					</tr>
					<c:forEach items="${p }" var="p">
						<tr>
							<td>${p.id}</td>
							<td>${p.leave }</td>
							<td>${p.belate }</td>
							<td>${p.absent }</td>
							<td>${p.basepay}</td>
							<td>${p.bonus }</td>
							<td>${p.depay }</td>
							<td>${p.rpay}</td>
							<td><a href="<%=path %>/servlet/UpdatePayServlet?id=${p.id}">修改</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

</body>
</html>
