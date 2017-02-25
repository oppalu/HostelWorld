package com.phoebe.dao.impl;

import com.phoebe.dao.BaseDao;
import com.phoebe.dao.UserDao;
import com.phoebe.model.User;
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
public class UserDaoImpl implements UserDao {

    @Autowired
    private BaseDao baseDao;

    public int save(User u) {
        return baseDao.save(u);
    }

    public List<User> findAllUsers() {
        return baseDao.findAll(User.class);
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int update(User u) {
        return baseDao.update(u);
    }


}
