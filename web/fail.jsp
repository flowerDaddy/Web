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
<h1>${error}</h1>
<div><a href="${pageContext.request.contextPath}/add.jsp">返回添加页面</a></div>

</body>
</html>
