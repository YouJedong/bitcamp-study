/*
 * 게시판 메뉴 처리 클래스 
 * 비트캠프-20220704
 */
package com.bitcamp.board;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardHandler {

  String title;

  BoardList boardList = new BoardList();

  BoardHandler() {
    this.title = "게시판";
  }
  BoardHandler(String title) {
    this.title = title;
  }

  void execute() {
    // App 클래스에서 이 메서드를 호출할 때 BoardHandler의 인스턴스 주소를 줄 것이다.
    // 그 주소는 this 라는 내장 변수에 보관된다.
    while (true) {
      System.out.printf("[%s]:\n", this.title);
      System.out.println("  1: 목록");
      System.out.println("  2: 상세보기");
      System.out.println("  3: 등록");
      System.out.println("  4: 삭제");
      System.out.println("  5: 변경");
      System.out.println();

      int menuNo = Prompt.inputInt("메뉴를 선택하세요[1..5](0: 이전) ");
      displayHeadLine();

      // 다른 인스턴스 메서드를 호출할 때 this에 보관된 인스턴스 주소를 사용한다.
      switch (menuNo) {
        case 0: return;
        case 1: this.onList(); break;  
        case 2: this.onDetail(); break;
        case 3: this.onInput(); break;
        case 4: this.onDelate(); break;
        case 5: this.onUpdate(); break;
        default: System.out.println("메뉴 번호가 옳지 않습니다!");
      } 

      displayBlankLine();
    }// 게시판 while
  }

  static void displayHeadLine() {
    System.out.println("--------------------------------------------------");
  }

  static void displayBlankLine() {
    System.out.println();
  }

  void onList() {  
    SimpleDateFormat formatter = 
        new SimpleDateFormat("yyyy-MM-dd"); //인스턴스 메서드

    System.out.printf("[%n 목록]\n", this.title);
    System.out.println("번호\t제목\t조회수\t작성자\t등록일");

    // boardList 인스턴스에 들어 있는 데이터 목록을 가져온다.
    Board[] list = this.boardList.toArray();

    for (Board board : list) {
      Date date = new Date(board.createdDate);
      String dateStr = formatter.format(date); 
      System.out.printf("%d\t%s\t%d\t%s\t%s\n", 
          board.no, board.title, board.viewCount, board.writer, dateStr);
    }

  }
  void onDetail() {
    System.out.printf("[%n 상세보기]\n", this.title);

    int boardNo = Prompt.inputInt("조회할 게시글 번호?");

    //해당 번호의 게시글이 몇 번 배열에 들어 있는지 알아내기
    Board board = this.boardList.get(boardNo);

    // 사용자가 입력한 번호에 해당하는 게시글을 못 찾았다면
    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }

    System.out.printf("번호: %d\n", board.no);
    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("조회수: %d\n", board.viewCount);
    System.out.printf("작성자: %s\n", board.writer);
    Date date = new Date(board.createdDate);
    System.out.printf("등록일: %tY-%1$tm-%1$td %1$tH:%1$tM\n", date); 

  }
  void onInput() {
    System.out.printf("[%s 등록]\n", this.title);

    Board board = new Board();

    board.title = Prompt.inputString("\n제목? ");
    board.content = Prompt.inputString("\n내용? ");  
    board.writer = Prompt.inputString("\n작성자? "); 
    board.password = Prompt.inputString("\n암호? ");
    board.viewCount = 0;
    board.createdDate = System.currentTimeMillis(); 

    this.boardList.add(board); 

    System.out.println("");

  }

  void onDelate() {
    System.out.printf("[%s 삭제]\n", this.title);

    int boardNo = Prompt.inputInt("삭제할 게시글 번호?");

    // 사용자가 입력한 번호에 해당하는 게시글을 못 찾았다면
    if (boardList.remove(boardNo)) {
      System.out.println("게시글이 삭제됐습니다!");
    } else {
      System.out.println("해당 번호의 게시글이 없습니다!");
    }

  }
  void onUpdate() {
    System.out.printf("[%s 변경]\n", this.title);

    int boardNo = Prompt.inputInt("변경할 게시글 번호?");

    Board board = this.boardList.get(boardNo);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }

    String newTitle = Prompt.inputString("제목? (" + board.title + ")");
    String newContent = Prompt.inputString("내용? (" + board.content + ")");

    while (true) {
      char yesORno = Prompt.inputStringToChar("변경하시겠습니까?(y/n)");
      if (yesORno == 'y') {
        System.out.print("변경되었습니다.");
        board.title = newTitle;
        board.content = newContent;
        break;

      } else if (yesORno == 'n') {
        System.out.print("변경이 취소되었습니다.");
        break;

      } else {
        System.out.println("잘못 입력했습니다. 다시 입력해주세요.(y/n)");
      }
    }
  }
}  