package com.phoebe.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by phoebegl on 2017/2/27.
 */
@Entity
public class Order {
    private String id;
    private String status;
    private String user1;
    private String idcard1;
    private String user2;
    private String idcard2;
    private String phone;
    private Timestamp createtime;
    private Date begintime;
    private Date endtime;
    private double price;
    private String paytype;

    @Id
    @Column(name = "id", nullable = false, length = 45)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 20)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "user1", nullable = false, length = 45)
    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    @Basic
    @Column(name = "idcard1", nullable = false, length = 255)
    public String getIdcard1() {
        return idcard1;
    }

    public void setIdcard1(String idcard1) {
        this.idcard1 = idcard1;
    }

    @Basic
    @Column(name = "user2", nullable = true, length = 45)
    public String getUser2() {
        return user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }

    @Basic
    @Column(name = "idcard2", nullable = true, length = 255)
    public String getIdcard2() {
        return idcard2;
    }

    public void setIdcard2(String idcard2) {
        this.idcard2 = idcard2;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 255)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "createtime", nullable = false)
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Basic
    @Column(name = "begintime", nullable = false)
    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    @Basic
    @Column(name = "endtime", nullable = false)
    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "paytype", nullable = false, length = 20)
    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (Double.compare(order.price, price) != 0) return false;
        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (status != null ? !status.equals(order.status) : order.status != null) return false;
        if (user1 != null ? !user1.equals(order.user1) : order.user1 != null) return false;
        if (idcard1 != null ? !idcard1.equals(order.idcard1) : order.idcard1 != null) return false;
        if (user2 != null ? !user2.equals(order.user2) : order.user2 != null) return false;
        if (idcard2 != null ? !idcard2.equals(order.idcard2) : order.idcard2 != null) return false;
        if (phone != null ? !phone.equals(order.phone) : order.phone != null) return false;
        if (createtime != null ? !createtime.equals(order.createtime) : order.createtime != null) return false;
        if (begintime != null ? !begintime.equals(order.begintime) : order.begintime != null) return false;
        if (endtime != null ? !endtime.equals(order.endtime) : order.endtime != null) return false;
        if (paytype != null ? !paytype.equals(order.paytype) : order.paytype != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (user1 != null ? user1.hashCode() : 0);
        result = 31 * result + (idcard1 != null ? idcard1.hashCode() : 0);
        result = 31 * result + (user2 != null ? user2.hashCode() : 0);
        result = 31 * result + (idcard2 != null ? idcard2.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        result = 31 * result + (begintime != null ? begintime.hashCode() : 0);
        result = 31 * result + (endtime != null ? endtime.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (paytype != null ? paytype.hashCode() : 0);
        return result;
    }

    private String hotelid;

    @Basic
    @Column(name = "hotelid", nullable = false, length = 45)
    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }

    private String type;

    @Basic
    @Column(name = "type", nullable = false, length = 45)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String roomid;

    @Basic
    @Column(name = "roomid", nullable = false, length = 45)
    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    private String membercard;

    @Basic
    @Column(name = "membercard", nullable = true, length = 45)
    public String getMembercard() {
        return membercard;
    }

    public void setMembercard(String membercard) {
        this.membercard = membercard;
    }
}
