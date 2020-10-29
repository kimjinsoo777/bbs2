package com.example.bbs.service;

import com.example.bbs.domain.Member;
import com.example.bbs.domain.MemberList;
import com.example.bbs.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MemberService {
    @Autowired(required = false)
    MemberMapper memberMapper;

    //회원가입
    public void join(Member member){
        memberMapper.join(member);
    }

    //로그인
    public Member login(Member member){
        return memberMapper.login(member);
    }

    //회원목록
    public ArrayList<MemberList> memberList(){
        return memberMapper.memberList();
    }
}
