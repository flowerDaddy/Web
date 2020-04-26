package cn.llj.dao;

import cn.llj.domain.Person;
import cn.llj.utils.JdbcUtils;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestPersonDAO {
    //1.获取一个通用的JdbcTemplate jdbc模板
    JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    @Test

    public void testFindAll() {
        //1.编写sql语句
        try {
            String sql = "select * from person";
            List<Person> list = template.query(sql, new BeanPropertyRowMapper<Person>(Person.class));
            list.forEach(System.out::println);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelect() {
        Person person = new Person();
        person.setName("李忘生");
        person.setPassword("234567");
        PersonDAOImpl dao = new PersonDAOImpl();
        Person select = dao.select(person);
        System.out.println(select);
    }

    @Test
    public void testAdd() {
        Person person = new Person();
        person.setName("李承恩");
        person.setPassword("345678");
        person.setAge((byte) 28);
        person.setSchool("天策府");
        person.setPost("天策统领");
        person.setSkill("铁牢律");
        PersonDAOImpl dao = new PersonDAOImpl();
        int select = dao.add(person);
        System.out.println(select);
    }

    @Test
    public void testDel() {
        int id = 10;
        PersonDAOImpl dao = new PersonDAOImpl();
        dao.del(id);
    }

    @Test
    public void testFinById() {
        int id = 11;
        PersonDAOImpl dao = new PersonDAOImpl();
        Person person = dao.findById(id);
        System.out.println(person);
    }

    @Test
    public void testUpdate() {
        Person person = new Person();
        person.setId(7);
        person.setName("李承恩啊");
        person.setPassword("3456789");
        person.setAge((byte) 28);
        person.setSchool("天策府");
        person.setPost("天策统领");
        person.setSkill("铁牢律");
        PersonDAOImpl dao = new PersonDAOImpl();
        dao.upById(person);
    }

    @Test
    public void testFindTotalCount() {
        Map<String, String[]> condition=new HashMap<String, String[]>();
        PersonDAOImpl dao = new PersonDAOImpl();
        System.out.println(dao.findTotalCount(condition));
    }
    @Test
    public void testFindByPage() {
        Map<String, String[]> condition=new HashMap<String, String[]>();
        int start =0;
        int rows=5;
        PersonDAOImpl dao = new PersonDAOImpl();
        System.out.println(dao.findByPage(start, rows, (Map<String, String[]>) condition));
    }
}
