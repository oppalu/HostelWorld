package com.phoebe.controller;

import com.phoebe.model.Manager;
import com.phoebe.model.Member;
import com.phoebe.service.ManagerService;
import com.phoebe.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by phoebegl on 2017/3/3.
 */
@Controller
//@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService manager;


}
