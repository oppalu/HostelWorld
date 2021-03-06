package com.phoebe.service;

import com.phoebe.model.Hotel;
import com.phoebe.model.Manager;
import com.phoebe.model.Plan;

import java.util.List;

/**
 * Created by phoebegl on 2017/3/4.
 */
public interface ManagerService {

    Manager login(String username);

    List<Hotel> checkHotels();

    Hotel getHotelInfo(String id);

    int checkHotel(Hotel hotel);

    List<Plan> checkPlans();

    Plan getPlanInfo(String id);

    int checkPlan(Plan p);

    List getBalance();

    int updateBalanceOrder(String hotelid);
}
