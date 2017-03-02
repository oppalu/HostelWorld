package com.phoebe.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by phoebegl on 2017/3/2.
 */
@Entity
public class Bankaccount {
    private String account;
    private String name;
    private double balance;
    private String ownerid;

    @Id
    @Column(name = "account", nullable = false, length = 255)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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
    @Column(name = "balance", nullable = false, precision = 0)
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "ownerid", nullable = false, length = 45)
    public String getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bankaccount that = (Bankaccount) o;

        if (Double.compare(that.balance, balance) != 0) return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (ownerid != null ? !ownerid.equals(that.ownerid) : that.ownerid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = account != null ? account.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (ownerid != null ? ownerid.hashCode() : 0);
        return result;
    }
}
