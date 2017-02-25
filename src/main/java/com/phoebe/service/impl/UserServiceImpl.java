package com.phoebe.service.impl;

import com.phoebe.dao.UserDao;
import com.phoebe.model.User;
import com.phoebe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by phoebegl on 2017/2/25.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void saveUsers(List<User> us) {
        for (User u : us)
            userDao.save(u);
    }

    public List<User> getAllUsernames() {
        return userDao.findAllUsers();
    }

    public int update(User u) {
        return userDao.update(u);
    }
}
