package com.phoebe.service;

import com.phoebe.model.Hotel;
import com.phoebe.model.Manager;

import java.util.List;

/**
 * Created by phoebegl on 2017/3/4.
 */
public interface ManagerService {

    Manager login(String username);

    List<Hotel> checkHotels();

    Hotel getHotelInfo(String id);
}
