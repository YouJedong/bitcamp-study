package com.bitcamp.dao;

import java.util.List;
import com.bitcamp.board.domain.Board;

// 게시글 목록을 관리하는 역할
//
public interface BoardDao {

  int insert(Board board) throws Exception;

  int update(Board board) throws Exception;

  Board findByNo(int no) throws Exception;

  int delete(int no) throws Exception;

  List<Board> findAll() throws Exception;
}













