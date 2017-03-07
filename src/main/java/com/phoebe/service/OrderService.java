package com.phoebe.service;

import com.phoebe.model.Order;
import com.phoebe.model.Room;

import java.util.List;

/**
 * Created by phoebegl on 2017/3/7.
 */
public interface OrderService {

    int getEmptyRoomNumber(int typeid, String begin,String end);

    List<Room> getEmptyRoom(int typeid, String begin, String end);

    Room OneEmptyRoom(int typeid, String begin,String end);

    int addOrder(Order order);

    List<Order> getUserOrders(String membercardid);

    List<Order> getUnusedOrders(String membercardid);
}
