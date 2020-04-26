package cn.llj.dao;

import cn.llj.domain.Person;
import cn.llj.utils.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PersonDAOImpl extends PersonDAO {
    //1.获取一个通用的JdbcTemplate jdbc模板
    JdbcTemplate template=new JdbcTemplate(JdbcUtils.getDataSource());
    @Override
    public List findAll() {
       //编写sql语句
        try {
            String sql="select * from person";
            List<Person> personList = template.query(sql, new BeanPropertyRowMapper<Person>(Person.class));
            return personList;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Person select(Person p) {
        //编写sql语句
        try {
            String sql="select * from person where name=? and password=?";
            Person person1 = template.queryForObject(sql, new BeanPropertyRowMapper<Person>(Person.class), p.getName(), p.getPassword());
            return person1;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int  add(Person p) {
        //编写sql语句
        try {
            String sql="insert into `person` (`name`,`age`,`skill`,`school`,`post`,`password`)values(?,?,?,?,?,?)";
            int update = template.update(sql, p.getName(),(byte) p.getAge(), p.getSkill(), p.getSchool(), p.getPost(),p.getPassword());
            return update;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return -1;
        }

    }

    @Override
    public void del(int id) {
        //编写sql语句
        String sql="delete from person where id=?";
        template.update(sql, id);
    }

    @Override
    public Person findById(int id) {
        //1.编写sql语句
        try {
            String sql="select * from person where id=?";
            Person person = template.queryForObject(sql, new BeanPropertyRowMapper<Person>(Person.class), id);
            return person;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void upById(Person p) {
        //1. 编写sql语句
        try {
            String sql="update person set name=?,age=?,skill=?,school=?,post=?,password=? where id=?";
            template.update(sql, p.getName(),p.getAge(),p.getSkill(),p.getSchool(),p.getPost(),p.getPassword(),p.getId());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.编写sql语句模版
        String sql="select count(id) from person where 1=1";
        StringBuffer sb = new StringBuffer(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义一个参数的集合
        List<Object> params = new ArrayList<>();
        for (String key:keySet) {
            //排除分页条件
            if("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
            if (value!=null&&!"".equals(value)){
                sb.append("  and "+key+" like ?");
                params.add("%"+value+"%");
            }
        }
        Integer integer = template.queryForObject(sb.toString(), Integer.class,params.toArray());
        return integer;
    }

    @Override
    public List<Person> findByPage(int start, int rows, Map<String, String[]> condition) {
        //1.编写sql语句
        String sql="select * from person where 1=1";
        StringBuffer sb = new StringBuffer(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义一个参数的集合
        List<Object> params = new ArrayList<>();
        for (String key:keySet) {
            //排除分页条件
            if("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
            if (value!=null&&!"".equals(value)){
                sb.append("  and "+key+" like ?");
                params.add("%"+value+"%");
            }
        }
        sb.append(" limit ?, ?");
        params.add(start);
        params.add(rows);
        List <Person> list = template.query(sb.toString(), new BeanPropertyRowMapper<Person>(Person.class), params.toArray());
        return list;
    }


}
