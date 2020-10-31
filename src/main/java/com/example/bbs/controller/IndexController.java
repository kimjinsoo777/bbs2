package com.example.bbs.controller;

import com.example.bbs.service.BoardService;
import com.example.bbs.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
public class  IndexController {
    @Autowired
    MemberService memberService;
    @Autowired
    BoardService boardService;

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
        model.addAttribute("boardList", boardService.boardList());
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

    @GetMapping("/select/{bno}")
    public String update(HttpSession httpSession, @PathVariable long bno,Model model){
        model.addAttribute("select",boardService.select(bno));
        boardService.count(bno);
        model.addAttribute("replyList",boardService.replyList(bno));
        httpSession.getAttribute("user");
        return "update";
    }
}
