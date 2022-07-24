package com.bitcamp.board;

// 게시글 목록을 관리하는 역
public class BoardList {
  static final int DEFAULT_SIZE = 3;

  int boardCount = 0; 
  Board[] boards;
  int no = 0;

  // 생성자
  BoardList() {
    this.boards = new Board[DEFAULT_SIZE];
  }
  BoardList(int initCapacity) {
    this.boards = new Board[initCapacity];
  }

  // 목록에 저장된 인스턴스를 꺼내서 리턴한다.
  Board[] toArray() {
    Board[] arr = new Board[boardCount];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = this.boards[i];
    }
    return arr;
  }

  Board get(int boardNo) {
    for (int i = 0; i < this.boardCount; i++) {
      if (this.boards[i].no == boardNo) {
        return this.boards[i];
      }
    }
    return null;
  }

  // Board 인스턴스를 배열에 저장한다.
  void add(Board board) {
    if (this.boardCount == this.boards.length) {
      grow();
    }

    board.no = nextNo();
    this.boards[this.boardCount++] = board;
  }

  boolean remove(int boardNo) {
    int boardIndex = -1;
    for (int i = 0; i < this.boardCount; i++) {
      if (this.boards[i].no == boardNo) {
        boardIndex = i;
        break;
      }
    }
    if (boardIndex == -1) {
      return false;
    }
    // 삭제할 항목의 다음 항목을 앞으로 당긴다.
    for (int i = boardIndex + 1; i < this.boardCount; i++ ) {
      this.boards[i - 1] = this.boards[i]; 
      //i - 1 -> 삭제할 게시글 주소, i = 삭제할 게시글 주소 다음 게시글
    }

    // 게시글 개수를 한 개 줄인 
    // 맨 뒤에 있던 항목의 주소를 0으로 설정한다.
    this.boards[--boardCount] = null;

    return true;
  }

  //------------------------------------------------------------------------------------//
  void grow() {
    int newSize = this.boards.length + (this.boards.length >> 1); // >> 1 = 나누기 2
    Board[] newArray = new Board[newSize];
    for (int i = 0; i < this.boards.length; i++) {
      newArray[i] = this.boards[i];
    }
    this.boards = newArray;
  }

  int nextNo() {
    return ++no;
  }
}
