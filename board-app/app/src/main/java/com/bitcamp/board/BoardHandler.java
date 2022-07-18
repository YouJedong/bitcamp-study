/*
 * 게시판 메뉴 처리 클래스 
 * 비트캠프-20220704
 */
package com.bitcamp.board;

public class BoardHandler {

  static int boardCount = 0; // 저장된 게시글의 개수

  static final int SIZE = 3; 

  static Board[] boards = new Board[SIZE];

  static void processList() {  

    java.text.SimpleDateFormat formatter = 
        new java.text.SimpleDateFormat("yyyy-MM-dd"); //인스턴스 메서드

    System.out.println("[게시글 목록]");
    System.out.println("번호\t제목\t조회수\t작성자\t등록일");

    //날짜 정보에서 값을 추출하여 특정 포맷의 문자열로 만들어줄 도구를 준비

    for (int i = 0; i < boardCount; i++) {
      Board board = boards[i];
      // 밀리초 데이터를 Date 도구함으로 날짜 정보 설정
      java.util.Date date = new java.util.Date(board.createdDate);

      //날짜를 "yyyy-MM-dd" 형식 문자열로 바꿈
      String dateStr = formatter.format(date); 

      System.out.printf("%d\t%s\t%d\t%s\t%s\n", 
          board.no, board.title, board.viewCount, board.writer, dateStr);

    }
  }
  static void processDetail() {
    System.out.println("[게시글 상세보기]");

    int boardNo = Prompt.inputInt("조회할 게시글 번호?");

    //해당 번호의 게시글이 몇 번 배열에 들어 있는지 알아내기
    Board board = null; 
    for (int i = 0; i < boardCount; i++) {
      if (boards[i].no == boardNo) {
        board = boards[i];
        break;

      }
    }
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
    java.util.Date date = new java.util.Date(board.createdDate);
    System.out.printf("등록일: %tY-%1$tm-%1$td %1$tH:%1$tM\n", date); 

  }
  static void processInput() {
    System.out.println("[게시글 등록]");

    if (boardCount == SIZE) {
      System.out.println("게시글을 더이상 저장할 수 없습니다.");
      return;

    }

    Board board = new Board();

    board.title = Prompt.inputString("\n제목? ");
    board.content = Prompt.inputString("\n내용? ");  
    board.writer = Prompt.inputString("\n작성자? "); 
    board.password = Prompt.inputString("\n암호? ");

    board.no = boardCount == 0 ? 1 : boards[boardCount - 1].no + 1;
    board.viewCount = 0;
    board.createdDate = System.currentTimeMillis(); 

    // 새로 만든 인스턴스 주소를 레퍼런스 주소에 저장한다.
    boards[boardCount] = board; 

    // Board 

    boardCount++;

    System.out.println("");

  }

  static void processDelate() {
    System.out.println("[게시글 삭제]");

    int boardNo = Prompt.inputInt("삭제할 게시글 번호?");

    int boardIndex = -1;
    for (int i = 0; i < boardCount; i++) {
      if (boards[i].no == boardNo) {
        boardIndex = i;
        break;

      }
    }
    // 사용자가 입력한 번호에 해당하는 게시글을 못 찾았다면
    if (boardIndex == -1) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }
    for (int i = boardIndex + 1; i < boardCount; i++ ) {
      boards[i - 1] = boards[i]; 
      //i - 1 -> 삭제할 게시글 주소, i = 삭제할 게시글 주소 다음 게시글
    }
    boards[--boardCount] = null;

    System.out.println("게시글이 삭제됐습니다!");

  }
  public static void proceseUpdate() {
    System.out.println("[게시글 변경]");

    int boardNo = Prompt.inputInt("변경할 게시글 번호?");

    //해당 번호의 게시글이 몇 번 배열에 들어 있는지 알아내기
    Board board = null; 
    for (int i = 0; i < boardCount; i++) {
      if (boards[i].no == boardNo) {
        board = boards[i];
        break;

      }
    }
    // 사용자가 입력한 번호에 해당하는 게시글을 못 찾았다면
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