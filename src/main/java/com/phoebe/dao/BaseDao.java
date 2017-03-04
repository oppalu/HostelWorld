package com.phoebe.dao;

import org.hibernate.Session;

import java.util.List;

/**
 * 封装数据层操作基本方法
 * Created by phoebegl on 2017/2/25.
 */
public interface BaseDao {

    public Session getSession();

    public Session getNewSession();

    public int save(Object o);

    public int delete(Object o);

    public int delete(Class<?> c, String id);

    public int update(Object o);

    public Object find(Class<?> c, String id);

    public List findAll(Class<?> c);

    public int getTotalCount(Class<?> c);

    public String getNum(String type);
}
