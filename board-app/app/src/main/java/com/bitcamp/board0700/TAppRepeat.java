/*
 * 게시판 관리 애플리케이션
 * 비트캠프-20220704
 */
package com.bitcamp.board0700;

public class TAppRepeat {



  static java.text.SimpleDateFormat milliToTime = new java.text.SimpleDateFormat("yy-MM-dd");

  public static void main(String[] args) {
    welcome();

    loop: while (true) {
      viewMenu();
      int menuNo = promptMenu();
      viewline();

      switch (menuNo) {
        case 0: break loop;
        case 1: TBoardRepeat.processList(); break;
        case 2: TBoardRepeat.processDetail(); break;
        case 3: TBoardRepeat.processAdd(); break;
        default: System.out.println("메뉴 번호가 옳지 않습니다!");
      }

      viewBrankLine();
    } // while

    System.out.println("안녕히 가세요!");
    TBoardRepeat.keyboardInput.close();
  } 
  //-----------------------------------------------------------------main

  static int promptMenu() {
    String strToInt = TBoardRepeat.keyboardInput.nextLine();
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

  static void viewBrankLine() {
    System.out.println();
  }
}



