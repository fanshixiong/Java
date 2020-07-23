<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="entity.staff"%>
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

<title>欢迎来到人力资源管理系统</title>

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
							<form action="./jsp/research.jsp" method="post">
								<input type="number" placeholder="请输入您要搜索的员工编号" name="staffid"
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
							<a class="aa" href="<%=path%>/servlet/ListPay"> 员工工资表 </a>
						</div>
						<div class="insert">
							<a class="aa" href="./jsp/staffInsert.jsp"> 新增员工 </a>
						</div>

					</div>
				</div>
			</div>
			<div class="down_wrap">
				<table class="table">
					<tr>
						<th>编号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>民族</th>
						<th>手机号</th>
						<th>身份证号</th>
						<th>部门</th>
						<th>职位</th>
						<th>邮箱</th>
						<th>入职日期</th>
						<th>毕业学校</th>
						<th>学历</th>
						<th>出生日期</th>
						<th>修改信息</th>
						<th>删除员工</th>
					</tr>
					<c:forEach items="${staffs }" var="staffss">
						<tr>
							<td>${staffss.id }</td>
							<td>${staffss.name }</td>
							<td>${staffss.sex }</td>
							<td>${staffss.nation }</td>
							<td>${staffss.phone }</td>
							<td>${staffss.idcard }</td>
							<td>${staffss.depart }</td>
							<td>${staffss.profe}</td>
							<td>${staffss.email }</td>
							<td>${staffss.entry }</td>
							<td>${staffss.school}</td>
							<td>${staffss.educat }</td>
							<td>${staffss.birth }</td>
							<td><a
								href="<%=path %>/servlet/UpdateStaffServlet?id=${staffss.id}">修改</a>
							</td>
							<td><a
								href="javascript:if(confirm('确认删除${staffss.name }的所有信息么吗?'))window.location='<%=path %>/servlet/DeleteStaffServlet?id=${staffss.id}'">删除</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
</body>
</html>
