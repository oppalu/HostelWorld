package com.phoebe.controller;

import com.phoebe.controller.common.DateFormater;
import com.phoebe.dao.ManagerDao;
import com.phoebe.model.Hotel;
import com.phoebe.model.Manager;
import com.phoebe.model.Member;
import com.phoebe.model.Orderinfo;
import com.phoebe.service.HotelService;
import com.phoebe.service.MemberService;
import com.phoebe.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.*;

/**
 * Created by phoebegl on 2017/3/8.
 */
@Controller
public class AnalyseController {

    @Autowired
    private MemberService member;
    @Autowired
    private HotelService hotel;
    @Autowired
    private OrderService order;
    @Autowired
    private ManagerDao manager;

    @RequestMapping(value = "/member/analyse",method = RequestMethod.GET)
    public ModelAndView analyse(HttpSession session) {
        Member m = (Member)session.getAttribute("member");
        if(m == null)
            return new ModelAndView("customer/login");

        Map<String, Object> map = new HashMap<String,Object>();
        List<Orderinfo> all = order.getUserOrders(member.findMycard(m.getId()).getId());
        int success = 0;
        double money = 0.0;
        for(Orderinfo o :all) {
            if(o.getStatus().equals("入住中") || o.getStatus().equals("已完成")|| o.getStatus().equals("已结算"))
                success++;
            if(o.getStatus().equals("已完成")|| o.getStatus().equals("已结算"))
                money +=o.getRealprice();
        }
        map.put("all",all.size());
        map.put("success",success);
        map.put("money",money);
        return new ModelAndView("customer/analyse",map);

    }

    @RequestMapping(value = "/hotel/analyse",method = RequestMethod.GET)
    public ModelAndView hotelanalyse(HttpSession session) {
        Hotel h = (Hotel)session.getAttribute("hotel");
        if(h == null)
            return new ModelAndView("hotel/login");

        Map<String, Object> map = new HashMap<String,Object>();
        //所有订单
        List<Orderinfo> all = order.getHotelAllOrders(h.getId());
        List<String> type = new ArrayList<String>();
        for(Orderinfo o :all) {
            type.add(hotel.getTypename(o.getType()));
        }
        //所有成功入住的订单
        List<Orderinfo> success = hotel.getFinishOrders(h.getId());
        double member = 0.0;
        double nonmember = 0.0;
        for(Orderinfo o : success) {
            if(o.getMembercard() != null)
                member +=o.getRealprice();
            else
                nonmember += o.getRealprice();
        }

        map.put("list",all);
        map.put("typename",type);
        map.put("allcount",all.size());
        map.put("successcount",success.size());
        map.put("member",member);
        map.put("nonmember",nonmember);
        map.put("profit",member+nonmember);

        return new ModelAndView("hotel/analyse",map);

    }

