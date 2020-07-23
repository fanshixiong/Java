<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>更新员工信息</title>

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
						<img src="${pageContext.request.contextPath}/img/2.png"><span>人力资源管理系统</span>
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
								href="javascript:if(confirm('确认退出登录吗?'))window.location='index.jsp'">退出系统
							</a>
						</div>
						<div class="insert">
							<a class="aa" href="./jsp/staffInsert.jsp"> 新增员工 </a>
						</div>
					</div>
				</div>
			</div>
			<div class="down_wrap">
				<div class="down_inner">
					<h1>更新员工信息</h1>
					<form method="post"
						action="<%=request.getContextPath()%>/servlet/DoUpdateStaffServlet">
						<div class="inner_list">
							<span>编号：</span><input value="${staff.id }" type="number"
								name="id" class="inner_inp"
								οnkeyup="if(/\D/.test(this.value)){alert('只能输入数字');this.value=''; }">
						</div>
						<div class="inner_list">
							<span>姓名：</span><input value="${staff.name }" type="text"
								name="name" class="inner_inp"
								onkeyup="value=value.replace(/[^\u4E00-\u9FA5]/g,'')"
								onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\u4E00-\u9FA5]/g,''))">
						</div>
						<div class="inner_list">
							<span>性别：</span> <select class="inner_inp selet" name="sex"
								id="sex" value="${staff.sex }">
								<option>${staff.sex }</option>
								<option>男</option>
								<option>女</option>
							</select>
						</div>
						<div class="inner_list">
							<span>民族：</span> <select name="nation" class="inner_inp selet"
								id="nation" value="${staff.nation }">
								<option>${staff.nation }</option>
								<option>汉族</option>
								<option>满族</option>
								<option>蒙古族</option>
								<option>回族</option>
								<option>藏族</option>
								<option>维吾尔族</option>
								<option>苗族</option>
								<option>彝族</option>
								<option>朝鲜族</option>
								<option>侗族</option>
								<option>白族</option>
								<option>水族</option>
								<option>其他</option>
							</select>
						</div>
						<div class="inner_list">
							<span>手机号：</span><input value="${staff.phone }" type="number"
								name="phone" class="inner_inp"
								οnkeyup="if(/\D/.test(this.value)){alert('只能输入数字');this.value='';}">
						</div>
						<div class="inner_list">
							<span>身份证号：</span><input value="${staff.idcard}" type="number"
								name="idcard" class="inner_inp"
								οnkeyup="if(/\D/.test(this.value)){alert('只能输入数字');this.value='';}">
						</div>
						<div class="inner_list">
							<span>部 门：</span> <select name="depart" class="inner_inp selet"
								id="depart" value="${staff.depart }">
								<option>${staff.depart }</option>
								<option>前厅部</option>
								<option>客房部</option>
								<option>餐饮部</option>
								<option>娱乐部</option>
								<option>保安部</option>
								<option>销售部</option>
								<option>人事部</option>
								<option>财务部</option>
								<option>行政部</option>
							</select>
						</div>
						<div class="inner_list">
							<span>职 位：</span> <select name="profe" class="inner_inp selet"
								id="profe" value="${staff.profe }">
								<option>${staff.profe }</option>
								<option>普通职员</option>
								<option>主管</option>
							</select>
						</div>
						<div class="inner_list">
							<span>邮 箱：</span><input type="text" name="email"
								class="inner_inp" id="email" value="${staff.email}">
						</div>
						<div class="inner_list">
							<span>入职日期：</span><input value="${staff.entry}" type="text"
								name="entry" class="inner_inp"
								onkeyup="value=value.replace(/[^\d.]/g,'')"
								placeholder="输入格式为2020.01.01">
						</div>
						<div class="inner_list">
							<span>毕业学校：</span><input value="${staff.school}" type="text"
								name="school" class="inner_inp" id="school"
								onkeyup="value=value.replace(/[^\u4E00-\u9FA5]/g,'')"
								onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\u4E00-\u9FA5]/g,''))">
						</div>
						<div class="inner_list">
							<span>学 历：</span> <select name="educat" class="inner_inp selet"
								id="educat" value="${staff.educat}">
								<option>${staff.educat}</option>
								<option>本科</option>
								<option>硕士</option>
								<option>博士</option>
								<option>大专</option>
								<option>高中</option>
								<option>初中</option>
								<option>小学</option>
								<option>博士后</option>
							</select>
						</div>
						<div class="inner_list">
							<span>出生日期：</span><input value="${staff.birth}" type="text"
								name="birth" class="inner_inp"
								onkeyup="value=value.replace(/[^\d.]/g,'')"
								placeholder="输入格式为2020.01.01">
						</div>
						<input class="inner_btn btn1" type="submit" value="保存更新">
						<input class="inner_btn btn2" type="button" value="取消更新"
							onclick="window.location.href = '<%=path%>/servlet/ListStaff'">
						<input class="inner_btn btn3" type="button" value="修改工资"
							onclick="window.location.href = '<%=path %>/servlet/UpdatePayServlet?id=${staff.id}'">
					</form>
				</div>
			</div>
		</div>
</body>
</html>
