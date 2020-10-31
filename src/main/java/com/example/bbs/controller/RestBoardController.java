package com.example.bbs.controller;

import com.example.bbs.domain.Board;
import com.example.bbs.domain.Reply;
import com.example.bbs.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestBoardController {
    @Autowired
    BoardService boardService;

    @PostMapping("/rest/write")
    public void write(Board board){
        boardService.write(board);
    }

    @PutMapping("/rest/update")
    public void update(Board board){
        boardService.update(board);
    }

    @DeleteMapping("/rest/delete")
    public void delete(Board board){
        boardService.delete(board);
    }
    @PutMapping("/rest/reco")
    public void reco(long bno){
        boardService.reco(bno);
    }

    @PostMapping("/rest/reply")
    public void reply(Reply reply){
        boardService.reply(reply);
    }

}
