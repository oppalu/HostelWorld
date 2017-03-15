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
import java.sql.*;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by phoebegl on 2017/3/3.
 * 对订单的管理
 */
@Controller
public class OrderController {

    @Autowired
    private HotelService hotel;

    @Autowired
    private OrderService order;

    @Autowired
    private MemberService member;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/main",method = RequestMethod.POST)
    public ModelAndView toMain(@RequestParam("city")String city,
                               @RequestParam("datein")String datein,
                               @RequestParam("dateout")String dateout,
                               HttpServletRequest request, HttpServletResponse response) {
        if(city == "" || datein == "" || dateout == "") {
            HandleError.handle(request,response,"所填项不能为空!");
            return new ModelAndView("index");
        }

        if(DateFormater.transfer(datein).before(DateFormater.getYesterdayDate())) {
            HandleError.handle(request,response,"入住时间已过!");
            return new ModelAndView("index");
        }
        if(DateFormater.transfer(datein).after(DateFormater.transfer(dateout))) {
            HandleError.handle(request,response,"日期选择不合法!");
            return new ModelAndView("index");
        }

        List<Hotel> hotels = hotel.findHotels(city);
        request.getSession().setAttribute("datein",datein);
        request.getSession().setAttribute("dateout",dateout);
        return new ModelAndView("customer/main","hotels",hotels);
    }

    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public String toMain() {
        return "customer/main";
    }

    @RequestMapping(value = "/hotelinfo/{hotelid}",method = RequestMethod.GET)
    public ModelAndView toMain(@PathVariable String hotelid,
                               HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        Hotel h = hotel.login(hotelid);
        map.put("hotel",h);

        List<Roomtype> type = hotel.getTypes(h.getId());
        map.put("type",type);
        List<Integer> number = new ArrayList<Integer>();
        String begin = (String)session.getAttribute("datein");
        String end = (String)session.getAttribute("dateout");

        for(Roomtype roomtype : type) {
            number.add(order.getEmptyRoomNumber(roomtype.getId(),begin,end));
        }
        map.put("number",number);
        return new ModelAndView("customer/hoteldetail",map);
    }

    @RequestMapping(value = "/addOrder/{hotelid}/{type}",method = RequestMethod.GET)
    public ModelAndView addOrder(@PathVariable String hotelid,
                                 @PathVariable int type,
                                 HttpSession session) {

        Map<String, Object> map = new HashMap<String, Object>();
        Hotel h = hotel.login(hotelid);
        map.put("hotel",h);

        String begin = (String)session.getAttribute("datein");
        String end = (String)session.getAttribute("dateout");
        Room room = order.OneEmptyRoom(type,begin,end);

        map.put("room",room);

        if(session.getAttribute("member") == null)
            return new ModelAndView("customer/login");
        return new ModelAndView("customer/booking",map);


    }

    @RequestMapping(value = "/orderinfo/{orderid}",method = RequestMethod.GET)
    public ModelAndView getOrderInfo(@PathVariable String orderid,
                                  HttpSession session) {
        if(session.getAttribute("member") == null)
            return new ModelAndView("customer/login");

        Orderinfo o = order.getOrderInfo(orderid);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("order",o);
        Hotel h = hotel.login(o.getHotelid());
        map.put("hotelinfo",h);
        Roomtype type = hotel.getType(o.getType());
        map.put("type",type);

        return new ModelAndView("customer/orderinfo",map);

    }

    @RequestMapping(value = "/bookin/{orderid}",method = RequestMethod.GET)
    public ModelAndView preBookin(@PathVariable String orderid,
                                    HttpSession session) {
        if(session.getAttribute("hotel") == null)
            return new ModelAndView("hotel/login");

        Orderinfo orderinfo = order.getOrderInfo(orderid);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("order",orderinfo);
        map.put("typename",hotel.getTypename(orderinfo.getType()));
        return new ModelAndView("hotel/bookinfo",map);

    }

    @RequestMapping(value = "/newin",method = RequestMethod.GET)
    public ModelAndView newin(HttpSession session) {
        Hotel h = (Hotel)session.getAttribute("hotel");
        if(h == null)
            return new ModelAndView("hotel/login");

        List<Roomtype> t = hotel.getTypes(h.getId());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("types",t);
        return new ModelAndView("hotel/newin",map);

    }

