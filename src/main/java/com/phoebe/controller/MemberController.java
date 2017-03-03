package com.phoebe.controller;

import com.phoebe.model.Member;
import com.phoebe.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by phoebegl on 2017/3/3.
 */
@Controller
public class MemberController {

    @Autowired
    private MemberService member;

    @RequestMapping("/")
    public String index() {
        return "/customer/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("username") String username,
                              @RequestParam("password") String password) {
        Member m = member.login(username);
        if(m.getPassword().equals(password))
            return new ModelAndView("/customer/userinfo","member",m);
        return null;
    }


}
