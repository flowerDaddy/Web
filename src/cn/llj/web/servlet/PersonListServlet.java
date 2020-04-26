package cn.llj.web.servlet;

import cn.llj.domain.Person;
import cn.llj.service.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/personListServlet")
public class PersonListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.调用service的findAll方法获取到person的集合
        PersonServiceImpl service = new PersonServiceImpl();
        List<Person>person = service.findAll();
        //2.将List集合存入requset域，
        req.setAttribute("person", person);
        //3.转发至personList页面
        req.getRequestDispatcher("/personList.jsp").forward(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
