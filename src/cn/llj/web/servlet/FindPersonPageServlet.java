package cn.llj.web.servlet;

import cn.llj.domain.PageBean;
import cn.llj.service.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findPersonPageServlet")
public class FindPersonPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置字符集编码
        req.setCharacterEncoding("UTF-8");
        //2.接收请求参数
        String currentPage = req.getParameter("currentPage");
        String rows = req.getParameter("rows");
        if (currentPage==null||"".equals(currentPage)){
                currentPage="1";
        }
        if (rows==null||"".equals(rows)){
            rows="5";
        }
        Map<String, String[]> condition = req.getParameterMap();
        //3.调用Service 查询PageBean
        PersonServiceImpl service = new PersonServiceImpl();
        PageBean pg=service.findPersonByPage(currentPage,rows,condition);
        //4.讲PageBean对象存入request
        req.setAttribute("pb", pg);
        req.setAttribute("condition", condition);
        System.out.println(pg);
        //5.转发personList.jsp
        req.getRequestDispatcher("/personList.jsp").forward(req, resp);
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
