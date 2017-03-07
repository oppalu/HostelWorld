package com.phoebe.controller;

import com.phoebe.controller.common.DateFormater;
import com.phoebe.controller.common.HandleError;
import com.phoebe.controller.common.String2Arr;
import com.phoebe.model.Hotel;
import com.phoebe.model.Plan;
import com.phoebe.model.Room;
import com.phoebe.model.Roomtype;
import com.phoebe.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by phoebegl on 2017/3/5.
 */
@Controller
public class RoomController {

    @Autowired
    private HotelService roomService;

    @RequestMapping(value = "/hotel/room",method = RequestMethod.GET)
    public ModelAndView room(HttpSession session) {
        Hotel h = (Hotel)session.getAttribute("hotel");
        List<Roomtype> type = roomService.getTypes(h.getId());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("types",type);
        return new ModelAndView("hotel/addroom",map);
    }

    @RequestMapping(value = "/hotel/roomtype",method = RequestMethod.POST)
    public ModelAndView addroomtype(@RequestParam("typename")String type,
                                    @RequestParam("size")String size,
                                    @RequestParam("bednum")String bednum,
                                    HttpServletRequest request, HttpServletResponse response) {

        Roomtype roomtype = new Roomtype();
        roomtype.setName(type);
        roomtype.setBednum(Integer.parseInt(bednum));
        Hotel h = (Hotel) request.getSession().getAttribute("hotel");

        roomtype.setHotelid(h.getId());
        roomtype.setSize(Double.parseDouble(size));
        int res = roomService.addRoomType(roomtype);

        if(res == 1)
            HandleError.handle(request, response, "添加成功");
        else
            HandleError.handle(request, response, "添加失败");

        List<Roomtype> t = roomService.getTypes(h.getId());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("types",t);
        return new ModelAndView("hotel/addroom",map);
    }

    @RequestMapping(value = "/hotel/room",method = RequestMethod.POST)
    public ModelAndView addroom(@RequestParam("name")String name,
                                @RequestParam("roomtype")String type,
                                HttpServletRequest request, HttpServletResponse response) {
        Room room = new Room();
        int temp = Integer.parseInt(type);
        room.setType(temp);
        room.setTypename(roomService.getTypename(temp));
        room.setName(name);
        int res = roomService.addRoom(room);
        if(res == 1)
            HandleError.handle(request, response, "添加成功");
        else
            HandleError.handle(request, response, "添加失败");

        Hotel h = (Hotel) request.getSession().getAttribute("hotel");
        List<Roomtype> t = roomService.getTypes(h.getId());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("types",t);
        return new ModelAndView("hotel/addroom",map);
    }

    @RequestMapping(value = "/hotel/showRooms",method = RequestMethod.GET)
    public ModelAndView showRooms(HttpSession session) {
        Hotel h = (Hotel)session.getAttribute("hotel");
        List<Room> rooms = roomService.getRooms(h.getId());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rooms",rooms);
        return new ModelAndView("hotel/roominfo",map);
    }

    @RequestMapping(value = "/room/{roomid}",method = RequestMethod.GET)
    public ModelAndView showRoomInfo(@PathVariable String roomid,
                                     HttpSession session) {
        Room room = roomService.findRoom(roomid);
        Hotel h = (Hotel)session.getAttribute("hotel");
        List<Roomtype> t = roomService.getTypes(h.getId());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("types",t);
        map.put("room",room);
        return new ModelAndView("hotel/roomedit",map);
    }

    @RequestMapping(value = "/room/modify",method = RequestMethod.POST)
    public ModelAndView updateRoomInfo(@RequestParam("roomid")String roomid,
                                       @RequestParam("name")String name,
                                       @RequestParam("roomtype")String type,
                                       HttpServletRequest request, HttpServletResponse response) {

        Room room = roomService.findRoom(roomid);
        int temp = Integer.parseInt(type);
        room.setType(temp);
        room.setTypename(roomService.getTypename(temp));
        room.setName(name);

        int res = roomService.updateRoom(room);
        if(res == 1)
            HandleError.handle(request, response, "修改成功");
        else
            HandleError.handle(request, response, "修改失败");

        Hotel h = (Hotel) request.getSession().getAttribute("hotel");
        List<Room> rooms = roomService.getRooms(h.getId());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rooms",rooms);
        return new ModelAndView("hotel/roominfo",map);
    }

    @RequestMapping(value = "/hotel/plan",method = RequestMethod.GET)
    public ModelAndView getPlan(HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        Hotel h = (Hotel)session.getAttribute("hotel");
        List<Plan> plan = roomService.getPlans(h.getId());
        map.put("plans",plan);
        return new ModelAndView("hotel/plans",map);
    }

    @RequestMapping(value = "/hotel/addplan",method = RequestMethod.GET)
    public ModelAndView addPlan(HttpSession session) {
        Hotel h = (Hotel)session.getAttribute("hotel");
        List<Roomtype> t = roomService.getTypes(h.getId());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("types",t);
        return new ModelAndView("hotel/addplan",map);
    }

    @RequestMapping(value = "/hotel/addplan",method = RequestMethod.POST)
    public ModelAndView addPlan(@RequestParam("starttime") String starttime,
                                @RequestParam("endtime") String endtime,
                                HttpServletRequest request, HttpServletResponse response) {
        String type = "";
        String price = "";
        Hotel h = (Hotel) request.getSession().getAttribute("hotel");
        List<Roomtype> t = roomService.getTypes(h.getId());
        for(int i = 1;i<t.size();i++) {
            String temp1 = "type"+String.valueOf(i);
            String temp2 = "price"+String.valueOf(i);
            type += request.getParameter(temp1)+",";
            price += request.getParameter(temp2)+",";
        }
        type += request.getParameter("type"+String.valueOf(t.size()));
        price += request.getParameter("price"+String.valueOf(t.size()));
        Plan plan = new Plan();
        plan.setHotelid(h.getId());
        plan.setBegintime(DateFormater.transfer(starttime));
        plan.setEndtime(DateFormater.transfer(endtime));
        plan.setRoomtype(type);
        plan.setPrice(price);
        int res = roomService.addPlan(plan);
        if(res == 1)
            HandleError.handle(request, response, "添加成功");
        else
            HandleError.handle(request, response, "添加失败");

        Map<String, Object> map = new HashMap<String, Object>();
        List<Plan> p = roomService.getPlans(h.getId());
        map.put("plans",p);
        return new ModelAndView("hotel/plans",map);
    }

    @RequestMapping(value = "/plan/{planid}",method = RequestMethod.GET)
    public ModelAndView showPlanInfo(@PathVariable String planid) {
        Plan p = roomService.getPlanInfo(planid);
        String type = p.getRoomtype();
        String price = p.getPrice();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("plan",p);
        map.put("type",String2Arr.transfer(type));
        map.put("price", String2Arr.transfer(price));
        return new ModelAndView("hotel/plandetail",map);
    }

}
