package cn.llj.service;

import cn.llj.domain.PageBean;
import cn.llj.domain.Person;

import java.util.List;
import java.util.Map;

public abstract class PersonService implements Service<Person> {
    @Override
    public abstract List<Person> findAll();

    @Override
    public abstract Person select(Person p);

    @Override
    public abstract int add(Person p);

    @Override
    public abstract void del(int id);

    @Override
    public abstract Person findById(String id);

    @Override
    public abstract void upById(Person p);

    @Override
    public abstract void delSelete(String[] s);
    @Override
    public abstract PageBean<Person> findPersonByPage(String _currentPage, String _rows, Map<String, String[]> condition);
}
