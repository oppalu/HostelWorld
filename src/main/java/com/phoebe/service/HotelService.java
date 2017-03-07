package com.phoebe.service;

import com.phoebe.model.Hotel;
import com.phoebe.model.Plan;
import com.phoebe.model.Room;
import com.phoebe.model.Roomtype;

import java.util.List;

/**
 * Created by phoebegl on 2017/3/5.
 */
public interface HotelService {

    int openHotel(Hotel h);

    Hotel loginByName(String name);

    Hotel login(String id);

    String getHotelName(String id);

    List<Hotel> findHotels(String city);

    List<Hotel> findHotels();

    int updateHotel(Hotel h);

    int addRoomType(Roomtype roomtype);

    int addRoom(Room room);

    int updateRoom(Room room);

    Room findRoom(String id);

    List<Roomtype> getTypes(String hotelid);

    Roomtype getType(int id);

    String getTypename(int id);

    List<Room> getRooms(String hotelid);

    int addPlan(Plan plan);

    int updatePlan(Plan plan);

    Plan getPlanInfo(String id);

    List<Plan> getPlans(String hotelid);
}
