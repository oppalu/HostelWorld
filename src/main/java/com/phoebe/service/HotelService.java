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

    int updateHotel(Hotel h);

    int addRoomType(Roomtype roomtype);

    int addRoom(Room room);

    int updateRoom(Room room);

    Room findRoom(String id);

    List<Roomtype> getTypes();

    String getTypename(int id);

    List<Room> getRooms();

    List<Room> getEmptyRooms();

    int addPlan(Plan plan);

    int updatePlan(Plan plan);

    Plan getPlanInfo(String id);

    List<Plan> getPlans(String hotelid);
}
