<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
      <div align="center">
          <div><h3>欢迎您！${person.name}</h3></div>
        <a href="${pageContext.request.contextPath}/findPersonPageServlet" style="...">
          查询所有用户信息
        </a>
      </div>
  </body>
</html>
