package com.phoebe.dao.impl;

import com.phoebe.dao.BaseDao;
import com.phoebe.dao.MemberDao;
import com.phoebe.model.Member;
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
        String hql = "from Member where nickname ="+name;
        return (Member)session.createQuery(hql).uniqueResult();

    }

    public List<Member> findAllMembers() {
        return baseDao.findAll(Member.class);
    }
}
