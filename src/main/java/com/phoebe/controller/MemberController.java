package com.phoebe.controller;

import com.phoebe.controller.common.DateFormater;
import com.phoebe.controller.common.HandleError;
import com.phoebe.model.Hotel;
import com.phoebe.model.Member;
import com.phoebe.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by phoebegl on 2017/3/3.
 * 对于会员的信息管理
 */
@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService member;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "customer/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "customer/register";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("member");
        return "customer/login";
    }

    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              HttpServletRequest request, HttpServletResponse response) {

        if(username.equals("") || password.equals("")) {
            HandleError.handle(request,response,"用户名或密码不能为空!");
            return new ModelAndView("customer/login");
        }

        Member m = member.login(username);

        if(m!= null && m.getPassword().equals(password)) {
            request.getSession().setAttribute("member",m);
            return new ModelAndView("customer/userinfo","member",m);
        }
        else {
            HandleError.handle(request,response,"用户名或密码错误!");
            return new ModelAndView("customer/login");
        }
    }

    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public ModelAndView register(@RequestParam("nickname") String username,
                                 @RequestParam("username") String name,
                                 @RequestParam("password") String password,
                                 @RequestParam("phone") String phone,
                                 @RequestParam("sex") String sex,
                                 @RequestParam("birth") String birth,
                                 HttpServletRequest request, HttpServletResponse response) {
        if(username.equals("") || password.equals("") || name.equals("")) {
            HandleError.handle(request,response,"用户名、姓名或密码不能为空!");
            return new ModelAndView("customer/register");
        }

        Member m = new Member();
        m.setNickname(username);
        m.setName(name);
        m.setPassword(password);
        m.setPhone(phone);
        m.setSex(sex);
        m.setBirthday(DateFormater.transfer(birth));

        int res = member.register(m);
        if(res == 1) {
            member.addMembercard(m.getId());
            request.getSession().setAttribute("member",m);
            HandleError.handle(request, response, "注册成功!");
            return new ModelAndView("customer/userinfo","member",m);
        }
        else {
            HandleError.handle(request, response, "注册失败!");
            return new ModelAndView("customer/register");
        }
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ModelAndView getUserInfo(HttpSession session) {
        Member m = (Member)session.getAttribute("member");
        return new ModelAndView("customer/userinfo","member",m);
    }

    @RequestMapping(value = "/updateinfo",method = RequestMethod.POST)

    public ModelAndView updateUserInfo(@RequestParam("nick")String username,
                                       @RequestParam("userid")String id,
                                       @RequestParam("username")String name,
                                       @RequestParam("sex")String sex,
                                       @RequestParam("phone")String phone,
                                       @RequestParam("birth")String birth,
                                       HttpServletRequest request, HttpServletResponse response) {

        Member m = member.findUserById(id);
        m.setName(name);
        m.setNickname(username);
        m.setSex(sex);
        m.setPhone(phone);
        m.setBirthday(DateFormater.transfer(birth));

        int res = member.updateUser(m);
        if(res == 1) HandleError.handle(request, response, "修改成功!");
        else HandleError.handle(request, response, "修改失败!");

        return new ModelAndView("customer/userinfo","member",m);
    }

    @RequestMapping(value = "/updatepass",method = RequestMethod.POST)
    public ModelAndView updatePassword(@RequestParam("userid")String id,
                                       @RequestParam("new_pwd")String newpwd,
                                       HttpServletRequest request, HttpServletResponse response) {
        Member m = member.findUserById(id);
        m.setPassword(newpwd);
        int res = member.updateUser(m);
        if(res == 1) HandleError.handle(request, response, "修改成功!");
        else HandleError.handle(request, response, "修改失败!");

        return new ModelAndView("customer/userinfo","member",m);
    }

}
