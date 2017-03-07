package com.phoebe.dao;

import com.phoebe.model.Orderinfo;
import com.phoebe.model.Room;

import java.util.List;

/**
 * Created by phoebegl on 2017/2/27.
 * 负责预定、订单等的管理
 */
public interface OrderDao {

    List<Room> getEmptyRoom(int typeid, String begin, String end);

    int addOrder(Orderinfo order);

    List<Orderinfo> getUserOrders(String membercardid);

    List<Orderinfo> getUnusedOrders(String membercardid);

    Orderinfo getOrderInfo(String orderid);

    int updateOrder(Orderinfo order);

    Room findRoom(int type,String name);

    List<Orderinfo> getAllOrder();

    List<Orderinfo> getHotelOrders(String hotelid);

    List<Orderinfo> getHotelAllOrders(String hotelid);

    List<Orderinfo> SearchOrder(String hotelid,String phone);
}
