package cn.llj.service;

import cn.llj.dao.PersonDAOImpl;
import cn.llj.domain.PageBean;
import cn.llj.domain.Person;

import java.util.List;
import java.util.Map;

public class PersonServiceImpl extends PersonService {
    PersonDAOImpl dao = new PersonDAOImpl();

    /**
     * 查找person表中所有数据以list集合返回
     *
     * @return
     */
    @Override
    public List findAll() {
        List<Person> persons = dao.findAll();
        return persons;
    }

    /**
     * 通过用户名*密码查询一个对象返回其所有数据
     *
     * @param p
     * @return
     */
    @Override
    public Person select(Person p) {
        return dao.select(p);
    }

    /**
     * 传入一个对象添加至数据库
     *
     * @param p
     * @return
     */
    @Override
    public int add(Person p) {
        return dao.add(p);
    }

    /**
     * 使用id删除数据
     *
     * @param id
     */
    @Override
    public void del(int id) {
        dao.del(id);
    }

    /**
     * 通过id查询对象
     * @param id
     * @return
     */
    @Override
    public Person findById(String id) {
        Person person = dao.findById(Integer.parseInt(id));
        return person;
    }

    /**
     * 使用id更新对象，
     * @param p
     */
    @Override
    public void upById(Person p) {
        dao.upById(p);
    }

    /**
     * 使用多个id删除多个对象
     * @param s
     */
    @Override
    public void delSelete(String[] s) {
        if (s != null && s.length > 0) {
            for (String str : s) {
                dao.del(Integer.parseInt(str));
            }
        }
    }

    /**
     * 查询对象的信息存入PageBan对象中
     * @param _currentPage
     * @param _rows
     * @param condition
     * @return
     */
    @Override
    public PageBean<Person> findPersonByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        //1.new一个空PageBan对象
        PageBean<Person> pg = new PageBean<Person>();
        if (_currentPage != null && _currentPage.length() > 0 && _rows != null && _rows.length() > 0) {
            //2.设置参数
            int currentPage = Integer.parseInt(_currentPage);
            int rows = Integer.parseInt(_rows);
            pg.setRows(rows);
            //3.调用dao查询总数据数量totalCount
            int totalCount = dao.findTotalCount(condition);
            if (totalCount>0){
                pg.setTotalCount(totalCount);
                //4.计算总页码数
                int totalPage = (totalCount % rows == 0) ? (totalCount / rows) : (totalCount/rows)+1;
                //4.1判断当前页的值，确保不会出现越界问题
                if(currentPage<=0){
                    currentPage=1;
                }
                if (currentPage>totalPage){
                    currentPage=totalPage;
                }
                //4.计算查询开始数，start的数据
                int start = (currentPage - 1) * rows;
                //5.调用dao查询数据，封装为list返回
                List<Person> list = dao.findByPage(start, rows,condition);
                pg.setList(list);
                pg.setTotalPage(totalPage);
                pg.setCurrentPage(currentPage);
            }

        }
        return pg;
    }


}
