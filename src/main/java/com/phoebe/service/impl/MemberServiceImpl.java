package com.phoebe.service.impl;

import com.phoebe.dao.MemberDao;
import com.phoebe.model.Member;
import com.phoebe.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
