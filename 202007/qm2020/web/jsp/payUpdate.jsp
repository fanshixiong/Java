<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>更新员工工资</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/reset.css" type="text/css"
	charset="utf-8"></link>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/base.css" type="text/css"
	charset="utf-8"></link>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/fa/css/all.css"
	type="text/css" charset="utf-8"></link>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/insert.css"
	type="text/css" charset="utf-8"></link>

</head>

<body>
		<div class="outer">
			<div class="nav_wrap">
				<div class="nav_inner">
					<div class="nav_left">
						<img src="${pageContext.request.contextPath}/img/2.png"><span>酒店人力资源管理系统</span>
					</div>
					<div class="nav_right">

						<div class="exit">
							<a class="aa"
								href="javascript:if(confirm('确认退出登录吗?'))window.location='index.jsp'">退出系统</a>
						</div>

					</div>

				</div>
			</div>
			<div class="down_wrap">
				<div class="down_inner">
					<h1>更新员工工资信息</h1>
					<form method="post"
						action="<%=request.getContextPath()%>/servlet/DoUpdatePayServlet">
						<div class="inner_list">
							<span>编号：</span><input type="number" name="id" value="${pay.id}"
								class="inner_inp"
								οnkeyup="if(/\D/.test(this.value)){alert('只能输入数字');this.value='';}">
						</div>
						<div class="inner_list">
							<span>请假天数：</span><input type="number" name="leave"
								value="${pay.leave }" class="inner_inp"
								οnkeyup="if(/\D/.test(this.value)){alert('只能输入数字');this.value='';}">
						</div>
						<div class="inner_list">
							<span>迟到次数：</span><input type="number" name="belate"
								value="${pay.belate}" class="inner_inp"
								οnkeyup="if(/\D/.test(this.value)){alert('只能输入数字');this.value='';}">
						</div>
						<div class="inner_list">
							<span>旷工天数：</span><input type="number" name="absent"
								value="${pay.absent}" class="inner_inp"
								οnkeyup="if(/\D/.test(this.value)){alert('只能输入数字');this.value='';}">
						</div>
						<div class="inner_list">
							<span>基本工资：</span><input type="number" name="basepay"
								value="${pay.basepay}" class="inner_inp"
								οnkeyup="if(/\D/.test(this.value)){alert('只能输入数字');this.value='';}">
						</div>
						<div class="inner_list">
							<span>奖金：</span><input type="number" name="bonus"
								value="${pay.bonus}" class="inner_inp"
								οnkeyup="if(/\D/.test(this.value)){alert('只能输入数字');this.value='';}">
						</div>
						<div class="inner_list">
							<span>应扣工资：</span><input type="number" name="depay"
								value="${pay.depay }" class="inner_inp"
								οnkeyup="if(/\D/.test(this.value)){alert('只能输入数字');this.value='';}">
						</div>
						<div class="inner_list">
							<span>实际工资：</span><input type="number" name="rpay"
								value="${pay.rpay }" class="inner_inp"
								οnkeyup="if(/\D/.test(this.value)){alert('只能输入数字');this.value='';}">
						</div>
						<input class="inner_btn btn1" type="submit" value="保存更新">
						<input class="inner_btn btn2" type="button" value="取消更新"
							onclick="window.location.href = '<%=path%>/servlet/ListPay'">
						<input class="inner_btn btn3" type="button" value="修改员工信息"
							onclick="window.location.href = '<%=path %>/servlet/UpdateStaffServlet?id=${pay.id}'">
					</form>
				</div>
			</div>
		</div>
</body>
</html>
