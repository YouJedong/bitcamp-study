/*
 * 게시판 관리 애플리케이션
 * 비트캠프-20220704
 */
package com.bitcamp.board;

public class AppRepeat {

  static final int SIZE = 3;
  static int[] no = new int[SIZE];
  static String[] title = new String[SIZE];
  static String[] content = new String[SIZE];
  static String[] writer = new String[SIZE];
  static String[] password = new String[SIZE];
  static int[] viewCount = new int[SIZE];
  static long[] createdDate = new long[SIZE];
  static int boardCount = 0;

  static java.util.Scanner keyboardInput = new java.util.Scanner(System.in);
  static java.text.SimpleDateFormat milliToTime = new java.text.SimpleDateFormat("yy-MM-dd");

  public static void main(String[] args) {
    welcome();
    while (true) {
      viewMenu();
      int menuNo = promptMenu();
      viewline();


      if (menuNo == 0) {
        break;
      }
      else if (menuNo == 1) {
        processList();  
      }
      else if (menuNo == 2) {
        processDetail();
      } else if (menuNo == 3) {
        processAdd();
      } else {
        System.out.println("메뉴 번호가 옳지 않습니다!");
      }

      System.out.println(); // 메뉴를 처리한 후 빈 줄 출력
    } // while

    System.out.println("안녕히 가세요!");
    keyboardInput.close();
  } 

  //-----------------------------------------------------------------

  private static void processAdd() {
    System.out.println("[게시글 등록]");

    if (boardCount == SIZE) {
      System.out.println("더이상 게시글을 작성할 수 없습니다.");
      return;
    }

    System.out.print("제목? ");
    title[boardCount] = keyboardInput.nextLine();

    System.out.print("내용? ");
    content[boardCount] = keyboardInput.nextLine();

    System.out.print("작성자? "); 
    writer[boardCount] = keyboardInput.nextLine();

    System.out.print("암호? ");
    password[boardCount] = keyboardInput.nextLine();

    no[boardCount] = boardCount == 0 ? 1 : no[boardCount - 1] + 1;
    viewCount[boardCount] = 0;
    createdDate[boardCount] = System.currentTimeMillis();

    boardCount++;

  }
  private static void processDetail() {
    System.out.println("[게시글 상세보기]");

    System.out.print("조회할 번호를 입력해주세요.");

    int findBoardNo = keyboardInput.nextInt();
    keyboardInput.nextLine();

    int boardIndex = -1;
    for (int i = 0; i < boardCount; i++) {
      if(no[i] == findBoardNo) {
        boardIndex = i;
        break;
      }
    }
    if (boardIndex == -1) {
      System.out.println("존재하지 않는 게시글입니다.");
      return;
    }

    System.out.printf("번호: %d\n", no[boardIndex]);
    System.out.printf("제목: %s\n", title[boardIndex]);
    System.out.printf("내용: %s\n", content[boardIndex]);
    System.out.printf("조회수: %d\n", viewCount[boardIndex]);
    System.out.printf("작성자: %s\n", writer[boardIndex]);

    java.util.Date date = new java.util.Date(createdDate[boardIndex]);

    System.out.printf("등록일: %tY-%1$tm-%1$td %1$tH:%1$tM\n", date);
  }



  static void processList() {
    System.out.println("[게시글 목록]");
    System.out.println("번호 제목 조회수 작성자 등록일");


    for (int i = 0; i < boardCount; i++) {
      String date = milliToTime.format(createdDate[i]);
      System.out.printf("%d\t%s\t%d\t%s\t%s\n",
          no[i], title[i], viewCount[i], writer[i], date);

    }
  }
  static int promptMenu() {
    String strToInt = keyboardInput.nextLine();
    int result = Integer.parseInt(strToInt);
    return result;

  }

  static void viewline() {
    System.out.println("-------------------------------------");

  }

  static void viewMenu() {
    System.out.println("메뉴:");
    System.out.println("  1: 게시글 목록");
    System.out.println("  2: 게시글 상세보기");
    System.out.println("  3: 게시글 등록");
    System.out.println();
    System.out.print("메뉴를 선택하세요[1..3](0: 종료) ");

  }

  static void welcome() {
    System.out.println("[게시판 애플리케이션]");
    System.out.println();
    System.out.println("환영합니다!");
    System.out.println();
  }
}



