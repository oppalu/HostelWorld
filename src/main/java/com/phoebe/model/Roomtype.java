package com.phoebe.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by phoebegl on 2017/3/3.
 */
@Entity
public class Roomtype implements Serializable {
    private int id;
    private String hotelid;
    private String name;
    private double size;
    private int bednum;
    private double price;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "size", nullable = false, precision = 0)
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Basic
    @Column(name = "bednum", nullable = false)
    public int getBednum() {
        return bednum;
    }

    public void setBednum(int bednum) {
        this.bednum = bednum;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roomtype roomtype = (Roomtype) o;

        if (id != roomtype.id) return false;
        if (Double.compare(roomtype.size, size) != 0) return false;
        if (bednum != roomtype.bednum) return false;
        if (Double.compare(roomtype.price, price) != 0) return false;
        if (hotelid != null ? !hotelid.equals(roomtype.hotelid) : roomtype.hotelid != null) return false;
        if (name != null ? !name.equals(roomtype.name) : roomtype.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (hotelid != null ? hotelid.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(size);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + bednum;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
