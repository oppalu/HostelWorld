package com.phoebe.dao;

import com.phoebe.model.User;

import java.util.List;

/**
 * Created by phoebegl on 2017/2/25.
 */
public interface UserDao {

    int save(User u);

    List<User> findAllUsers();

    int delete(int id);

    int update(User u);
}
