package com.phoebe.dao;

import com.phoebe.model.Order;
import com.phoebe.model.Room;

import java.util.List;

/**
 * Created by phoebegl on 2017/2/27.
 * 负责预定、订单等的管理
 */
public interface OrderDao {

    List<Room> getEmptyRoom(int typeid, String begin, String end);

    int addOrder(Order order);

    List<Order> getUserOrders(String membercardid);

    List<Order> getUnusedOrders(String membercardid);
}
