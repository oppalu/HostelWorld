package com.phoebe.dao;

import com.phoebe.model.Hotel;
import com.phoebe.model.Room;
import com.phoebe.model.Roomtype;

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

    int addRoomType(Roomtype roomtype);

    int addRoom(Room room);

    int updateRoom(Room room);

    Room findRoom(String id);

    List<Roomtype> getTypes();

    String getTypename(int id);

    List<Room> getRooms();

    List<Room> getEmptyRooms();


}
