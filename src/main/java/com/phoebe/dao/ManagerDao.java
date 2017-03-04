package com.phoebe.dao;

import com.phoebe.model.Manager;

/**
 * Created by phoebegl on 2017/3/4.
 */
public interface ManagerDao {

    Manager findManager(String username);
}
