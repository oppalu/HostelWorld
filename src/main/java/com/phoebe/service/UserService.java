package com.phoebe.service;

import com.phoebe.model.User;

import java.util.List;

/**
 * Created by phoebegl on 2017/2/25.
 */
public interface UserService {

    void saveUsers(List<User> us);

    List<User> getAllUsernames();

    public int update(User u);
}
