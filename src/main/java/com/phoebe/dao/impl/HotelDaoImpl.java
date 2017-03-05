package com.phoebe.dao.impl;

import com.phoebe.dao.BaseDao;
import com.phoebe.dao.HotelDao;
import com.phoebe.model.Bankaccount;
import com.phoebe.model.Hotel;
import com.phoebe.model.Room;
import com.phoebe.model.Roomtype;
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
        String hql = "from Hotel where name = "+name;
        return (Hotel) session.createQuery(hql).uniqueResult();
    }

    public List<Hotel> findHotels() {
        return baseDao.findAll(Hotel.class);
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

    public List<Roomtype> getTypes() {
        return baseDao.findAll(Roomtype.class);
    }

    public String getTypename(int id) {
        Session session = baseDao.getSession();
        String hql = "from Roomtype where id = "+id;
        Roomtype type = (Roomtype) session.createQuery(hql).uniqueResult();
        return type.getName();
    }

    public List<Room> getRooms() {
        return baseDao.findAll(Room.class);
    }

    public List<Room> getEmptyRooms() {
        Session session = baseDao.getSession();
        String hql = "from Room where status = '空闲'";
        return session.createQuery(hql).list();
    }
}
