package com.example.bbs.mapper;

import com.example.bbs.domain.Board;
import com.example.bbs.domain.Reply;

import java.util.ArrayList;

public interface BoardMapper {
    void write(Board board); //글쓰기
    ArrayList<Board> boardList(); //글목록
    void update(Board board); //글수정
    void delete(Board board); //글삭제
    Board select(long bno); //해당글 불러오기
    void count(long bno); //조회수
    void reco(long bno); //추천수
    void reply(Reply reply);
    ArrayList<Reply> replyList(long bno); //댓글 리스트
}
