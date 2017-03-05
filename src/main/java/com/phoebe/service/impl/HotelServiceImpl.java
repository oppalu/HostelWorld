package com.phoebe.service.impl;

import com.phoebe.controller.common.DateFormater;
import com.phoebe.dao.HotelDao;
import com.phoebe.model.Hotel;
import com.phoebe.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by phoebegl on 2017/3/5.
 */
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelDao hotel;

    public int openHotel(Hotel h) {
        h.setState("审核中");
        h.setOpendate(DateFormater.getCurrentDate());
        return hotel.addHotel(h);
    }

    public Hotel loginByName(String name) {
        return hotel.findHotelByName(name);
    }

    public Hotel login(String id) {
        return hotel.findHotel(id);
    }
}
