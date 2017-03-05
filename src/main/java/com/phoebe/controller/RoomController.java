package com.phoebe.controller;

import com.phoebe.controller.common.HandleError;
import com.phoebe.model.Hotel;
import com.phoebe.model.Room;
import com.phoebe.model.Roomtype;
import com.phoebe.service.HotelService;
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
        List<Roomtype> type = roomService.getTypes();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("types",type);
        Hotel h = (Hotel) session.getAttribute("hotel");
        map.put("hotel",h);
        return new ModelAndView("hotel/addroom",map);
    }

    @RequestMapping(value = "/hotel/roomtype",method = RequestMethod.POST)
    public ModelAndView addroomtype(@RequestParam("typename")String type,
                                    @RequestParam("size")String size,
                                    @RequestParam("bednum")String bednum,
                                    HttpSession session,
                                    HttpServletRequest request, HttpServletResponse response) {

        Roomtype roomtype = new Roomtype();
        roomtype.setName(type);
        roomtype.setBednum(Integer.parseInt(bednum));
        Hotel h = (Hotel) session.getAttribute("hotel");

        roomtype.setHotelid(h.getId());
        roomtype.setSize(Double.parseDouble(size));
        int res = roomService.addRoomType(roomtype);

        if(res == 1)
            HandleError.handle(request, response, "添加成功");
        else
            HandleError.handle(request, response, "添加失败");
        List<Roomtype> t = roomService.getTypes();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("types",t);
        map.put("hotel",h);
        return new ModelAndView("/hotel/addroom",map);
    }

    @RequestMapping(value = "/hotel/room",method = RequestMethod.POST)
    public ModelAndView addroom(@RequestParam("name")String name,
                                @RequestParam("roomtype")String type,
                                HttpSession session,
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

        List<Roomtype> t = roomService.getTypes();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("types",t);
        Hotel h = (Hotel) session.getAttribute("hotel");
        map.put("hotel",h);
        return new ModelAndView("/hotel/addroom",map);
    }

    @RequestMapping(value = "/hotel/showRooms",method = RequestMethod.GET)
    public ModelAndView showRooms(HttpSession session) {
        List<Room> rooms = roomService.getRooms();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rooms",rooms);
        Hotel h = (Hotel) session.getAttribute("hotel");
        map.put("hotel",h);
        return new ModelAndView("hotel/roominfo",map);
    }

    @RequestMapping(value = "/room/{roomid}",method = RequestMethod.GET)
    public ModelAndView showRoomInfo(@PathVariable String roomid, HttpSession session) {
        Room room = roomService.findRoom(roomid);

        List<Roomtype> t = roomService.getTypes();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("types",t);
        map.put("room",room);
        Hotel h = (Hotel) session.getAttribute("hotel");
        map.put("hotel",h);
        return new ModelAndView("hotel/roomedit",map);
    }

    @RequestMapping(value = "/room/modify",method = RequestMethod.POST)
    public ModelAndView updateRoomInfo(@RequestParam("roomid")String roomid,
                                       @RequestParam("name")String name,
                                       @RequestParam("roomtype")String type,
                                       HttpSession session,
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

        List<Room> rooms = roomService.getRooms();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rooms",rooms);
        Hotel h = (Hotel) session.getAttribute("hotel");
        map.put("hotel",h);
        return new ModelAndView("hotel/roominfo",map);
    }
}
