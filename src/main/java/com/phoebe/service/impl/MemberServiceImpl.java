package com.phoebe.service.impl;

import com.phoebe.controller.common.DateFormater;
import com.phoebe.dao.MemberDao;
import com.phoebe.model.Bankaccount;
import com.phoebe.model.Member;
import com.phoebe.model.Membercard;
import com.phoebe.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by phoebegl on 2017/3/3.
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao dao;

    public Member login(String username) {
        return dao.findMemberByName(username);
    }

    public int register(Member m) {
        return dao.addMember(m);
    }

    public Member findUserById(String id) {
        return dao.findMember(id);
    }

    public int updateUser(Member m) {
        return dao.updateMember(m);
    }

    public int addBankCard(Bankaccount bankaccount) {
        return dao.addBankCard(bankaccount);
    }

    public int deleteBankCard(String ownerid) {
        return dao.deleteBankCard(ownerid);
    }

    public Bankaccount findBank(String ownerid) {
        return dao.findBank(ownerid);
    }

    public int updateBankAccount(Bankaccount bankaccount) {
        return dao.updateBankcard(bankaccount);
    }

    public int addMembercard(String memberid) {
        Membercard card = new Membercard();
        card.setMemberid(memberid);
        card.setBalance(0.0);
        card.setState("未激活");
        card.setStatetime(DateFormater.getFutureDate());
        card.setLevel(0);
        card.setPoint(0.0);
        card.setTotalpoint(0.0);
        return dao.addMembercard(card);
    }

    public int updateMembercard(Membercard card) {
        return dao.updateMembercard(card);
    }

    public Membercard findMembercard(String id) {
        return dao.findMembercard(id);
    }

    public Membercard findMycard(String ownerid) {
        return dao.findMycard(ownerid);
    }

    public int charge(String memberid, double money) {
        Bankaccount bankaccount = findBank(memberid);
        if(bankaccount.getBalance() < money)
            return 0;
        bankaccount.setBalance(bankaccount.getBalance()-money);
        dao.updateBankcard(bankaccount);

        Membercard membercard = findMycard(memberid);
        if((membercard.getState().equals("未激活") && money>=1000) || membercard.getState().equals("已暂停")){
            membercard.setState("已激活");
            membercard.setStatetime(DateFormater.getFutureDate());
        }
        membercard.setBalance(membercard.getBalance()+money);
        return updateMembercard(membercard);
    }

    public int changePoint(String id, double point) {
        Membercard membercard = findMembercard(id);
        double money = membercard.getBalance() + (point/100);
        membercard.setBalance(money);
        membercard.setPoint(membercard.getPoint()-point);
        return updateMembercard(membercard);
    }

    public int findMemberNum() {
        return dao.findAllMembers().size();
    }

    public List analyseMember() {
        return dao.analyseMember();
    }

    @Scheduled(cron = "0 0 12 * * ?")
    public void manageState() {
        List<Membercard> members = dao.findAllMembers();
        for(Membercard m : members) {
            if(m.getStatetime().toString().equals(DateFormater.getCurrentDate().toString())) {
                if(m.getState().equals("已暂停"))
                    m.setState("已停止");
                if(m.getState().equals("已激活")&&m.getBalance()<1000)
                    m.setState("已暂停");
                updateMembercard(m);
            }
        }
    }
}
