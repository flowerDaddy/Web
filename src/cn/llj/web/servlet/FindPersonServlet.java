package cn.llj.web.servlet;

import cn.llj.domain.Person;
import cn.llj.service.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findPersonServlet")
public class FindPersonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置字符集编码
        req.setCharacterEncoding("UTF-8");
        //2.获取id
        String id = req.getParameter("id");
        //3.调用service 中 findById()方法查询对象信息，
        PersonServiceImpl service = new PersonServiceImpl();
        Person person = service.findById(id);
        //4.将person对象存入request域
        req.setAttribute("person",person);
        //5.转发至update.jsp页面
        req.getRequestDispatcher("/update.jsp").forward(req, resp);

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
