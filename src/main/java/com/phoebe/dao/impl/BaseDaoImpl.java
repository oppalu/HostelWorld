package com.phoebe.dao.impl;

import com.phoebe.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by phoebegl on 2017/2/25.
 */
@Repository
public class BaseDaoImpl implements BaseDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Session getNewSession() {
        return sessionFactory.openSession();
    }

    public int save(Object o) {
        try {
            Session session = getNewSession();
            Transaction tx=session.beginTransaction();
            session.save(o);
            tx.commit();
            session.close();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(Object o) {
        try {
            Session session = getNewSession();
            Transaction tx=session.beginTransaction();
            session.delete(o);
            tx.commit();
            session.close();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(Class<?> c, String id) {
        try {
            Session session = getNewSession();
            Transaction tx=session.beginTransaction();
            Object obj = session.get(c, id);
            session.delete(obj);
            tx.commit();
            session.close();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(Object o) {
        try {
            Session session = getNewSession();
            Transaction tx=session.beginTransaction();
            session.update(o);
            tx.commit();
            session.close();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Object find(Class<?> c, String id) {
        Session session = getSession();
        return session.get(c, id);
    }

    public List findAll(Class<?> c) {
        String hql = "from " + c.getName();
        Session session = getSession();
        return session.createQuery(hql).list();
    }

    public int getTotalCount(Class<?> c) {
        Session session = getNewSession();
        String hql = "select count(*) from " + c.getName();
        int count = (Integer) session.createQuery(hql).uniqueResult();
        session.close();
        return count;

    }
}
