package com.phoebe.dao;

import com.phoebe.model.*;

import java.util.List;

/**
 * Created by phoebegl on 2017/3/4.
 */
public interface ManagerDao {

    Manager findManager(String username);

    List<Hotel> checkHotels();

    Hotel getHotelInfo(String id);

    //审批结果,update
    int checkHotel(Hotel hotel);

    List<Plan> checkPlans();

    Plan getPlanInfo(String id);

    int checkPlan(Plan p);

    //这个是为了改plan导致的房间价格变动
    void planValid(Roomtype room);

    Roomtype findRoomType(String hotelid,String name);
}
