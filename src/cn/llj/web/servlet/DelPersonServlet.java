package cn.llj.web.servlet;

import cn.llj.service.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delPersonServlet")
public class DelPersonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置字符集参数
        req.setCharacterEncoding("UTF-8");
        //2.获取参数
        String id = req.getParameter("id");
        //3.调用service del方法删除数据
        PersonServiceImpl service = new PersonServiceImpl();
        service.del(Integer.parseInt(id));
        //4.重定向至PersonListServlet
        resp.sendRedirect(req.getContextPath()+"/personListServlet");
}

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
