package com.phoebe.dao;

import com.phoebe.model.Hotel;
import com.phoebe.model.Manager;

import java.util.List;

/**
 * Created by phoebegl on 2017/3/4.
 */
public interface ManagerDao {

    Manager findManager(String username);

    List<Hotel> checkHotels();

    Hotel getHotelInfo(String id);

    /*
    审批结果
     */
    int checkHotel(Hotel hotel);
}
