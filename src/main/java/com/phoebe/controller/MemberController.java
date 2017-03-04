package com.phoebe.controller;

import com.phoebe.controller.common.DateFormater;
import com.phoebe.model.Member;
import com.phoebe.model.Number;
import com.phoebe.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

/**
 * Created by phoebegl on 2017/3/3.
 * 对于会员的信息管理
 */
@Controller
public class MemberController {

    @Autowired
    private MemberService member;

    @RequestMapping("/")
    public String index() {
        return "/customer/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/customer/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("username") String username,
                              @RequestParam("password") String password) {
        Member m = member.login(username);
        if(m.getPassword().equals(password))
            return new ModelAndView("/customer/userinfo","member",m);
        return null;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "/customer/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@RequestParam("nickname") String username,
                                 @RequestParam("username") String name,
                                 @RequestParam("password") String password,
                                 @RequestParam("phone") String phone,
                                 @RequestParam("sex") String sex,
                              @RequestParam("birth") String birth) {
        Member m = new Member();
        m.setNickname(username);
        m.setName(name);
        m.setPassword(password);
        m.setPhone(phone);
        m.setSex(sex);
        m.setBirthday(DateFormater.transfer(birth));

        int res = member.register(m);
        if(res == 1)
            return new ModelAndView("/customer/userinfo","member",m);

        return new ModelAndView("/customer/register");
    }

}
