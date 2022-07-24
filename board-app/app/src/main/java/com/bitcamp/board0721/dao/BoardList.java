package com.bitcamp.board0721.dao;

import com.bitcamp.board0721.domain.Board;

public class BoardList extends ObjectList{

  private int no = 0;


  @Override
  public Board get(int boardNo) {
    for (int i = 0; i < this.length; i++) {
      Board board = (Board) this.list[i];
      if (board.no == boardNo) {
        return board;
      }
    }
    return null;
  }

  @Override
  public void add(Object obj) {
    Board board = (Board) obj;
    board.no = nextNo();

    super.add(board);
  }

  @Override
  public boolean remove(int boardNo) {
    int boardIndex = -1;
    for (int i = 0; i < this.length; i++) {
      Board board = (Board) this.list[i];
      if (board.no == boardNo) {
        boardIndex = i;
        break;
      }
    }
    return super.remove(boardIndex);
  }



  private int nextNo() {
    return ++no;
  }
}
