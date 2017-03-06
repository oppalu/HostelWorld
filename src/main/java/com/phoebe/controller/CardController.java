package com.phoebe.controller;

import com.phoebe.controller.common.HandleError;
import com.phoebe.model.Bankaccount;
import com.phoebe.model.Member;
import com.phoebe.model.Membercard;
import com.phoebe.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by phoebegl on 2017/3/3.
 * 对会员卡的管理
 */
@Controller
@RequestMapping("/card")
public class CardController {

    @Autowired
    private MemberService member;

    @RequestMapping(value = "/bank", method = RequestMethod.GET)
    public ModelAndView bankcardInfo(HttpSession session) {
        Member m = (Member)session.getAttribute("member");
        Bankaccount bankaccount = member.findBank(m.getId());
        return new ModelAndView("customer/bankcard","bank",bankaccount);
    }

    @RequestMapping(value = "/addBankcard",method = RequestMethod.POST)
    public ModelAndView addBank(@RequestParam("n_account") String account,
                                @RequestParam("n_name") String name,
                                @RequestParam("n_balance") String balance,
                                HttpServletRequest request, HttpServletResponse response) {
        Member m = (Member)request.getSession().getAttribute("member");
        Bankaccount bankaccount1 = new Bankaccount();
        bankaccount1.setName(name);
        bankaccount1.setAccount(account);
        bankaccount1.setBalance(Double.parseDouble(balance));
        bankaccount1.setOwnerid(m.getId());
        int res = member.addBankCard(bankaccount1);
        if(res == 1)
            HandleError.handle(request, response, "添加成功");
        else
            HandleError.handle(request, response, "您已绑定了银行卡!");

        return new ModelAndView("customer/bankcard","bank",bankaccount1);
    }

    @RequestMapping(value = "/deleteBankcard",method = RequestMethod.POST)
    public ModelAndView deleteBank(HttpServletRequest request, HttpServletResponse response) {
        Member m = (Member)request.getSession().getAttribute("member");
        int res = member.deleteBankCard(m.getId());
        if(res == 1)
            HandleError.handle(request, response, "删除成功");
        else
            HandleError.handle(request, response, "删除失败");

        return new ModelAndView("customer/bankcard","bank",null);
    }

    @RequestMapping(value = "/mycard", method = RequestMethod.GET)
    public ModelAndView getCard(HttpSession session) {
        Member m = (Member)session.getAttribute("member");
        Membercard card = member.findMycard(m.getId());
        return new ModelAndView("customer/membercard","card",card);
    }

    @RequestMapping(value = "/{cardid}", method = RequestMethod.GET)
    public ModelAndView getCardInfo(@PathVariable String cardid) {
        Membercard card = member.findMembercard(cardid);
        return new ModelAndView("customer/cardinfo","card",card);
    }

    @RequestMapping(value = "/charge",method = RequestMethod.POST)
    public ModelAndView charge(@RequestParam("money") String money,
                               HttpServletRequest request, HttpServletResponse response) {

        Member m = (Member)request.getSession().getAttribute("member");
        int res = member.charge(m.getId(),Double.parseDouble(money));
        if(res == 1)
            HandleError.handle(request, response, "充值成功");
        else
            HandleError.handle(request, response, "充值失败");

        Membercard card = member.findMycard(m.getId());
        return new ModelAndView("customer/membercard","card",card);
    }


    @RequestMapping(value = "/point", method = RequestMethod.GET)
    public String getPoint() {
        return "customer/point";
    }

    @RequestMapping(value = "/changePoint",method = RequestMethod.POST)
    public ModelAndView changePoint(HttpServletRequest request, HttpServletResponse response) {

        Member m = (Member)request.getSession().getAttribute("member");
        int res = member.deleteBankCard(m.getId());
        if(res == 1)
            HandleError.handle(request, response, "删除成功");
        else
            HandleError.handle(request, response, "删除失败");

        return new ModelAndView("customer/bankcard","bank",null);
    }


}
