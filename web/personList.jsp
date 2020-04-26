<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>personList</title>
</head>
<%--1.导入CSS全局样式--%>
<link href="css/bootstrap.min.css" rel="stylesheet">
<%--2.导入jquery--%>
<script src="js/jquery-2.1.0.min.js"></script>
<%--3.导入bootstrap的js文件--%>
<script src="js/bootstrap.js"></script>
<script>
    function deletePerson(id) {
        if (confirm("您确认删除吗？")) {
            location = "${pageContext.request.contextPath}/delPersonServlet?id=" + id;
        }

    }

    window.onload = function () {
        //给删除选中按钮添加单击事件
        document.getElementById("delSelect").onclick = function () {
            if (confirm("您确定要删除选中条目吗？")) {
                //表单提交
                document.getElementById("form").submit();
            }
        }
        //1.获取第一个cb
        document.getElementById("firstCb").onclick = function () {
            //2.获取下面所有的cb
            var cbs = document.getElementsByName("uid");
            //3.遍历

            for (var i = 0; i < cbs.length; i++) {
                //设置这些cbs[i]的状态
                cbs[i].checked = this.checked;
            }
        }

    }


</script>
<body>
<div class="container">
    <h1 style="text-align: center">侠客信息列表</h1>

    <div style="float: left">
        <form class="form-inline" action="${pageContext.request.contextPath}/findPersonPageServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName">姓名</label>
                <input type="text" class="form-control" id="exampleInputName" name="name" value="${condition.name[0]}">
            </div>
            <div class="form-group">
                <label for="exampleInputSchool">门派</label>
                <input type="text" class="form-control" id="exampleInputSchool" name="school" value="${condition.school[0]}">
            </div>
            <button type="submit" class="btn btn-primary my-1">提交</button>
        </form>
    </div>

    <div style="float: right;margin: 5px;">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加侠客信息</a>
        <a class="btn btn-primary btn-danger" href="javascript:void(0);" id="delSelect">删除选中信息</a>
    </div>
    <form action="${pageContext.request.contextPath}/deleteSelectServlet" method="post" id="form">
        <table border="1" class="table table-bordered table-hover table-primary ">
            <tr class="table-success">
                <th><input type="checkbox" id="firstCb"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>心法</th>
                <th>门派</th>
                <th>称号</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${pb.list}" var="Person" varStatus="s">
                <tr>
                    <td><input type="checkbox" id="uid" name="uid" value="${Person.id}"></td>
                    <td>${s.count}</td>
                    <td>${Person.name}</td>
                    <td>${Person.age}</td>
                    <td>${Person.skill}</td>
                    <td>${Person.school}</td>
                    <td>${Person.post}</td>
                    <td><a class="btn btn-default btn-sm btn-success"
                           href="${pageContext.request.contextPath}/findPersonServlet?id=${Person.id}">修改</a>
                        <a class="btn btn-default btn-sm btn-danger"
                           href="javascript:deletePerson(${Person.id});">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
    <div>

        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-end">
                <c:if test="${pb.currentPage==1}">
                <li class="page-item disabled">
                    </c:if>
                    <c:if test="${pb.currentPage!=1}">
                <li class="page-item ">
                    </c:if>
                    <a class="page-link"
                       href="${pageContext.request.contextPath}/findPersonPageServlet?currentPage=${pb.currentPage-1}&name=${condition.name[0]}&school=${condition.school[0]}"
                       tabindex="-1" aria-disabled="true">上一页</a></li>
                <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <c:if test="${pb.currentPage==i}">
                        <li class="page-item active" aria-current="page"><a class="page-link " href="${pageContext.request.contextPath}/findPersonPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&school=${condition.school[0]}">${i}</a>
                        </li>
                    </c:if>
                    <c:if test="${pb.currentPage!=i}">
                        <li><a class="page-link "
                               href="${pageContext.request.contextPath}/findPersonPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&school=${condition.school[0]}">${i}</a>
                        </li>
                    </c:if>
                </c:forEach>
                    <c:if test="${pb.currentPage==pb.totalPage}">
                    <li class="page-item disabled">
                        </c:if>
                        <c:if test="${pb.currentPage!=pb.totalPage}">
                    <li class="page-item ">
                        </c:if>
                        <a class="page-link"
                           href="${pageContext.request.contextPath}/findPersonPageServlet?currentPage=${pb.currentPage+1}&name=${condition.name[0]}&school=${condition.school[0]}"
                           tabindex="-1" aria-disabled="true">下一页</a></li>
                <span style="font-size: 25px;margin-left: 5px;">共${pb.totalCount}条记录，共${pb.totalPage}页</span>
            </ul>
        </nav>
    </div>
</div>


</body>
</html>
