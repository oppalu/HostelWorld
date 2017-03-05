package com.phoebe.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phoebe.controller.common.HandleError;
import com.phoebe.model.Hotel;
import com.phoebe.model.Manager;
import com.phoebe.model.Member;
import com.phoebe.service.ManagerService;
import com.phoebe.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by phoebegl on 2017/3/3.
 */
@Controller
public class ManagerController {

    @Autowired
    private ManagerService manager;

    @RequestMapping(value = "/manage/login", method = RequestMethod.GET)
    public String login() {
        return "/manager/login";
    }

    @RequestMapping(value = "/manage/hotels", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("mname") String username,
                              @RequestParam("mpassword") String password,
                              HttpServletRequest request, HttpServletResponse response) {

        if(username.equals("") || password.equals("")) {
            HandleError.handle(request,response,"用户名或密码不能为空!");
            return new ModelAndView("/manager/login");
        }
        Manager m = manager.login(username);
        if(m!= null && m.getPassword().equals(password)) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("manager",m);
            map.put("hotels",manager.checkHotels());
            return new ModelAndView("/manager/modify",map);
        }

        else {
            HandleError.handle(request,response,"用户名或密码错误!");
            return new ModelAndView("/manager/login");
        }
    }

    @RequestMapping(value = "/manage/{hotelid}",method = RequestMethod.GET)
    public  ModelAndView showUser(@PathVariable String hotelid){

        Hotel h = manager.getHotelInfo(hotelid);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("hotel",h);
        return new ModelAndView("/manger/hotelinfo",result);
    }
}
