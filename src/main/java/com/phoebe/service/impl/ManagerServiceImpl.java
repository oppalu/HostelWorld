package com.phoebe.service.impl;

import com.phoebe.dao.ManagerDao;
import com.phoebe.model.Hotel;
import com.phoebe.model.Manager;
import com.phoebe.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by phoebegl on 2017/3/4.
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao dao;

    public Manager login(String username) {
        return dao.findManager(username);
    }

    public List<Hotel> checkHotels() {
        return dao.checkHotels();
    }

    public Hotel getHotelInfo(String id) {
        return dao.getHotelInfo(id);
    }
}
