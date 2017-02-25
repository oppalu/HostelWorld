package com.phoebe.controller;

import com.phoebe.model.User;
import com.phoebe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phoebegl on 2017/2/25.
 */
@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        List<User> us = new ArrayList<User>();
        User u = new User();
        u.setNickname("MarK");
        u.setPassword("123456");
        us.add(u);
        u = new User();
        u.setNickname("Fawofolo");
        u.setPassword("123456");
        us.add(u);
        userService.saveUsers(us);
        return "index";
    }

    @RequestMapping("/test")
    @ResponseBody
    public List<User> test() {
        return userService.getAllUsernames();
    }

    @RequestMapping("/update")
    @ResponseBody
    public int t() {
        User u = new User();
        u.setId(22);
        u.setNickname("phoebe");
        u.setPassword("123456");
        return userService.update(u);
    }
}
