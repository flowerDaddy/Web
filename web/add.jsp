<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%--1.导入CSS全局样式--%>
<link href="css/bootstrap.min.css" rel="stylesheet">
<%--2.导入jquery--%>
<script src="js/jquery-2.1.0.min.js"></script>
<%--3.导入bootstrap的js文件--%>
<script src="js/bootstrap.js"></script>
<body>
<div class="container">
    <center><h3>添加人物页面</h3></center>
    <form action="${pageContext.request.contextPath}/AddPersonServlet" method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
        </div>

<%--        <div class="form-group">--%>
<%--            <label>性别：</label>--%>
<%--            <input type="radio" name="sex" value="男" checked="checked"/>男--%>
<%--            <input type="radio" name="sex" value="女"/>女--%>
<%--        </div>--%>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
        </div>

        <div class="form-group">
            <label for="age">心法：</label>
            <input type="text" class="form-control" id="skill" name="skill" placeholder="请输入心法名">
        </div>

        <div class="form-group">
            <label for="school">门派：</label>
            <input type="text" class="form-control" id="school" name="school" placeholder="请输入门派"/>
        </div>

        <div class="form-group">
            <label for="post">称号：</label>
            <input type="text" class="form-control" id="post" name="post" placeholder="请输入称号"/>
        </div>
        <div class="form-group">
            <label for="password">密码：</label>
            <input type="text" class="form-control" id="password" name="password" placeholder="请输入密码"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回" />
        </div>
    </form>
</div>

</body>
</html>
