package com.phoebe.controller.common;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by phoebegl on 2017/3/4.
 */
public class DateFormater {

    public static Date transfer(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date date = sdf.parse(s);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            return sqlDate;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getCurrentDate() {
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        return sqlDate;

    }

    public static Date getFutureDate() {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(System.currentTimeMillis());
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 1);
        date = new Date(calendar.getTime().getTime());
        return date;
    }
}
