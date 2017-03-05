package com.phoebe.dao.impl;

import com.phoebe.dao.BaseDao;
import com.phoebe.dao.ManagerDao;
import com.phoebe.model.Hotel;
import com.phoebe.model.Manager;
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
        String state = "审核中";
        String hql = "from Hotel where state = '审核中'";
        return session.createQuery(hql).list();
    }

    public Hotel getHotelInfo(String id) {
        return (Hotel)baseDao.find(Hotel.class,id);
    }

    public int checkHotel(Hotel hotel) {
        return baseDao.update(hotel);
    }
}
