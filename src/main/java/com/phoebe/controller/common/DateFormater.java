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

    public static Date getYesterdayDate() {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(System.currentTimeMillis());
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = new Date(calendar.getTime().getTime());
        return date;
    }

    public static Date getFutureDate() {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(System.currentTimeMillis());
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 1);
        date = new Date(calendar.getTime().getTime());
        return date;
    }

    public static int getMonth() {
        String[] temp = getCurrentDate().toString().split("-");
        return Integer.parseInt(temp[1]);
    }

    public static Date getBegin(int month) {
        String temp = String.valueOf(month);
        if(temp.length() == 1)
            temp = "0"+temp;
        String s = getCurrentDate().toString().split("-")[0]+"-"+temp+"-01";
        return transfer(s);
    }

    public static Date getEnd(int month) {
        String temp = String.valueOf(month+1);
        if(temp.length() == 1)
            temp = "0"+temp;
        String s = getCurrentDate().toString().split("-")[0]+"-"+temp+"-01";
        return transfer(s);
    }

    public static long getIntervals(Date begin,Date end) {
        long temp = end.getTime() - begin.getTime();
        return temp/(24 * 60 * 60 * 1000) == 0 ? 1 : temp/(24 * 60 * 60 * 1000);
    }
}
