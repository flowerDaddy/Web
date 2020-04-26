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
    <center><h3>修改人物信息页面</h3></center>
    <form action="${pageContext.request.contextPath}/updatePersonServlet" method="post">
        <input type="hidden"  id="id" name="id" value="${person.id}" >
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" value="${person.name}">
        </div>

        <%--        <div class="form-group">--%>
        <%--            <label>性别：</label>--%>
        <%--            <input type="radio" name="sex" value="男" checked="checked"/>男--%>
        <%--            <input type="radio" name="sex" value="女"/>女--%>
        <%--        </div>--%>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" value="${person.age}">
        </div>

        <div class="form-group">
            <label for="age">心法：</label>
            <input type="text" class="form-control" id="skill" name="skill" value="${person.skill}" >
        </div>

        <div class="form-group">
            <label for="school">门派：</label>
            <input type="text" class="form-control" id="school" name="school" value="${person.school}"/>
        </div>

        <div class="form-group">
            <label for="post">称号：</label>
            <input type="text" class="form-control" id="post" name="post" value="${person.post}"/>
        </div>
        <div class="form-group">
            <label for="password">密码：</label>
            <input type="text" class="form-control" id="password" name="password" value="${person.password}"/>
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
