package com.phoebe.controller;

import com.phoebe.controller.common.DateFormater;
import com.phoebe.controller.common.HandleError;
import com.phoebe.model.*;
import com.phoebe.service.HotelService;
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

        List<Hotel> hotels = hotel.findHotels(city);
        request.getSession().setAttribute("datein",datein);
        request.getSession().setAttribute("dateout",dateout);
        return new ModelAndView("customer/main","hotels",hotels);
    }

    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public ModelAndView toMain() {
        List<Hotel> hotels = hotel.findHotels();
        return new ModelAndView("customer/main","hotels",hotels);
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

        return new ModelAndView("customer/booking",map);
    }

    @RequestMapping(value = "/submitOrder",method = RequestMethod.POST)
    public ModelAndView submitOrder(@RequestParam("hotelid") String hotelid,
                                    @RequestParam("roomid") String roomid,
                                    @RequestParam("phone") String phone,
                                    HttpSession session) {
        return null;
//        String begin = (String)session.getAttribute("datein");
//        String end = (String)session.getAttribute("dateout");
//        Member m = (Member)session.getAttribute("member");
//
//        Room room = hotel.findRoom(roomid);
//
//        Order o = new Order();
//        o.setHotelid(hotelid);
//        o.setType(room.getType());
//        o.setRoomname(room.getName());
//        o.setStatus("预定中");
//        o.setPhone(phone);
//        o.setBegintime(DateFormater.transfer(begin));
//        o.setEndtime(DateFormater.transfer(end));
//        o.setPrice();
//        o.setMembercard(m.);
    }

}
