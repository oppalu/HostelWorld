package com.phoebe.controller.common;

import java.util.Arrays;
import java.util.List;

/**
 * Created by phoebegl on 2017/3/6.
 */
public class Helper {

    public static List<String> transfer(String s) {
        String[] temp = s.split(",");
        return Arrays.asList(temp);
    }

    public static double calculateDiscount(int level,double price) {
        if(level >=0 && level <=5)
            return Math.round(price*0.5)/10.0;
        if(level >=6 && level <=10)
            return Math.round(price)/10.0;
        if(level >=11 && level <=15)
            return Math.round(price*1.5)/10.0;
        if(level >=16 && level <=20)
            return Math.round(price*2)/10.0;
        return Math.round(price*2.5)/10.0;
    }

}
