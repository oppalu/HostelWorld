package com.phoebe.service.impl;

import com.phoebe.dao.ManagerDao;
import com.phoebe.model.Hotel;
import com.phoebe.model.Manager;
import com.phoebe.model.Plan;
import com.phoebe.model.Roomtype;
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

    public int checkHotel(Hotel hotel) {
        return dao.checkHotel(hotel);
    }

    public List<Plan> checkPlans() {
        return dao.checkPlans();
    }

    public Plan getPlanInfo(String id) {
        return dao.getPlanInfo(id);
    }

    public int checkPlan(Plan p) {
        return dao.checkPlan(p);
    }

    public void planvalid(String hotelid, List<String> name, List<String> price) {
        for(int i = 0;i<name.size();i++) {
            Roomtype type = dao.findRoomType(hotelid,name.get(i));
            type.setPrice(Double.parseDouble(price.get(i)));
            dao.planValid(type);
        }
    }

}
