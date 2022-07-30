package com.bitcamp.board.dao;

import com.bitcamp.board.domain.Board;
import com.bitcamp.util.ObjectList;

public class BoardList extends ObjectList {

  private int boardNo = 0;

  @Override
  public void add(Object e) {
    Board board = (Board) e;
    board.no = nextNo();
    super.add(e);
  }

  @Override
  public Board get(int boardNo) {
    for (int i = 0; i < size(); i++) {
      Board board = (Board)super.get(i);
      if (board.no == boardNo) {
        return board;
      }
    }
    return null;
  }

  @Override
  public boolean remove(int boardNo) {
    for (int i = 0; i < size(); i++) {
      Board board = (Board) super.get(i);
      if (board.no == boardNo) {
        super.remove(i);
        return true;
      }
    }
    return false;
  }


  private int nextNo() {
    return ++boardNo;
  }
}














