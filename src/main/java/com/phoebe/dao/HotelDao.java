package com.phoebe.dao;

import com.phoebe.model.*;

import java.sql.Date;
import java.util.List;

/**
 * Created by phoebegl on 2017/2/27.
 * 负责宾馆信息、房间信息的管理
 */
public interface HotelDao {

    int addHotel(Hotel h);

    int updateHotel(Hotel h);

    Hotel findHotel(String id);

    Hotel findHotelByName(String name);

    List<Hotel> findHotels();

    List<Hotel> findHotels(String city);

    int addRoomType(Roomtype roomtype);

    int addRoom(Room room);

    int updateRoom(Room room);

    Room findRoom(String id);

    List<Roomtype> getTypes(String hotelid);

    Roomtype getType(int id);

    List<Room> getRooms(String hotelid);

    int addPlan(Plan plan);

    int updatePlan(Plan plan);

    Plan getPlanInfo(String id);

    List<Plan> getPlans(String hotelid);

    List<Orderinfo> getFinishOrders(String hotelid);

    int getOrderNum(String hotelid,Date begin, Date end);

    int getSuccessNumByMonth(String hotelid,Date begin, Date end);

    double eachHotel(String hotelid);
}
