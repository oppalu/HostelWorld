package com.phoebe.dao.impl;

import com.phoebe.dao.BaseDao;
import com.phoebe.dao.HotelDao;
import com.phoebe.model.Hotel;
import com.phoebe.model.Member;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by phoebegl on 2017/2/27.
 */
@Repository
public class HotelDaoImpl implements HotelDao {

    @Autowired
    private BaseDao baseDao;

    public int addHotel(Hotel h) {
        String s = "H"+ baseDao.getNum("hotel");
        h.setId(s);
        return baseDao.save(h);
    }

    public int updateHotel(Hotel h) {
        return baseDao.update(h);
    }

    public Hotel findHotel(String id) {
        return (Hotel)baseDao.find(Hotel.class,id);
    }

    public Hotel findHotelByName(String name) {
        Session session = baseDao.getSession();
        String hql = "from Hotel where name ="+name;
        return (Hotel) session.createQuery(hql).uniqueResult();
    }

    public List<Hotel> findHotels() {
        return baseDao.findAll(Hotel.class);
    }
}
