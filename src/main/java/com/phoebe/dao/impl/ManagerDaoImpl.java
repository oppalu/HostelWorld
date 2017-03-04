package com.phoebe.dao.impl;

import com.phoebe.dao.BaseDao;
import com.phoebe.dao.ManagerDao;
import com.phoebe.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by phoebegl on 2017/3/4.
 */
@Repository
public class ManagerDaoImpl implements ManagerDao{

    @Autowired
    private BaseDao baseDao;

    public Manager findManager(String userid) {
        return (Manager)baseDao.find(Manager.class,userid);
    }
}
