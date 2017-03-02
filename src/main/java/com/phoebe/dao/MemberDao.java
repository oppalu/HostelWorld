package com.phoebe.dao;

import java.util.List;

/**
 * Created by phoebegl on 2017/2/27.
 * 负责会员及会员卡管理
 */
public interface MemberDao {

    int addMember(Member m);

    int deleteMember(String id);

    int updateMember(Member m);

    Member findMember(String id);

    List<Member> findAllMembers();

    int addMemberCard(Membercard card);

    int updateMemberCard(Membercard card);

    Membercard findCard(String id);

    int addBankAccount(Bankaccount b);

    int deleteBankAccount(String id);

    int updateBankAccount(Bankaccount b);

    Bankaccount findBankAccount(String ownerid);
}
