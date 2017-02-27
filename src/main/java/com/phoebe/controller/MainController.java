package com.phoebe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by phoebegl on 2017/2/25.
 */
@Controller
public class MainController {

//    @Autowired


    @RequestMapping("/")
    public String index() {
        return null;
    }

    @RequestMapping("/test")
    @ResponseBody
    public void aaa() {

    }

}
