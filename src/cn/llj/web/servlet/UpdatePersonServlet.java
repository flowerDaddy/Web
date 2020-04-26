package cn.llj.web.servlet;

import cn.llj.domain.Person;
import cn.llj.service.PersonServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updatePersonServlet")
public class UpdatePersonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置字符集编码
        req.setCharacterEncoding("UTF-8");
        //2.获取数据
        Map<String, String[]> map = req.getParameterMap();
        //3.封装对象
        Person person = new Person();
        try {
            BeanUtils.populate(person, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4.调用UpById()方法更新数据
        PersonServiceImpl service = new PersonServiceImpl();
            service.upById(person);
        //5.重定向跳转到PersonListServlet
        resp.sendRedirect(req.getContextPath()+"/personListServlet");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
