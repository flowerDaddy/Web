package cn.llj.web.servlet;

import cn.llj.service.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteSelectServlet")
public class DeleteSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置字符集编码
        req.setCharacterEncoding("UTF-8");
        //2.获取数据
        String[] uids = req.getParameterValues("uid");
        //3.调用service 方法
        PersonServiceImpl service = new PersonServiceImpl();
        service.delSelete(uids);
        //4.跳转到PersonListServlet
        resp.sendRedirect(req.getContextPath()+"/personListServlet");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
