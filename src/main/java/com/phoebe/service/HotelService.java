package com.phoebe.service;

import com.phoebe.model.Hotel;

/**
 * Created by phoebegl on 2017/3/5.
 */
public interface HotelService {

    int openHotel(Hotel h);

    Hotel loginByName(String name);

    Hotel login(String id);
}
