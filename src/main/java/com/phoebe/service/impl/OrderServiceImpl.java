package com.phoebe.service.impl;

import com.phoebe.controller.common.DateFormater;
import com.phoebe.dao.HotelDao;
import com.phoebe.dao.OrderDao;
import com.phoebe.model.Membercard;
import com.phoebe.model.Orderinfo;
import com.phoebe.model.Room;
import com.phoebe.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by phoebegl on 2017/3/7.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao order;
    @Autowired
    private HotelDao hotel;

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

    public int addOrder(Orderinfo o) {
        o.setCreatetime(DateFormater.getCurrentDate());
        return order.addOrder(o);
    }

    public List<Orderinfo> getUserOrders(String membercardid) {
        return order.getUserOrders(membercardid);
    }

    public List<Orderinfo> getUnusedOrders(String membercardid) {
        return order.getUnusedOrders(membercardid);
    }

    public Orderinfo getOrderInfo(String orderid) {
        return order.getOrderInfo(orderid);
    }

    public int cancelOrder(String orderid) {
        Orderinfo o = getOrderInfo(orderid);
        if(o.getStatus().equals("预定中") || o.getStatus().equals("已支付")) {
            o.setStatus("已取消");
            Room room = order.findRoom(o.getType(),o.getRoomname());
            room.setStatus("空闲");
            room.setOrderend(null);
            room.setOrderstart(null);
            hotel.updateRoom(room);
            return updateOrder(o);
        }
        return 0;
    }

    public int finishOrder(Orderinfo o) {
        o.setStatus("已完成");
        Room room = order.findRoom(o.getType(),o.getRoomname());
        room.setStatus("空闲");
        room.setOrderend(null);
        room.setOrderstart(null);
        hotel.updateRoom(room);
        return updateOrder(o);
    }

    public int updateOrder(Orderinfo orderinfo) {
        return order.updateOrder(orderinfo);
    }

    public List<Orderinfo> getHotelOrders(String hotelid) {
        List<Orderinfo> list1 = order.getHotelOrders(hotelid,"预定中");
        List<Orderinfo> list2 = order.getHotelOrders(hotelid,"已支付");
        list2.addAll(list1);
        return list2;
    }

    public List<Orderinfo> getHotelAllOrders(String hotelid) {
        return order.getHotelOrders(hotelid,"");
    }

    public List<Orderinfo> getLiveOrders(String hotelid) {
        List<Orderinfo> list1 = order.getHotelOrders(hotelid,"入住中");
        List<Orderinfo> list2 = order.getHotelOrders(hotelid,"已支付");
        list2.addAll(list1);
        return list2;
    }

    public List<Orderinfo> SearchOrder(String hotelid, String phone) {
        return order.SearchOrder(hotelid, phone);
    }

    public Room findRoom(int type, String name) {
        return order.findRoom(type, name);
    }

    public List<Orderinfo> getUserOrders() {
        return order.getUserOrders();
    }

    public int getOrderNum(Date begin, Date end) {
        return order.getOrderNum(begin, end);
    }

    public double getUserPay() {
        return order.getUserPay();
    }

    public Object getPayNum(Date begin, Date end) {
        return order.getPayNum(begin,end);
    }

    public double getProfit() {
        return  order.getProfit();
    }

    public Object getNonMemberPayNum(Date begin, Date end) {
        return order.getNonMemberPayNum(begin, end);
    }

    @Scheduled(cron = "0 0 12 * * ?")
    public void checkOrderStatus() {
        List<Orderinfo> orders = order.getAllOrder();
        for(Orderinfo m : orders) {
            if(m.getBegintime().before(DateFormater.getYesterdayDate())) {
                if(m.getStatus().equals("预定中")) {
                    m.setStatus("已失效");
                    Room room = order.findRoom(m.getType(),m.getRoomname());
                    room.setStatus("空闲");
                    room.setOrderend(null);
                    room.setOrderstart(null);
                    updateOrder(m);
                    hotel.updateRoom(room);
                }
            }
        }
    }
}
