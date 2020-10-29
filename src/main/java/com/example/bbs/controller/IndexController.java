package com.example.bbs.controller;

import com.example.bbs.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class  IndexController {
    @Autowired
    MemberService memberService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/join")
    public String join(){
        return  "join";
    }

    @GetMapping("/")
    public String back(Model model){
        model.addAttribute("memberList", memberService.memberList());
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "index";
    }

    @GetMapping("/write")
    public String write(HttpSession httpSession){
        httpSession.getAttribute("user");
        return "write";
    }
}
