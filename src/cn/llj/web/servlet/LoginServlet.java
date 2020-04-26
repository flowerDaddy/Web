package cn.llj.web.servlet;

import cn.llj.domain.Person;
import cn.llj.service.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置字符集编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //2.获取数据
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String code = req.getParameter("verifycode");
        HttpSession session = req.getSession();
        String check = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        //3.判断验证码是否正确
        if (code!=null&&check!=null&&code.equalsIgnoreCase(check)){
            //4.封装对象
            Person person = new Person();
            person.setName(name);
            person.setPassword(password);
            System.out.println(person);
            //5.验证码验证成功，调用service查询方法
            PersonServiceImpl service = new PersonServiceImpl();
            Person p = service.select(person);
            // 6.判断是否登录成功
            if (p!=null){
                //登陆成功，存储用户信息
                session.setAttribute("person", p);
                //重定向至首页
                resp.sendRedirect(req.getContextPath()+"/index.jsp");
                return;
            }else{
                //登陆失败，储存错误提示信息
                req.setAttribute("error", "用户名或密码错误");
                //转发至登陆页面
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
                return;
            }

        }else{
            //验证码验证失败，存入错误提示信息
            req.setAttribute("error", "验证码错误，请重试");
            //转发到登陆页面
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }


    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
