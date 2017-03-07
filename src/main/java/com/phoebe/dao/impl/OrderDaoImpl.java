package com.phoebe.dao.impl;

import com.phoebe.dao.BaseDao;
import com.phoebe.dao.OrderDao;
import com.phoebe.model.Order;
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

    public int addOrder(Order order) {
        String s = "O"+ baseDao.getNum("order");
        order.setId(s);
        return baseDao.save(order);
    }

    public List<Order> getUserOrders(String membercardid) {
        Session session = baseDao.getSession();
        String hql = "from Order where membercard = '"+membercardid+"'";
        return session.createQuery(hql).list();
    }

    public List<Order> getUnusedOrders(String membercardid) {
        Session session = baseDao.getSession();
        String hql = "from Order where membercard = '"+membercardid+"' and status = '预定中'";
        return session.createQuery(hql).list();
    }
}
