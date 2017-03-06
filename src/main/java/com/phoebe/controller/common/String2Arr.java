package com.phoebe.controller.common;

import java.util.Arrays;
import java.util.List;

/**
 * Created by phoebegl on 2017/3/6.
 */
public class String2Arr {

    public static List<String> transfer(String s) {
        String[] temp = s.split(",");
        return Arrays.asList(temp);
    }
}
