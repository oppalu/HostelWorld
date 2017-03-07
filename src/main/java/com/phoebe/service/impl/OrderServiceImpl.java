package com.phoebe.service.impl;

import com.phoebe.controller.common.DateFormater;
import com.phoebe.dao.OrderDao;
import com.phoebe.model.Order;
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

    public Room OneEmptyRoom(int typeid, String begin, String end) {
        List<Room> rooms = getEmptyRoom(typeid, begin, end);
        int index=(int)(Math.random()*rooms.size());
        return rooms.get(index);
    }

    public int addOrder(Order o) {
        o.setCreatetime(DateFormater.getCurrentDate());
        return order.addOrder(o);
    }

    public List<Order> getUserOrders(String membercardid) {
        return order.getUserOrders(membercardid);
    }

    public List<Order> getUnusedOrders(String membercardid) {
        return order.getUnusedOrders(membercardid);
    }
}
