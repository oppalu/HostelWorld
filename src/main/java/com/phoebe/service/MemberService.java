package com.phoebe.service;

import com.phoebe.model.Member;
import com.phoebe.model.Number;

/**
 * Created by phoebegl on 2017/3/3.
 */
public interface MemberService {

    Member login(String username);

    int register(Member m);
}
