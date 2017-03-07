package com.phoebe.service;

import com.phoebe.model.Orderinfo;
import com.phoebe.model.Room;

import java.util.List;

/**
 * Created by phoebegl on 2017/3/7.
 */
public interface OrderService {

    int getEmptyRoomNumber(int typeid, String begin,String end);

    List<Room> getEmptyRoom(int typeid, String begin, String end);

    Room OneEmptyRoom(int typeid, String begin,String end);

    int addOrder(Orderinfo order);

    List<Orderinfo> getUserOrders(String membercardid);

    List<Orderinfo> getUnusedOrders(String membercardid);

    Orderinfo getOrderInfo(String orderid);

    int cancelOrder(String orderid);

    int updateOrder(Orderinfo orderinfo);

    List<Orderinfo> getHotelOrders(String hotelid);

    List<Orderinfo> getHotelAllOrders(String hotelid);

    List<Orderinfo> SearchOrder(String hotelid,String phone);

    Room findRoom(int type,String name);
}
