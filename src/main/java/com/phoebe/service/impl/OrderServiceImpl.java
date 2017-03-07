package com.phoebe.service.impl;

import com.phoebe.controller.common.DateFormater;
import com.phoebe.dao.OrderDao;
import com.phoebe.model.Membercard;
import com.phoebe.model.Orderinfo;
import com.phoebe.model.Room;
import com.phoebe.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
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
        if(o.getStatus().equals("预定中")) {
            o.setStatus("已取消");
            Room room = order.findRoom(o.getType(),o.getRoomname());
            room.setStatus("空闲");
            room.setOrderend(null);
            room.setOrderstart(null);
            return updateOrder(o);
        }
        return 0;
    }

    public int updateOrder(Orderinfo orderinfo) {
        return order.updateOrder(orderinfo);
    }

    public List<Orderinfo> getHotelOrders(String hotelid) {
        return order.getHotelOrders(hotelid);
    }

    public List<Orderinfo> getHotelAllOrders(String hotelid) {
        return order.getHotelAllOrders(hotelid);
    }

    public List<Orderinfo> SearchOrder(String hotelid, String phone) {
        return order.SearchOrder(hotelid, phone);
    }

    public Room findRoom(int type, String name) {
        return order.findRoom(type, name);
    }

    @Scheduled(cron = "0 0 0 * * ?")
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
                }
            }
        }
    }
}
