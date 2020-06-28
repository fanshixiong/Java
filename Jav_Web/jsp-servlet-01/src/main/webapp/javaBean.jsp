<%@ page import="com.frans.pojo.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    /*Person person = new Person();
    person.setAge(18);
    person.setId(4);
    person.setName("frans");
    person.setSex("nan");*/
%>
<jsp:useBean id="person" class="com.frans.pojo.Person" scope="page"/>
<jsp:setProperty name="person" property="id" value="1"/>
<jsp:setProperty name="person" property="text" value="sadf"/>
<jsp:setProperty name="person" property="name" value="frans"/>
<jsp:setProperty name="person" property="age" value="18"/>


id:<jsp:getProperty name="person" property="id"/>
姓名：<jsp:getProperty name="person" property="name"/>
年龄：<jsp:getProperty name="person" property="age"/>
性别：<jsp:getProperty name="person" property="sex"/>
</body>
</html>