    @RequestMapping(value = "/hotel/allchart",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> allChart(HttpSession session) {
        Hotel h = (Hotel)session.getAttribute("hotel");
        int temp = DateFormater.getMonth();
        List<Integer> month = new ArrayList<Integer>();
        List<Integer> count = new ArrayList<Integer>();
        for(int i = 1;i<=temp;i++) {
            month.add(i);
            count.add(hotel.getOrderNum(h.getId(),DateFormater.getBegin(i),DateFormater.getEnd(i)));
        }
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("month",month);
        result.put("count",count);
        return result;
    }

    @RequestMapping(value = "/hotel/successchart",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> successChart(HttpSession session) {
        Hotel h = (Hotel)session.getAttribute("hotel");
        int temp = DateFormater.getMonth();
        List<Integer> month = new ArrayList<Integer>();
        List<Integer> count = new ArrayList<Integer>();
        for(int i = 1;i<=temp;i++) {
            month.add(i);
            count.add(hotel.getSuccessNumByMonth(h.getId(),DateFormater.getBegin(i),DateFormater.getEnd(i)));
        }
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("m",month);
        result.put("c",count);
        return result;
    }

    @RequestMapping(value = "/eachhotel",method = RequestMethod.GET)
    public ModelAndView manageranalyse(HttpSession session) {
        Manager m = (Manager)session.getAttribute("manager");
        if(m == null)
            return new ModelAndView("manage/login");

        Map<String, Object> map = new HashMap<String,Object>();
        List<Hotel> hotels = hotel.findHotels();
        List<Integer> ordernum = new ArrayList<Integer>();
        List<Double> money = new ArrayList<Double>();

        for(Hotel h : hotels) {
            if(!hotel.getFinishOrders(h.getId()).isEmpty()) {
                ordernum.add(hotel.getFinishOrders(h.getId()).size());
                money.add(hotel.eachHotel(h.getId()));
            } else {
                ordernum.add(0);
                money.add(0.0);
            }
        }
        map.put("hotels",hotels);
        map.put("ordernum",ordernum);
        map.put("money",money);
        return new ModelAndView("manage/each_hotel",map);

    }

    @RequestMapping(value = "/membersta",method = RequestMethod.GET)
    public ModelAndView memberanalyse(HttpSession session) {
        Manager m = (Manager)session.getAttribute("manager");
        if(m == null)
            return new ModelAndView("manage/login");

        Map<String, Object> map = new HashMap<String,Object>();
        map.put("allnum",order.getUserOrders().size());
        map.put("allmoney",order.getUserPay());
        map.put("member",member.findMemberNum());

        return new ModelAndView("manage/member",map);

    }

    @RequestMapping(value = "/membernum",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> memberNum() {
        int temp = DateFormater.getMonth();
        List<Integer> month = new ArrayList<Integer>();
        List<Integer> count = new ArrayList<Integer>();
        for(int i = 1;i<=temp;i++) {
            month.add(i);
            count.add(order.getOrderNum(DateFormater.getBegin(i),DateFormater.getEnd(i)));
        }
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("month",month);
        result.put("count",count);
        return result;
    }

    @RequestMapping(value = "/membermoney",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> memberMoney() {
        int temp = DateFormater.getMonth();
        List<Integer> month = new ArrayList<Integer>();
        List<Double> count = new ArrayList<Double>();
        for(int i = 1;i<=temp;i++) {
            System.out.println("ok");
            month.add(i);
            if(order.getPayNum(DateFormater.getBegin(i),DateFormater.getEnd(i)) != null)
                count.add((Double)order.getPayNum(DateFormater.getBegin(i),DateFormater.getEnd(i)));
            else
                count.add(0.0);
            System.out.println("**"+order.getPayNum(DateFormater.getBegin(i),DateFormater.getEnd(i)));
        }
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("month",month);
        result.put("count",count);
        return result;
    }

    @RequestMapping(value = "/financesta",method = RequestMethod.GET)
    public ModelAndView financeanalyse(HttpSession session) {
        Manager m = (Manager)session.getAttribute("manager");
        if(m == null)
            return new ModelAndView("manage/login");

        Map<String, Object> map = new HashMap<String,Object>();
        map.put("allmoney",order.getProfit());

        return new ModelAndView("manage/finance",map);
    }

    @RequestMapping(value = "/sysmoney",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> sysMoney() {
        int temp = DateFormater.getMonth();
        List<Integer> month = new ArrayList<Integer>();
        List<Double> mem = new ArrayList<Double>();
        List<Double> nonmem = new ArrayList<Double>();
        for(int i = 1;i<=temp;i++) {
            System.out.println("ok");
            month.add(i);
            if(order.getPayNum(DateFormater.getBegin(i),DateFormater.getEnd(i)) != null)
                mem.add((Double)order.getPayNum(DateFormater.getBegin(i),DateFormater.getEnd(i)));
            else
                mem.add(0.0);

            if(order.getNonMemberPayNum(DateFormater.getBegin(i),DateFormater.getEnd(i)) != null)
                nonmem.add((Double)order.getNonMemberPayNum(DateFormater.getBegin(i),DateFormater.getEnd(i)));
            else
                nonmem.add(0.0);

        }
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("month",month);
        result.put("member",mem);
        result.put("nonmem",nonmem);
        return result;
    }

}
