package cn.llj.service;

import cn.llj.domain.PageBean;

import java.util.List;
import java.util.Map;

public interface Service<T>{
    public List<T> findAll();
    public T select(T t);
    public int add(T t);
    public void del(int id);
    public T findById(String id);
    public void upById(T t);
    public void delSelete(String s[]);
    public PageBean<T> findPersonByPage(String _currentPage, String _rows, Map<String, String[]> condition);

}
