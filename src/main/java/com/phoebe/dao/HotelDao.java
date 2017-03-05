package com.phoebe.dao;

import com.phoebe.model.Hotel;

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
}
