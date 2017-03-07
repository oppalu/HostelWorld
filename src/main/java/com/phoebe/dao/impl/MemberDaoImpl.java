package com.phoebe.dao.impl;

import com.phoebe.dao.BaseDao;
import com.phoebe.dao.MemberDao;
import com.phoebe.model.Bankaccount;
import com.phoebe.model.Member;
import com.phoebe.model.Membercard;
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
        String s = "U"+ baseDao.getNum("member");
        m.setId(s);
        return baseDao.save(m);
    }

    public int updateMember(Member m) {
        return baseDao.update(m);
    }

    public Member findMember(String id) {
        return (Member)baseDao.find(Member.class,id);
    }

    public Member findMemberByName(String name) {
        Session session = baseDao.getSession();
        String hql = "from Member where nickname = '"+name+"'";
        return (Member)session.createQuery(hql).uniqueResult();

    }

    public List<Membercard> findAllMembers() {
        return baseDao.findAll(Membercard.class);
    }

    public int addBankCard(Bankaccount bankaccount) {
        int res = baseDao.save(bankaccount);
        if(res == 1) {
            Membercard card = findMycard(bankaccount.getOwnerid());
            card.setBankAccount(bankaccount.getAccount());
            updateMembercard(card);
        }
        return res;
    }

    public int deleteBankCard(String ownerid) {
        int res = baseDao.delete(Bankaccount.class,ownerid);
        if(res == 1) {
            Membercard card = findMycard(ownerid);
            card.setBankAccount("");
            updateMembercard(card);
        }
        return res;
    }

    public int updateBankcard(Bankaccount bankaccount) {
        return baseDao.update(bankaccount);
    }

    public Bankaccount findBank(String ownerid) {
        return (Bankaccount)baseDao.find(Bankaccount.class,ownerid);
    }

    public int addMembercard(Membercard card) {
        String s = "V"+ baseDao.getNum("membercard");
        card.setId(s);
        return baseDao.save(card);
    }

    public int updateMembercard(Membercard card) {
        return baseDao.update(card);
    }

    public Membercard findMembercard(String id) {
        return (Membercard)baseDao.find(Membercard.class,id);
    }

    public Membercard findMycard(String ownerid) {
        Session session = baseDao.getSession();
        String hql = "from Membercard where memberid = '"+ownerid+"'";
        return (Membercard)session.createQuery(hql).uniqueResult();

    }
}
