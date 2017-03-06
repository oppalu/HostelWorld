package com.phoebe.dao;

import com.phoebe.model.Bankaccount;
import com.phoebe.model.Member;
import com.phoebe.model.Membercard;

import java.util.List;

/**
 * Created by phoebegl on 2017/2/27.
 * 负责会员及会员卡管理
 */
public interface MemberDao {

    int addMember(Member m);

    int updateMember(Member m);

    Member findMember(String id);

    Member findMemberByName(String name);

    List<Member> findAllMembers();

    int addBankCard(Bankaccount bankaccount);

    int deleteBankCard(String ownerid);

    int updateBankcard(Bankaccount bankaccount);

    Bankaccount findBank(String ownerid);

    int addMembercard(Membercard card);

    int updateMembercard(Membercard card);

    Membercard findMembercard(String id);

    Membercard findMycard(String ownerid);

}
