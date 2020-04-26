package cn.llj.dao;

import java.util.List;
import java.util.Map;

public interface BaseDAO<T> {
    public List<T> findAll();
    public T select(T t);
    public int add(T t);
    public void del(int id);
    public T findById(int id);
    public void upById(T t);
    public int findTotalCount(Map<String, String[]> condition);

    public List <T> findByPage(int start, int rows, Map<String, String[]> condition);
}
