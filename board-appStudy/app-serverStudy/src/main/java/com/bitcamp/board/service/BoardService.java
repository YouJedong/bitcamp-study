package com.bitcamp.board.service;

import java.util.List;
import com.bitcamp.board.domain.AttachedFile;
import com.bitcamp.board.domain.Board;

public interface BoardService {
  void add(Board board) throws Exception;

  Board get(int no) throws Exception;

  boolean delete(int no) throws Exception;

  AttachedFile getAttachedFile(int no) throws Exception;

  boolean deleteAttachedFile(int no) throws Exception;

  List<Board> list() throws Exception;

  boolean update(Board board) throws Exception;

}
