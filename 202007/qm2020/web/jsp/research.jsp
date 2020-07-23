<%@page import="model.SearchStaff"%>
<%@page import="entity.staff"%>
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
<title>查询员工信息结果</title>

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
						<div class="insert">
							<a class="aa" href="./jsp/staffInsert.jsp"> 新增员工 </a>
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
					<h1>员工信息查询结果</h1>
					<%
						int id = Integer.parseInt(request.getParameter("staffid"));
						SearchStaff model1 = new SearchStaff();
						staff staffq = model1.load(id);
						if (staffq == null) {
							out.println("没有查询到数据");
						} else {
							out.println("员工编号：" + staffq.getId() + "<br>");
							out.println("员工名字：" + staffq.getName() + "<br>");
							out.println("员工性别：" + staffq.getSex() + "<br>");
							out.println("员工民族：" + staffq.getNation() + "<br>");
							out.println("员工手机号：" + staffq.getPhone() + "<br>");
							out.println("员工身份证号：" + staffq.getIdcard() + "<br>");
							out.println("员工部门：" + staffq.getDepart() + "<br>");
							out.println("员工职位：" + staffq.getProfe() + "<br>");
							out.println("员工邮箱：" + staffq.getEmail() + "<br>");
							out.println("员工入职日期：" + staffq.getEntry() + "<br>");
							out.println("员工毕业学校：" + staffq.getSchool() + "<br>");
							out.println("员工学历：" + staffq.getEducat() + "<br>");
							out.println("员工出生日期：" + staffq.getBirth() + "<br>");
						}
					%>
					<input class="return return1" type="button" value="修改员工信息"
						onclick="window.location.href = '<%=path%>/servlet/UpdateStaffServlet?id=<%=staffq.getId()%>'">
					<input class="return return2" type="button" value="删除员工信息"
						onclick="javascript:if(confirm('确认删除<%=staffq.getName()%>的所有信息吗?'))window.location='<%=path%>/servlet/DeleteStaffServlet?id=<%=staffq.getId()%>'">
					<input type="button" class="return return3" value="返回上一层"
						onclick="window.location.href = '<%=path%>/servlet/ListStaff'">
				</div>
			</div>
		</div>
</body>
</html>
