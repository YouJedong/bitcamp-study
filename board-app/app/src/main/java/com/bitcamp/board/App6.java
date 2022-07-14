/*
 * 게시판 관리 애플리케이션 7/14일 자습 중 게시판 만들기
 * 비트캠프-20220704
 */
package com.bitcamp.board;

public class App6 {

  static int boardCount = 0; // 저장된 게시글의 개수

  static final int SIZE = 3;

  static int[] no = new int[SIZE];
  static String[] title = new String[SIZE];
  static String[] content = new String[SIZE];
  static String[] writer = new String[SIZE];
  static String[] password = new String[SIZE];
  static int[] viewCount = new int[SIZE];
  static long[] createdDate = new long[SIZE];

  static java.util.Scanner keyboardInput = new java.util.Scanner(System.in);

  public static void main(String[] args) {
    welcome();
    loop: while (true) {
      displayMenu();
      int menuNo = Prompt6.inputInt();
      displayLine();

      switch(menuNo) {
        case 0: break loop; 
        case 1: BoardHandler6.processList(); break;
        case 2: BoardHandler6.processDetail(); break;
        case 3: BoardHandler6.processInput(); break;
        default: System.out.println("메뉴 번호가 옳지 않습니다!");
      }

      displayBlankLine();
    } // while

    System.out.println("안녕히 가세요!");
    
  }
///////////////////////////////////////////////////////////////////////////main
  static void welcome() {
    System.out.println("[게시판 애플리케이션]");
    System.out.println();
    System.out.println("환영합니다!");
    System.out.println();
  }

  static void displayMenu() {
    displayLine();
    System.out.println("메뉴:");
    System.out.println("  1: 게시글 목록");
    System.out.println("  2: 게시글 상세보기");
    System.out.println("  3: 게시글 등록");
    System.out.println();
    System.out.print("메뉴를 선택하세요[1..3](0: 종료) ");
  }

  static void displayLine() {
    System.out.println("------------------------------------------------------");
  }

  static void displayBlankLine() {
    System.out.println(); // 메뉴를 처리한 후 빈 줄 출력
  }
}
