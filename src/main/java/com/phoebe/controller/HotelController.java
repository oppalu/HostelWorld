package com.phoebe.controller;

import com.phoebe.controller.common.HandleError;
import com.phoebe.model.Hotel;
import com.phoebe.service.HotelService;
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
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotel;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login() {
        return "hotel/login";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register() {
        return "hotel/register";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("hotel");
        return "hotel/login";
    }

    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("hname") String username,
                              @RequestParam("hpassword") String password,
                              HttpServletRequest request, HttpServletResponse response) {

        Hotel h = hotel.login(username);
        if(h!= null && h.getPassword().equals(password)) {
            request.getSession().setAttribute("hotel",h);
            return new ModelAndView("hotel/hotelinfo", "hotel", h);
        }
        else {
            HandleError.handle(request,response,"酒店编号或密码错误!");
            return new ModelAndView("hotel/login");
        }

    }

    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public ModelAndView register(@RequestParam("name") String hotelname,
                                 @RequestParam("password") String password,
                                 @RequestParam("city") String city,
                                 @RequestParam("location") String location,
                                 @RequestParam("phone") String phone,
                              HttpServletRequest request, HttpServletResponse response) {

        Hotel h = new Hotel();
        h.setName(hotelname);
        h.setPassword(password);
        h.setCity(city);
        h.setLocation(location);
        h.setTelephone(phone);

        int res = hotel.openHotel(h);
        if(res == 1) {
            request.getSession().setAttribute("hotel",h);
            HandleError.handle(request, response, "注册成功,请等待审核通过!");
            return new ModelAndView("hotel/hotelinfo", "hotel", h);
        }
        else {
            HandleError.handle(request, response, "注册失败!");
            return new ModelAndView("hotel/register");
        }
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ModelAndView hotelinfo(HttpSession session) {
        Hotel h = (Hotel)session.getAttribute("hotel");
        return new ModelAndView("hotel/hotelinfo", "hotel", h);
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ModelAndView modifyInfo(@RequestParam("hotelid") String id,
                                   @RequestParam("name") String hotelname,
                                   @RequestParam("city") String city,
                                   @RequestParam("location") String location,
                                   @RequestParam("tel") String phone,
                                   @RequestParam("bank") String bank,
                                 HttpServletRequest request, HttpServletResponse response) {

        Hotel h = hotel.login(id);
        h.setName(hotelname);
        h.setCity(city);
        h.setLocation(location);
        h.setTelephone(phone);
        h.setBankid(bank);

        int res = hotel.updateHotel(h);
        if(res == 1)
            HandleError.handle(request, response, "修改成功");
        else
            HandleError.handle(request, response, "修改失败");
        return new ModelAndView("hotel/hotelinfo", "hotel", h);
    }
}
