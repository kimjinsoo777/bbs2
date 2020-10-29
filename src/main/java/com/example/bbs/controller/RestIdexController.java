package com.example.bbs.controller;

import com.example.bbs.domain.Member;
import com.example.bbs.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class RestIdexController {
    @Autowired
    MemberService memberService;

    //회원가입
   @PostMapping("/rest/join")
    public void join(Member member){
        memberService.join(member);
    }

    //로그인
    @PostMapping("/rest/login")
    public Member login(Member member, HttpSession httpSession){
       httpSession.setAttribute("user", memberService.login(member));
       return memberService.login(member);
    }
}
