package com.phoebe.dao.impl;

import com.phoebe.dao.BaseDao;
import com.phoebe.dao.ManagerDao;
import com.phoebe.model.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by phoebegl on 2017/3/4.
 */
@Repository
public class ManagerDaoImpl implements ManagerDao{

    @Autowired
    private BaseDao baseDao;

    public Manager findManager(String userid) {
        return (Manager)baseDao.find(Manager.class,userid);
    }

    public List<Hotel> checkHotels() {
        Session session = baseDao.getSession();
        String hql = "from Hotel where state = '审核中'";
        return session.createQuery(hql).list();
    }

    public Hotel getHotelInfo(String id) {
        return (Hotel)baseDao.find(Hotel.class,id);
    }

    public int checkHotel(Hotel hotel) {
        return baseDao.update(hotel);
    }

    public List<Plan> checkPlans() {
        Session session = baseDao.getSession();
        String hql = "from Plan where state = '审核中'";
        return session.createQuery(hql).list();
    }

    public List<Plan> getAllPlans() {
        Session session = baseDao.getSession();
        String hql = "from Plan where state = '审核通过'";
        return session.createQuery(hql).list();
    }

    public Plan getPlanInfo(String id) {
        return (Plan)baseDao.find(Plan.class,id);
    }

    public int checkPlan(Plan p) {
        return baseDao.update(p);
    }

    public void planValid(Roomtype room) {
        baseDao.update(room);
    }

    public Roomtype findRoomType(String hotelid, String name) {
        Session session = baseDao.getSession();
        String hql = "from Roomtype where hotelid = '"+hotelid+"' and name = '"+name+"'";
        return (Roomtype)session.createQuery(hql).uniqueResult();
    }

    public List getBalance() {
        Session session = baseDao.getSession();
        String hql = "select hotelid,name,account,sum(realprice) from orderinfo,bankaccount" +
                " where hotelid = ownerid and paytype = '会员卡' and status = '已完成'" +
                "group by hotelid";
        return session.createSQLQuery(hql).list();
    }

    public int updateBalanceOrder(String hotelid) {
        Session session = baseDao.getSession();
        String hql = "from Orderinfo where hotelid = '"+hotelid+"' and status = '已完成' and paytype = '会员卡' ";
        List<Orderinfo> list = session.createQuery(hql).list();
        for(Orderinfo o : list) {
            o.setStatus("已结算");
            baseDao.update(o);
        }
        return 1;
    }
}
