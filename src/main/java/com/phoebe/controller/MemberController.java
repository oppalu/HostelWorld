package com.phoebe.controller;

import com.phoebe.controller.common.DateFormater;
import com.phoebe.controller.common.HandleError;
import com.phoebe.controller.common.Helper;
import com.phoebe.model.*;
import com.phoebe.service.HotelService;
import com.phoebe.service.MemberService;
import com.phoebe.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by phoebegl on 2017/3/3.
 * 对于会员的信息管理
 */
@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService member;

    @Autowired
    private HotelService hotel;

    @Autowired
    private OrderService order;

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
            return new ModelAndView("customer/main","member",m);
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
        if(m == null)
            return new ModelAndView("customer/login");
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

    @RequestMapping(value = "/submitOrder",method = RequestMethod.POST)
    public ModelAndView submitOrder(@RequestParam("hotelid") String hotelid,
                                    @RequestParam("roomid") String roomid,
                                    @RequestParam("phone") String phone,
                                    HttpServletRequest request, HttpServletResponse response) {

        String begin = (String)request.getSession().getAttribute("datein");
        String end = (String)request.getSession().getAttribute("dateout");
        Member m = (Member)request.getSession().getAttribute("member");
        Room room = hotel.findRoom(roomid);
        Roomtype type = hotel.getType(room.getType());
        Membercard card = member.findMycard(m.getId());

        Orderinfo o = new Orderinfo();
        o.setHotelid(hotelid);
        o.setType(room.getType());
        o.setRoomname(room.getName());
        o.setStatus("预定中");
        o.setPhone(phone);
        o.setBegintime(DateFormater.transfer(begin));
        o.setEndtime(DateFormater.transfer(begin));
        long day = DateFormater.getIntervals(DateFormater.transfer(begin),DateFormater.transfer(begin));
        o.setPrice(type.getPrice()*day);
        o.setMembercard(card.getId());

        int res = order.addOrder(o);
        if(res == 1) {
            HandleError.handle(request, response, "下单成功!");
            room.setStatus("预定中");
            room.setOrderstart(DateFormater.transfer(begin));
            room.setOrderend(DateFormater.transfer(end));
            hotel.updateRoom(room);
        } else {
            HandleError.handle(request, response, "下单失败!");
        }

        Map<String, Object> map = getorderFunc(request.getSession());
        return new ModelAndView("customer/userorder",map);
    }

    @RequestMapping(value = "/getorders",method = RequestMethod.GET)
    public ModelAndView getOrders(HttpSession session) {
        if(session.getAttribute("member") == null)
            return new ModelAndView("customer/login");

        Map<String, Object> map = getorderFunc(session);
        return new ModelAndView("customer/userorder",map);

    }

    @RequestMapping(value = "/cancel/{orderid}",method = RequestMethod.GET)
    public ModelAndView cancelOrder(@PathVariable String orderid,
                                    HttpServletRequest request, HttpServletResponse response) {
        if(request.getSession().getAttribute("member") == null)
            return new ModelAndView("customer/login");

        Orderinfo o = order.getOrderInfo(orderid);
        if(o.getStatus().equals("已支付")) {
            Membercard card = member.findMembercard(o.getMembercard());
            card.setBalance(card.getBalance() + o.getRealprice());
            card.setPoint(card.getPoint()-o.getRealprice());
            card.setTotalpoint(card.getTotalpoint()-o.getRealprice());
            card.setLevel(card.getTotalpoint().intValue()/500);
            member.updateMembercard(card);
        }

        int res = order.cancelOrder(orderid);
        if(res == 1) HandleError.handle(request, response, "取消成功!");
        else HandleError.handle(request, response, "取消失败!");

        Map<String, Object> map = getorderFunc(request.getSession());
        return new ModelAndView("customer/userorder",map);

    }

    @RequestMapping(value = "/prepay/{orderid}",method = RequestMethod.GET)
    public ModelAndView prepay(@PathVariable String orderid,
                                    HttpServletRequest request, HttpServletResponse response) {
        if(request.getSession().getAttribute("member") == null)
            return new ModelAndView("customer/login");

        Orderinfo o = order.getOrderInfo(orderid);
        Membercard card = member.findMembercard(o.getMembercard());
        o.setDiscount(Helper.calculateDiscount(card.getLevel(),o.getPrice()));
        o.setRealprice(o.getPrice()-o.getDiscount());
        if(card.getBalance() < o.getRealprice()) {
            HandleError.handle(request, response, "余额不足!");
            Map<String, Object> map = getorderFunc(request.getSession());
            return new ModelAndView("customer/userorder",map);
        }
        card.setBalance(card.getBalance() - o.getRealprice());
        card.setPoint(card.getPoint()+o.getRealprice());
        card.setTotalpoint(card.getTotalpoint()+o.getRealprice());
        card.setLevel(card.getTotalpoint().intValue()/500);
        member.updateMembercard(card);

        o.setStatus("已支付");
        o.setPaytype("会员卡");
        int res = order.updateOrder(o);
        if(res == 1) HandleError.handle(request, response, "支付成功!");
        else HandleError.handle(request, response, "支付失败!");

        Map<String, Object> map = getorderFunc(request.getSession());
        return new ModelAndView("customer/userorder",map);

    }

    private Map getorderFunc(HttpSession session) {
        Member m = (Member)session.getAttribute("member");

        Map<String, Object> map = new HashMap<String, Object>();
        List<Orderinfo> all = order.getUserOrders(member.findMycard(m.getId()).getId());
        List<Orderinfo> orders = order.getUnusedOrders(member.findMycard(m.getId()).getId());

        map.put("all",all);
        map.put("unuse",orders);

        List<String> allName = new ArrayList<String>();
        List<String> allType = new ArrayList<String>();
        List<String> unName = new ArrayList<String>();
        List<String> unType = new ArrayList<String>();

        for(Orderinfo o :all) {
            allName.add(hotel.getHotelName(o.getHotelid()));
            allType.add(hotel.getTypename(o.getType()));
        }
        for(Orderinfo o :orders) {
            unName.add(hotel.getHotelName(o.getHotelid()));
            unType.add(hotel.getTypename(o.getType()));
        }
        map.put("allname",allName);
        map.put("alltype",allType);
        map.put("unname",unName);
        map.put("untype",unType);
        return map;
    }

}
