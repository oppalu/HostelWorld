package com.phoebe.dao.impl;

import com.phoebe.dao.BaseDao;
import com.phoebe.dao.OrderDao;
import com.phoebe.model.Orderinfo;
import com.phoebe.model.Room;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phoebegl on 2017/2/27.
 */
@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private BaseDao baseDao;

    public List<Room> getEmptyRoom(int typeid, String begin, String end) {
        List<Room> result = new ArrayList<Room>();
        Session session = baseDao.getSession();

        String hql = "from Room where type = "+typeid+" and status = '空闲'";
        result.addAll(session.createQuery(hql).list());
        hql = "from Room where type = "+typeid+" and orderstart > '"+end+"'";
        result.addAll(session.createQuery(hql).list());
        hql = "from Room where type = "+typeid+" and orderend < '"+begin+"'";
        result.addAll(session.createQuery(hql).list());

        return result;
    }

    public int addOrder(Orderinfo order) {
        String s = "O"+ baseDao.getNum("order");
        order.setId(s);
        return baseDao.save(order);
    }

    public List<Orderinfo> getUserOrders(String membercardid) {
        Session session = baseDao.getSession();
        String hql = "from Orderinfo where membercard = '"+membercardid+"'";
        return session.createQuery(hql).list();
    }

    public List<Orderinfo> getUnusedOrders(String membercardid) {
        Session session = baseDao.getSession();
        String hql = "from Orderinfo where membercard = '"+membercardid+"' and status = '预定中'";
        return session.createQuery(hql).list();
    }

    public Orderinfo getOrderInfo(String orderid) {
        return (Orderinfo) baseDao.find(Orderinfo.class,orderid);
    }

    public int updateOrder(Orderinfo order) {
        return baseDao.update(order);
    }

    public Room findRoom(int type, String name) {
        Session session = baseDao.getSession();
        String hql = "from Room where type = "+type+" and name = '"+name+"'";
        return (Room)session.createQuery(hql).uniqueResult();
    }

    public List<Orderinfo> getAllOrder() {
        return baseDao.findAll(Orderinfo.class);
    }

    public List<Orderinfo> getHotelOrders(String hotelid) {
        Session session = baseDao.getSession();
        String hql = "from Orderinfo where hotelid = '"+hotelid+"' and status = '预定中'";
        return session.createQuery(hql).list();
    }

    public List<Orderinfo> getHotelAllOrders(String hotelid) {
        Session session = baseDao.getSession();
        String hql = "from Orderinfo where hotelid = '"+hotelid+"'";
        return session.createQuery(hql).list();
    }

    public List<Orderinfo> SearchOrder(String hotelid,String phone) {
        Session session = baseDao.getSession();
        String hql = "from Orderinfo where hotelid = '"+hotelid+"' and phone = '"+phone+"'";
        return session.createQuery(hql).list();
    }
}
