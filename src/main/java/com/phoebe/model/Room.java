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
public class Room {
    private String id;
    private int type;
    private String typename;
    private String name;
    private String status;
    private Date orderstart;
    private Date orderend;

    @Id
    @Column(name = "id", nullable = false, length = 45)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Basic
    @Column(name = "typename", nullable = true, length = 45)
    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
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
    @Column(name = "status", nullable = false, length = 20)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "orderstart", nullable = true)
    public Date getOrderstart() {
        return orderstart;
    }

    public void setOrderstart(Date orderstart) {
        this.orderstart = orderstart;
    }

    @Basic
    @Column(name = "orderend", nullable = true)
    public Date getOrderend() {
        return orderend;
    }

    public void setOrderend(Date orderend) {
        this.orderend = orderend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (type != room.type) return false;
        if (id != null ? !id.equals(room.id) : room.id != null) return false;
        if (typename != null ? !typename.equals(room.typename) : room.typename != null) return false;
        if (name != null ? !name.equals(room.name) : room.name != null) return false;
        if (status != null ? !status.equals(room.status) : room.status != null) return false;
        if (orderstart != null ? !orderstart.equals(room.orderstart) : room.orderstart != null) return false;
        if (orderend != null ? !orderend.equals(room.orderend) : room.orderend != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + type;
        result = 31 * result + (typename != null ? typename.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (orderstart != null ? orderstart.hashCode() : 0);
        result = 31 * result + (orderend != null ? orderend.hashCode() : 0);
        return result;
    }
}
