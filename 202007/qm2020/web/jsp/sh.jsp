<%@page import="entity.pay"%>
<%@page import="model.SearchPay"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>工资查询结果</title>

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
	href="${pageContext.request.contextPath}/css/search.css"
	type="text/css" charset="utf-8"></link>

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
					</div>
				</div>
			</div>
			<div class="down_wrap">
				<div class="down_inner">
					<h1>工资查询结果</h1>
					<%
						int ida = Integer.parseInt(request.getParameter("payid"));
						SearchPay modelq = new SearchPay();
						pay pays = modelq.load(ida);
						if (pays == null) {
							out.println("没有查询到数据");
						} else {
							out.println("编号：" + pays.getId() + "<br>");
							out.println("请假天数：" + pays.getLeave() + "<br>");
							out.println("迟到次数：" + pays.getBelate() + "<br>");
							out.println("旷工天数：" + pays.getAbsent() + "<br>");
							out.println("基本工资：" + pays.getBasepay() + "<br>");
							out.println("奖金：" + pays.getBonus() + "<br>");
							out.println("应扣工资：" + pays.getDepay() + "<br>");
							out.println("实际工资：" + pays.getRpay() + "<br>");
						}
					%>
					<input class="return return1" type="button" value="修改工资"
						onclick="window.location.href = '<%=path%>/servlet/UpdatePayServlet?id=<%=pays.getId()%>'">
					<input type="button" class="return return3" value="返回上一层"
						onclick="window.location.href = '<%=path%>/servlet/ListPay'">
				</div>
			</div>
		</div>
</body>
</html>
