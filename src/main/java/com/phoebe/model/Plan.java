package com.phoebe.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by phoebegl on 2017/3/7.
 */
@Entity
public class Plan {
    private String id;
    private String hotelid;
    private Date begintime;
    private Date endtime;
    private Date createtime;
    private String roomtype;
    private String price;
    private String state;

    @Id
    @Column(name = "id", nullable = false, length = 45)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "hotelid", nullable = false, length = 45)
    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
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
    @Column(name = "createtime", nullable = false)
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Basic
    @Column(name = "roomtype", nullable = false, length = 255)
    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    @Basic
    @Column(name = "price", nullable = false, length = 255)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "state", nullable = false, length = 20)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plan plan = (Plan) o;

        if (id != null ? !id.equals(plan.id) : plan.id != null) return false;
        if (hotelid != null ? !hotelid.equals(plan.hotelid) : plan.hotelid != null) return false;
        if (begintime != null ? !begintime.equals(plan.begintime) : plan.begintime != null) return false;
        if (endtime != null ? !endtime.equals(plan.endtime) : plan.endtime != null) return false;
        if (createtime != null ? !createtime.equals(plan.createtime) : plan.createtime != null) return false;
        if (roomtype != null ? !roomtype.equals(plan.roomtype) : plan.roomtype != null) return false;
        if (price != null ? !price.equals(plan.price) : plan.price != null) return false;
        if (state != null ? !state.equals(plan.state) : plan.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (hotelid != null ? hotelid.hashCode() : 0);
        result = 31 * result + (begintime != null ? begintime.hashCode() : 0);
        result = 31 * result + (endtime != null ? endtime.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        result = 31 * result + (roomtype != null ? roomtype.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
