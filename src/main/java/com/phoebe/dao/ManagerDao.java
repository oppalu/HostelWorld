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

    List<Plan> getAllPlans();

    Plan getPlanInfo(String id);

    int checkPlan(Plan p);

    void planValid(Roomtype room);

    Roomtype findRoomType(String hotelid,String name);

    List getBalance();

    int updateBalanceOrder(String hotelid);
}