    @RequestMapping(value = "/checkin/{orderid}",method = RequestMethod.GET)
    public ModelAndView checkin(@PathVariable String orderid, HttpSession session) {

        Hotel h = (Hotel)session.getAttribute("hotel");
        if(h == null)
            return new ModelAndView("hotel/login");

        Orderinfo orderinfo = order.getOrderInfo(orderid);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("order",orderinfo);
        map.put("typename",hotel.getTypename(orderinfo.getType()));
        return new ModelAndView("hotel/checkin",map);

    }

    @RequestMapping(value = "/newcheckin",method = RequestMethod.GET)
    public ModelAndView newCheckin(@RequestParam("roomtype") int roomtype,
                                   @RequestParam("datein") String datein,
                                   @RequestParam("dateout") String dateout,
                                   HttpServletRequest request, HttpServletResponse response) {

        Hotel h = (Hotel)request.getSession().getAttribute("hotel");
        if(h == null)
            return new ModelAndView("hotel/login");

        Room room = order.OneEmptyRoom(roomtype,datein,dateout);
        Roomtype type = hotel.getType(room.getType());

        Orderinfo o = new Orderinfo();
        o.setHotelid(h.getId());
        o.setType(room.getType());
        o.setRoomname(room.getName());
        o.setStatus("预定中");
        o.setPhone("");
        o.setBegintime(DateFormater.transfer(datein));
        o.setEndtime(DateFormater.transfer(dateout));
        long day = DateFormater.getIntervals(DateFormater.transfer(datein),DateFormater.transfer(dateout));
        o.setPrice(type.getPrice()*day);

        int res = order.addOrder(o);
        if(res == 1) {
            room.setStatus("预定中");
            room.setOrderstart(DateFormater.transfer(datein));
            room.setOrderend(DateFormater.transfer(dateout));
            hotel.updateRoom(room);
        } else {
            HandleError.handle(request, response, "预定失败!");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("order",o);
        map.put("typename",type.getName());
        return new ModelAndView("hotel/checkin",map);

    }

    @RequestMapping(value = "/checkin",method = RequestMethod.POST)
    public ModelAndView checkin(@RequestParam("orderid") String id,
                                @RequestParam("name1") String name1,
                                @RequestParam("id1") String id1,
                                @RequestParam("name2") String name2,
                                @RequestParam("id2") String id2,
                                @RequestParam("phone") String phone,
                                @RequestParam("vip") String vip,
                                HttpServletRequest request, HttpServletResponse response) {
        Hotel h = (Hotel)request.getSession().getAttribute("hotel");
        if(h == null)
            return new ModelAndView("hotel/login");

        Orderinfo o = order.getOrderInfo(id);
        o.setUser1(name1);
        o.setUser2(name2);
        o.setIdcard1(id1);
        o.setIdcard2(id2);
        o.setPhone(phone);
        o.setMembercard(vip);
        if(!o.getStatus().equals("已支付")) {
            o.setStatus("入住中");
            if(!o.getMembercard().equals("")) {
                Membercard card = member.findMembercard(o.getMembercard());
                o.setDiscount(Helper.calculateDiscount(card.getLevel(),o.getPrice()));
            } else
                o.setDiscount(0.0);
            o.setRealprice(o.getPrice()-o.getDiscount());
        }
        int res = order.updateOrder(o);
        if(res == 1) {
            Room room = order.findRoom(o.getType(),o.getRoomname());
            room.setStatus("入住中");
            hotel.updateRoom(room);
            HandleError.handle(request, response, "入住成功!");
        } else {
            HandleError.handle(request, response, "入住失败!");
        }

        return new ModelAndView("hotel/hotelinfo", "hotel", h);

    }

    @RequestMapping(value = "/checkout/{orderid}",method = RequestMethod.GET)
    public ModelAndView checkout(@PathVariable String orderid, HttpSession session) {

        Hotel h = (Hotel)session.getAttribute("hotel");
        if(h == null)
            return new ModelAndView("hotel/login");

        Orderinfo orderinfo = order.getOrderInfo(orderid);
        orderinfo.setEndtime(DateFormater.getCurrentDate());
        long day = DateFormater.getIntervals(DateFormater.transfer(orderinfo.getBegintime().toString()),
                DateFormater.transfer(orderinfo.getEndtime().toString()));
        orderinfo.setPrice(hotel.getType(orderinfo.getType()).getPrice()*day);

        if(!orderinfo.getStatus().equals("已支付")) {
            if(!orderinfo.getMembercard().equals("")) {
                Membercard card = member.findMembercard(orderinfo.getMembercard());
                orderinfo.setDiscount(Helper.calculateDiscount(card.getLevel(),orderinfo.getPrice()));
            } else
                orderinfo.setDiscount(0.0);
            orderinfo.setRealprice(orderinfo.getPrice()-orderinfo.getDiscount());
        }
        order.updateOrder(orderinfo);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("order",orderinfo);
        map.put("typename",hotel.getTypename(orderinfo.getType()));
        return new ModelAndView("hotel/checkout",map);

    }

    @RequestMapping(value = "/checkout",method = RequestMethod.POST)
    public ModelAndView checkout(@RequestParam("paytype") String paytype,
                                 @RequestParam("orderid") String id,
                                HttpServletRequest request, HttpServletResponse response) {
        Hotel h = (Hotel)request.getSession().getAttribute("hotel");
        if(h == null)
            return new ModelAndView("hotel/login");

        Orderinfo o = order.getOrderInfo(id);
        if(!o.getStatus().equals("已支付")) {
            o.setPaytype(paytype);
            if(paytype.equals("会员卡")) {
                Membercard card = member.findMembercard(o.getMembercard());
                if(card.getBalance() < o.getRealprice()) {
                    HandleError.handle(request, response, "余额不足!");
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("order",o);
                    map.put("typename",hotel.getTypename(o.getType()));
                    return new ModelAndView("hotel/checkout",map);
                }
                card.setBalance(card.getBalance() - o.getRealprice());
                card.setPoint(card.getPoint()+o.getRealprice());
                card.setTotalpoint(card.getTotalpoint()+o.getRealprice());
                card.setLevel(card.getTotalpoint().intValue()/500);
                member.updateMembercard(card);
            } else {
                if(!o.getMembercard().equals("")) {
                    Membercard card = member.findMembercard(o.getMembercard());
                    card.setPoint(card.getPoint()+o.getRealprice());
                    card.setTotalpoint(card.getTotalpoint()+o.getRealprice());
                    card.setLevel(card.getTotalpoint().intValue()/500);
                    member.updateMembercard(card);
                }
                Bankaccount company = member.findBank(h.getId());
                company.setBalance(company.getBalance()+o.getRealprice());
                member.updateBankAccount(company);
            }
        }

        int res = order.finishOrder(o);
        if(res == 1)
            HandleError.handle(request, response, "退房成功!");
        else
            HandleError.handle(request, response, "退房失败!");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("order",o);
        map.put("typename",hotel.getTypename(o.getType()));
        return new ModelAndView("hotel/checkout",map);

    }

    @RequestMapping(value = "/showinfo/{orderid}",method = RequestMethod.GET)
    public ModelAndView showOrderInfo(@PathVariable String orderid, HttpSession session) {

        Hotel h = (Hotel)session.getAttribute("hotel");
        if(h == null)
            return new ModelAndView("hotel/login");

        Orderinfo o = order.getOrderInfo(orderid);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("order",o);
        map.put("hotelinfo",h);
        Roomtype type = hotel.getType(o.getType());
        map.put("type",type);

        return new ModelAndView("hotel/orderinfo",map);

    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public ModelAndView search(@RequestParam("inputsearch") String input,
                                    HttpServletRequest request, HttpServletResponse response) {

        Hotel h = (Hotel)request.getSession().getAttribute("hotel");
        if (h == null)
            return new ModelAndView("hotel/login");

        Map<String, Object> map = new HashMap<String, Object>();
        List<Orderinfo> res = order.SearchOrder(h.getId(),input);
        map.put("list",res);
        List<String> type = new ArrayList<String>();
        for(Orderinfo o :res) {
            type.add(hotel.getTypename(o.getType()));
        }
        map.put("typename",type);
        return new ModelAndView("hotel/searchresult", map);

    }

}
