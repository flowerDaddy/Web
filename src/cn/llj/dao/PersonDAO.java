package cn.llj.dao;

import cn.llj.domain.Person;

import java.util.List;
import java.util.Map;

public abstract class PersonDAO implements BaseDAO <Person>{
    @Override
    public abstract List<Person> findAll();

    @Override
    public abstract Person select(Person p);

    @Override
    public abstract  int add(Person p);

    @Override
    public abstract void del(int id);

    @Override
    public abstract Person findById(int id);

    @Override
    public abstract void upById(Person p);

    @Override
    public abstract int findTotalCount(Map<String, String[]> condition);

    @Override
    public  abstract List<Person> findByPage(int start, int rows, Map<String, String[]> condition);

}
