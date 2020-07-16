<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎</title>
</head>
<body>
    <form >
        <b style="color: #9a4854">学号：</b><input type="text" id="id"><br><br>
        <b style="color: #9a4854">姓名：</b><input type="text" name="username"><br><br>
        <b style="color: #9a4854">请选择你的出生日期</b><br>
        <input type="date" name="date"><br><br>
        <b style="color: #9a4854">请选择你最喜欢的颜色: </b><input type="color" name="favcolor"><br>
    </form>
    <br>

    <b style="color: #9a4854">请选择你喜欢吃的水果</b><br>
    <form method=post action="http://test.com/cgi-bin/choice">
        <select name="水果">
            <option value="苹果">苹果</option>
            <option value="梨子" selected>梨子</option>
            <option value="香蕉">香蕉</option>
        </select>
    </form>
    <br>

    <b style="color: #9a4854">请选择您学习的方式</b><br>
    <form action="${pageContext.request.contextPath }/hello.do"  method="post">
        <input type="radio" checked><b style="color: #9a4854">天天学</b>
        <input type="radio"><b style="color: #9a4854">偶尔学</b>
        <input type="radio"><b style="color: #9a4854">从不学</b><br><br>
        <b style="color: #9a4854">请选择您所要学习的课程</b><br>
        <input type="checkbox" value="yes" name="局域网络工程" checked><b style="color: #9a4854">局域网络工程</b><br>
        <input type="checkbox" value="yes" name="数据结构"><b style="color: #9a4854">数据结构</b><br>
        <input type="checkbox" value="yes" name="操作系统"><b style="color: #9a4854">操作系统</b><br><br>
        <b style="color: #9a4854">请输入你的爱好特长等其他信息</b><br>
        <textarea name="comment" rows="4" cols="50"></textarea><br>
        <input type="submit" name="ok" value="提交">
        <input type="reset" name="re-input" value="重选">
    </form>
    <br>

    <p align="right"><b style="color: #9a4854">19170333 樊世雄</b></p>

</body>
</html>
