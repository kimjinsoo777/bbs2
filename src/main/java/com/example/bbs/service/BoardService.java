package com.example.bbs.service;

import com.example.bbs.domain.Board;
import com.example.bbs.domain.Reply;
import com.example.bbs.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BoardService {
    @Autowired(required = false)
    BoardMapper boardMapper;
    //글등록
    public void write(Board board){
        boardMapper.write(board);
    }

    //글목록
    public ArrayList<Board> boardList(){
        return boardMapper.boardList();
    }

    //글수정
    public void update(Board board){
        boardMapper.update(board);
    }

    //글삭제
    public void delete(Board board){
        boardMapper.delete(board);
    }

    //해당글 불러오기
    public Board select(long bno){
        return boardMapper.select(bno);
    }

    //조회수
    public void count(long bno){
        boardMapper.count(bno);
    }

    //추천수
    public void reco(long bno){
        boardMapper.reco(bno);
    }

    //댓글
    public void reply(Reply reply){
        boardMapper.reply(reply);
    }

    //댓글리스트
    public ArrayList<Reply> replyList(long bno){
        return boardMapper.replyList(bno);
    }
}
