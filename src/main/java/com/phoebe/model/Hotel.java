package com.phoebe.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by phoebegl on 2017/2/27.
 */
@Entity
public class Hotel {
    private String id;
    private String name;
    private String password;
    private String city;
    private String location;
    private String telephone;
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
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "city", nullable = false, length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "location", nullable = false, length = 255)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "telephone", nullable = false, length = 255)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

        Hotel hotel = (Hotel) o;

        if (id != null ? !id.equals(hotel.id) : hotel.id != null) return false;
        if (name != null ? !name.equals(hotel.name) : hotel.name != null) return false;
        if (password != null ? !password.equals(hotel.password) : hotel.password != null) return false;
        if (city != null ? !city.equals(hotel.city) : hotel.city != null) return false;
        if (location != null ? !location.equals(hotel.location) : hotel.location != null) return false;
        if (telephone != null ? !telephone.equals(hotel.telephone) : hotel.telephone != null) return false;
        if (state != null ? !state.equals(hotel.state) : hotel.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }    private String bankid;

    @Basic
    @Column(name = "bankid", nullable = false, length = 255)
    public String getBankid() {
        return bankid;
    }

    public void setBankid(String bankid) {
        this.bankid = bankid;
    }
}
