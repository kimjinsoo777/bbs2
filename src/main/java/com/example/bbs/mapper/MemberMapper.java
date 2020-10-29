package com.example.bbs.mapper;

import com.example.bbs.domain.Member;
import com.example.bbs.domain.MemberList;

import java.util.ArrayList;

public interface MemberMapper {
    void join(Member member);      // 회원가입
    Member login(Member member); //로그인
    ArrayList<MemberList> memberList(); //회원목록
}
