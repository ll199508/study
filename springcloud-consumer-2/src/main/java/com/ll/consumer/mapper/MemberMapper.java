package com.ll.consumer.mapper;

import com.ll.consumer.entities.Member;
import com.ll.consumer.entities.MemberExample;

import java.util.List;

public interface MemberMapper {
    public int insert(Member member);
    public List<Member> selectByExample(MemberExample memberExample);
}
