package com.phoebe.controller;

import com.phoebe.controller.common.HandleError;
import com.phoebe.controller.common.String2Arr;
import com.phoebe.model.Hotel;
import com.phoebe.model.Manager;
import com.phoebe.model.Plan;
import com.phoebe.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by phoebegl on 2017/3/3.
 */
@Controller
@RequestMapping("/manage")
public class ManagerController {

    @Autowired
    private ManagerService manager;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "manage/login";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("manager");
        return "manage/login";
    }

    @RequestMapping(value = "/hotels", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("mname") String username,
                              @RequestParam("mpassword") String password,
                              HttpServletRequest request, HttpServletResponse response) {

        if(username.equals("") || password.equals("")) {
            HandleError.handle(request,response,"工号或密码不能为空!");
            return new ModelAndView("manage/login");
        }

        Manager m = manager.login(username);
        if(m!= null && m.getPassword().equals(password)) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("hotels",manager.checkHotels());
            request.getSession().setAttribute("manager",m);
            return new ModelAndView("manage/modify",map);
        } else {
            HandleError.handle(request,response,"用户名或密码错误!");
            return new ModelAndView("manage/login");
        }
    }

    @RequestMapping(value = "/hotels", method = RequestMethod.GET)
    public ModelAndView getHotels(HttpSession session) {
        Manager m = (Manager)session.getAttribute("manager");
        if(m == null)
            return new ModelAndView("manage/login");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("hotels",manager.checkHotels());
        return new ModelAndView("manage/modify",map);
    }

    @RequestMapping(value = "/{hotelid}",method = RequestMethod.GET)
    public ModelAndView showHotelInfo(@PathVariable String hotelid,HttpSession session){
        Manager m = (Manager)session.getAttribute("manager");
        if(m == null)
            return new ModelAndView("manage/login");

        Hotel h = manager.getHotelInfo(hotelid);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("hotel",h);
        return new ModelAndView("manage/hotelinfo",result);
    }

    @RequestMapping(value = "/stateok/{hotelid}", method = RequestMethod.POST)
    public ModelAndView hotelpass(@PathVariable String hotelid,
                                  HttpServletRequest request, HttpServletResponse response) {
        Hotel h = manager.getHotelInfo(hotelid);
        h.setState("审核通过");
        int res = manager.checkHotel(h);

        if(res == 1) HandleError.handle(request, response, "审核成功");
        else HandleError.handle(request, response, "审核失败");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("hotels",manager.checkHotels());
        return new ModelAndView("manage/modify",map);
    }

    @RequestMapping(value = "/stateno/{hotelid}", method = RequestMethod.POST)
    public ModelAndView hotelunpass(@PathVariable String hotelid,
                                    HttpServletRequest request, HttpServletResponse response) {
        Hotel h = manager.getHotelInfo(hotelid);
        h.setState("审核不通过");
        int res = manager.checkHotel(h);
        if(res == 1) HandleError.handle(request, response, "审核成功");
        else HandleError.handle(request, response, "审核失败");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("hotels",manager.checkHotels());
        return new ModelAndView("manage/modify",map);
    }

    @RequestMapping(value = "/plans", method = RequestMethod.GET)
    public ModelAndView getPlans(HttpSession session) {
        Manager m = (Manager)session.getAttribute("manager");
        if(m == null)
            return new ModelAndView("manage/login");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("plans",manager.checkPlans());
        return new ModelAndView("manage/plan",map);
    }

    @RequestMapping(value = "/plan/{planid}",method = RequestMethod.GET)
    public ModelAndView showPlanInfo(@PathVariable String planid,HttpSession session){
        Manager m = (Manager)session.getAttribute("manager");
        if(m == null)
            return new ModelAndView("manage/login");

        Plan plan = manager.getPlanInfo(planid);
        String type = plan.getRoomtype();
        String price = plan.getPrice();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("type", String2Arr.transfer(type));
        map.put("price", String2Arr.transfer(price));
        map.put("plan",plan);
        return new ModelAndView("manage/planinfo",map);
    }

    @RequestMapping(value = "/ok/{planid}", method = RequestMethod.POST)
    public ModelAndView planpass(@PathVariable String planid,
                                 HttpServletRequest request, HttpServletResponse response) {
        Plan plan = manager.getPlanInfo(planid);
        plan.setState("审核通过");
        int res = manager.checkPlan(plan);
        if(res == 1) HandleError.handle(request, response, "审核成功");
        else HandleError.handle(request, response, "审核失败");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("plans",manager.checkPlans());
        return new ModelAndView("manage/plan",map);
    }

    @RequestMapping(value = "/no/{planid}", method = RequestMethod.POST)
    public ModelAndView planunpass(@PathVariable String planid,
                                   HttpServletRequest request, HttpServletResponse response) {
        Plan plan = manager.getPlanInfo(planid);
        plan.setState("审核不通过");
        int res = manager.checkPlan(plan);
        if(res == 1) HandleError.handle(request, response, "审核成功");
        else HandleError.handle(request, response, "审核失败");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("plans",manager.checkPlans());
        return new ModelAndView("manage/plan",map);
    }

}
