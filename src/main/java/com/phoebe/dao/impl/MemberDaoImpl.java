package com.phoebe.dao.impl;

import com.phoebe.dao.BaseDao;
import com.phoebe.dao.MemberDao;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by phoebegl on 2017/2/27.
 */
@Repository
public class MemberDaoImpl implements MemberDao {

    @Autowired
    private BaseDao baseDao;

    public int addMember(Member m) {
        return baseDao.save(m);
    }

    public int deleteMember(String id) {
        return baseDao.delete(Member.class,id);
    }

    public int updateMember(Member m) {
        return baseDao.update(m);
    }

    public Member findMember(String id) {
        return (Member)baseDao.find(Member.class,id);
    }

    public List<Member> findAllMembers() {
        return baseDao.findAll(Member.class);
    }

    public int addMemberCard(Membercard card) {
        return baseDao.save(card);
    }

    public int updateMemberCard(Membercard card) {
        return baseDao.update(card);
    }

    public Membercard findCard(String id) {
        return (Membercard)baseDao.find(Membercard.class,id);
    }

    public int addBankAccount(Bankaccount b) {
        return baseDao.save(b);
    }

    public int deleteBankAccount(String id) {
        return baseDao.delete(Bankaccount.class,id);
    }

    public int updateBankAccount(Bankaccount b) {
        return baseDao.update(b);
    }

    public Bankaccount findBankAccount(String ownerid) {
        Session session = baseDao.getSession();
        String hql = "from Bankaccount where ownerid = "+ownerid;
        return (Bankaccount)session.createQuery(hql).uniqueResult();
    }
}
