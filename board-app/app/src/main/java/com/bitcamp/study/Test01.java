package com.bitcamp.study;

import com.bitcamp.board.domain.Board;
import com.google.gson.Gson;

public class Test01 {
  public static void main(String[] args) {
    Board b = new Board();
    b.no = 100;
    b.title = "제목입니다.";
    b.content = "내용입니다.";
    b.writer = "홍길동";
    b.password = "1111";
    b.viewCount = 11;
    b.createdDate = System.currentTimeMillis();  

    Gson gson = new Gson();

    String json = gson.toJson(b);

    System.out.println(json); 

    Board b2 = gson.fromJson(json, Board.class);
    // Board.class는 확장자가 아님
    // .class는 클래스 정보를 담는 변수
    // 내장변수
    // 일종의 Board설계도 
    System.out.println(b2);

    System.out.println(b == b2);
  }

}
