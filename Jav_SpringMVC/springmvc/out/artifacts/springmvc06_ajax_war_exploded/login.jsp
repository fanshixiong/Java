<%--
  Created by IntelliJ IDEA.
  User: 樊世雄
  Date: 2020/7/22
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<%--    <script src="${pageContext.request.contextPath}/statics/js/jquery-1.8.3.min.js"></script>--%>
    <script>
        function a1() {
            $.post({
                url : "${pageContext.request.contextPath}/a3",
                data : {"name" : $("#username").val()},
                success : function (data) {
                    console.log(data.toString());
                    if(data.toString() == "ok"){
                        $("#userinfo").css("color", "green");
                    }else {
                        $("#userinfo").css("color", "red");
                    }
                    $("#userinfo").html(data);
                }
            })
        }
        
        function a2() {
            $.post({
                url : "${pageContext.request.contextPath}/a3",
                data : {"pwd" : $("#pwd").val()},
                success : function (data) {
                    console.log(data.toString());
                    if(data.toString() == "ok"){
                        $("#pwdinfo").css("color", "green");
                    }else {
                        $("#userinfo").css("color", "red");
                    }
                    $("#pwdinfo").html(data);
                }

            })
        }
    </script>
</head>
<body>

<p>
    用户名：<input type="text" id="username" onblur="a1()">
    <span id="userinfo"></span>
</p>
<p>
    密码： <input type="text" id="pwd" onblur="a2()">
    <span id="pwdinfo"></span>
</p>









</body>
</html>
