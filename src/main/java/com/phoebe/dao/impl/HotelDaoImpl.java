package com.phoebe.dao.impl;

import com.phoebe.dao.BaseDao;
import com.phoebe.dao.HotelDao;
import com.phoebe.model.*;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
        Bankaccount bankaccount = new Bankaccount();
        bankaccount.setName(h.getName());
        bankaccount.setAccount("0");
        bankaccount.setBalance(0);
        bankaccount.setOwnerid(s);
        baseDao.save(bankaccount);
        return baseDao.save(h);
    }

    public int updateHotel(Hotel h) {
        Session session = baseDao.getSession();
        String hql = "from Bankaccount where ownerid = \'"+h.getId()+"\'";
        Bankaccount b = (Bankaccount)session.createQuery(hql).uniqueResult();
        System.out.print(b.getBalance());
        b.setAccount(h.getBankid());
        b.setName(h.getName());
        baseDao.update(b);
        return baseDao.update(h);
    }

    public Hotel findHotel(String id) {
        return (Hotel)baseDao.find(Hotel.class,id);
    }

    public Hotel findHotelByName(String name) {
        Session session = baseDao.getSession();
        String hql = "from Hotel where name = '"+name+"'";
        return (Hotel) session.createQuery(hql).uniqueResult();
    }

    public List<Hotel> findHotels() {
        return baseDao.findAll(Hotel.class);
    }

    public List<Hotel> findHotels(String city) {
        Session session = baseDao.getSession();
        String hql = "from Hotel where city = '"+city+"'";
        return  session.createQuery(hql).list();
    }

    public int addRoomType(Roomtype roomtype) {
        return baseDao.save(roomtype);
    }

    public int addRoom(Room room) {
        String s = "R"+ baseDao.getNum("room");
        room.setId(s);
        return baseDao.save(room);
    }

    public int updateRoom(Room room) {
        return baseDao.update(room);
    }

    public Room findRoom(String id) {
        return (Room)baseDao.find(Room.class,id);
    }

    public List<Roomtype> getTypes(String hotelid) {
        Session session = baseDao.getSession();
        String hql = "from Roomtype where hotelid = '"+hotelid+"'";
        return session.createQuery(hql).list();
    }

    public String getTypename(int id) {
        Session session = baseDao.getSession();
        String hql = "from Roomtype where id = "+id;
        Roomtype type = (Roomtype) session.createQuery(hql).uniqueResult();
        return type.getName();
    }

    public List<Room> getRooms(String hotelid) {
        Session session = baseDao.getSession();
        List<Roomtype> types = getTypes(hotelid);
        List<Room> result = new ArrayList<Room>();
        for(Roomtype type : types) {
            String hql = "from Room where type = "+type.getId();
            List<Room> temp = session.createQuery(hql).list();
            result.addAll(temp);
        }
        return result;
    }

    public int addPlan(Plan plan) {
        String s = "P"+baseDao.getNum("plan");
        plan.setId(s);
        return baseDao.save(plan);
    }

    public int updatePlan(Plan plan) {
        return baseDao.update(plan);
    }

    public Plan getPlanInfo(String id) {
        return (Plan)baseDao.find(Plan.class,id);
    }

    public List<Plan> getPlans(String id) {
        Session session = baseDao.getSession();
        String hql = "from Plan where hotelid = \'"+id+"\'";
        return session.createQuery(hql).list();
    }
}
