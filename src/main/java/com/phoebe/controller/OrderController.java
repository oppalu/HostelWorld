package com.phoebe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by phoebegl on 2017/3/3.
 * 对订单的管理
 */
@Controller
public class OrderController {

    @RequestMapping("/")
    public String index() {
        return "/customer/index";
    }
}
