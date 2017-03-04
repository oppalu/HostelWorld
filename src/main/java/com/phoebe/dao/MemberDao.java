package com.phoebe.dao;

import com.phoebe.model.Member;
import com.phoebe.model.Number;

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

}
