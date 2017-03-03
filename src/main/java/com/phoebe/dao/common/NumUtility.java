package com.phoebe.dao.common;

import com.phoebe.dao.BaseDao;
import com.phoebe.model.Number;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.DecimalFormat;

/**
 * Created by phoebegl on 2017/3/3.
 */
@Repository
public class NumUtility {

    @Autowired
    private BaseDao dao;

    public static NumUtility instance;

    private NumUtility() {}

    public static NumUtility getInstance() {
        if(instance == null)
            instance = new NumUtility();
        return instance;
    }

    public String getNum(String type) {
        Number num = (Number) dao.find(Number.class,type);
        int current = num.getNum();
        num.setNum(current+1);
        DecimalFormat df = new DecimalFormat("000000");
        return df.format(current);
    }
}
