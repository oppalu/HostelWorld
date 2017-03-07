package com.phoebe.service.impl;

import com.phoebe.dao.OrderDao;
import com.phoebe.model.Room;
import com.phoebe.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by phoebegl on 2017/3/7.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao order;


    public int getEmptyRoomNumber(int typeid, String begin, String end) {
        return getEmptyRoom(typeid, begin, end).size();
    }

    public List<Room> getEmptyRoom(int typeid, String begin, String end) {
        return order.getEmptyRoom(typeid, begin, end);
    }
}
