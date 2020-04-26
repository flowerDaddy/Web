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

@WebServlet("/AddPersonServlet")
public class AddPersonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置字符集编码
        req.setCharacterEncoding("UTF-8");
        //2.获取数据
        Map<String, String[]> map = req.getParameterMap();
        //3.封装Person对象
        Person person = new Person();

        try {
            BeanUtils.populate(person,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4.调用service add方法保存数据到数据库
        PersonServiceImpl service = new PersonServiceImpl();
        int i = service.add(person);
        if (i!=-1){
            //创建对象成功，重定向至list页面
            resp.sendRedirect(req.getContextPath()+"/findPersonPageServlet");
        }else{
            //创建对象失败，存入对象，转发至失败页面
            req.setAttribute("error", "添加失败，服务器正忙，请稍后重试");
            req.getRequestDispatcher("/fail.jsp").forward(req, resp);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
