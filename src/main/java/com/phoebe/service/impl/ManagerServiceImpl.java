package com.phoebe.service.impl;

import com.phoebe.controller.common.DateFormater;
import com.phoebe.controller.common.String2Arr;
import com.phoebe.dao.ManagerDao;
import com.phoebe.model.Hotel;
import com.phoebe.model.Manager;
import com.phoebe.model.Plan;
import com.phoebe.model.Roomtype;
import com.phoebe.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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

    @Scheduled(cron = "0 0 12 * * ?")
    public void planvalid() {
        List<Plan> plans = dao.getAllPlans();
        for(Plan p : plans) {
            if(p.getBegintime().toString().equals(DateFormater.getCurrentDate().toString())) {
                //使得plan生效,修改房间价格
                String hotelid = p.getHotelid();
                List<String> types =  String2Arr.transfer(p.getRoomtype());
                List<String> price =  String2Arr.transfer(p.getPrice());
                for(int i = 0;i<types.size();i++) {
                    Roomtype type = dao.findRoomType(hotelid,types.get(i));
                    type.setPrice(Double.parseDouble(price.get(i)));
                    dao.planValid(type);
                }
            }

        }
    }

}
