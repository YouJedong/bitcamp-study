/*
 * 게시판 관리 애플리케이션
 * 비트캠프-20220704
 */
package com.bitcamp.board;

import com.bitcamp.board.handler.BoardHandler;
import com.bitcamp.board.handler.MemberHandler;
import com.bitcamp.handler.Handler;
import com.bitcamp.util.Prompt;
import com.bitcamp.util.Stack;

public class App {

  public static Stack breadcrumMenu = new Stack();

  public static void main(String[] args) {
    welcome();

    Handler[] handlers = new Handler[] {
        new BoardHandler(), // 게시판
        new BoardHandler(), // 독서록
        new BoardHandler(), // 방명록
        new BoardHandler(), // 공지사항
        new BoardHandler(), // 일기장
        new MemberHandler() // 회원
    };

    breadcrumMenu.push("메인");

    String[] menus = {"게시판", "독서록", "방명록", "공지사항", "일기장", "회원"};

    loop: while (true) {

      System.out.printf("%s:\n", breadcrumMenu);

      printMenus(menus);

      System.out.println();

      try {
        int mainMenuNo = Prompt.inputInt("메뉴를 선택하세요[1..6](0: 종료) ");

        if (mainMenuNo < 0 || mainMenuNo > menus.length) {
          System.out.println("메뉴 번호가 옳지 않습니다!");
          continue;
        } else if (mainMenuNo == 0) {
          break loop;
        }

        breadcrumMenu.push(menus[mainMenuNo - 1]);

        handlers[mainMenuNo - 1].execute();

        breadcrumMenu.pop();

      } catch (Exception ex) {
        System.out.println("입력 값이 옳지 않습니다.");
      }


    } // while

    System.out.println("안녕히 가세요!");
    Prompt.close();
  } // main

  static void welcome() {
    System.out.println("[게시판 애플리케이션]");
    System.out.println();
    System.out.println("환영합니다!");
    System.out.println();
  }

  static void printMenus(String[] menus) {
    for (int i = 0; i < menus.length; i++) {
      System.out.printf("  %d: %s\n", i + 1, menus[i]);
    }
  }
}








