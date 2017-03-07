package com.phoebe.service;

import com.phoebe.model.Bankaccount;
import com.phoebe.model.Member;
import com.phoebe.model.Membercard;

import java.util.List;

/**
 * Created by phoebegl on 2017/3/3.
 */
public interface MemberService {

    Member login(String username);

    int register(Member m);

    Member findUserById(String id);

    int updateUser(Member m);

    int addBankCard(Bankaccount bankaccount);

    int deleteBankCard(String ownerid);

    Bankaccount findBank(String ownerid);

    int addMembercard(String memberid);

    int updateMembercard(Membercard card);

    Membercard findMembercard(String id);

    Membercard findMycard(String ownerid);

    int charge(String memberid,double money);

    void manageState();
}
