package com.phoebe.service.impl;

import com.phoebe.controller.common.DateFormater;
import com.phoebe.dao.HotelDao;
import com.phoebe.model.Hotel;
import com.phoebe.model.Plan;
import com.phoebe.model.Room;
import com.phoebe.model.Roomtype;
import com.phoebe.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by phoebegl on 2017/3/5.
 */
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelDao hotel;

    public int openHotel(Hotel h) {
        h.setState("审核中");
        h.setOpendate(DateFormater.getCurrentDate());
        return hotel.addHotel(h);
    }

    public Hotel loginByName(String name) {
        return hotel.findHotelByName(name);
    }

    public Hotel login(String id) {
        return hotel.findHotel(id);
    }

    public int updateHotel(Hotel h) {
        h.setState("审核中");
        return hotel.updateHotel(h);
    }

    public int addRoomType(Roomtype roomtype) {
        return hotel.addRoomType(roomtype);
    }

    public int addRoom(Room room) {
        room.setStatus("空闲");
        return hotel.addRoom(room);
    }

    public int updateRoom(Room room) {
        return hotel.updateRoom(room);
    }

    public Room findRoom(String id) {
        return hotel.findRoom(id);
    }

    public List<Roomtype> getTypes() {
        return hotel.getTypes();
    }

    public String getTypename(int id) {
        return hotel.getTypename(id);
    }

    public List<Room> getRooms() {
        return hotel.getRooms();
    }

    public List<Room> getEmptyRooms() {
        return hotel.getEmptyRooms();
    }

    public int addPlan(Plan plan) {
        plan.setCreatetime(DateFormater.getCurrentDate());
        plan.setState("审核中");
        return hotel.addPlan(plan);
    }

    public int updatePlan(Plan plan) {
        return hotel.updatePlan(plan);
    }

    public Plan getPlanInfo(String id) {
        return hotel.getPlanInfo(id);
    }

    public List<Plan> getPlans(String hotelid) {
        return hotel.getPlans(hotelid);
    }
}
