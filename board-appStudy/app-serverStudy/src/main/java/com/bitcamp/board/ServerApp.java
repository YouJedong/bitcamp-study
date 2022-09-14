package com.bitcamp.board;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Stack;
import com.bitcamp.board.handler.BoardHandler;
import com.bitcamp.board.handler.MemberHandler;
import com.bitcamp.handler.Handler;
import com.bitcamp.util.BreadCrumb;

public class ServerApp {

  public static Stack<String> breadcrumbMenu = new Stack<>();

  static String[] menus = {"게시판", "회원"};

  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(8888);) {
      System.out.println("서버 실행 중..");

      // 핸들러를 담을 컬렉션을 준비한다.
      ArrayList<Handler> handlers = new ArrayList<>();
      handlers.add(new BoardHandler(null));
      handlers.add(new MemberHandler(null));

      while (true) {
        Socket socket = serverSocket.accept();

        new Thread(() -> {
          try (
              DataOutputStream out = new DataOutputStream(socket.getOutputStream());
              DataInputStream in = new DataInputStream(socket.getInputStream())) {
            System.out.println("클라이언트 접속");

            BreadCrumb breadCrumb = new BreadCrumb();
            breadCrumb.put("메인");

            boolean first = true;
            String errorMessage = null;

            while (true) {

              try (StringWriter strOut = new StringWriter();
                  PrintWriter tempOut = new PrintWriter(strOut);) {

                if (first) {
                  welcome(tempOut);
                  first = false;
                }
                if (errorMessage != null) {
                  tempOut.println(errorMessage);
                  errorMessage = null;
                }

                tempOut.println(breadCrumb.toString());
                printMainMenus(tempOut);
                out.writeUTF(strOut.toString());
              }

              String request = in.readUTF();
              if (request.equals("quit")) {
                break;
              }

              try {
                int mainMenuNo = Integer.parseInt(request);

                if (mainMenuNo >= 1 && mainMenuNo <= menus.length ) {
                  breadCrumb.put(menus[mainMenuNo - 1]);

                  handlers.get(mainMenuNo - 1).execute(in, out);

                  breadCrumb.pickUp();

                } else {
                  throw new Exception("해당 번호의 메뉴가 없습니다.");
                }
              } catch (Exception e) {
                errorMessage = String.format("실행오류: %s", e.getMessage());
              }
            }
            System.out.println("클라이언트에 접속 종료!");

          } catch (Exception e) {
            System.out.println("클라이언트 통신하는 중 오류 발생!");
            e.printStackTrace();
          }
        }).start(); 

      }

    } catch (Exception e) {
      System.out.println("서버 실행 중 오류 발생!");
      e.printStackTrace();
    }

  }
  /*
  public static void main2(String[] args) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb","study","1111")){

      System.out.println("[게시글 관리 클라이언트]");

      welcome();

      BoardDao boardDao = new MariaDBBoardDao(con);
      MemberDao memberDao = new MariaDBMemberDao(con);



      // "메인" 메뉴의 이름을 스택에 등록한다.
      breadcrumbMenu.push("메인");



      loop: while (true) {

        printTitle();
        printMainMenus(menus);
        System.out.println();

        try {


          if (mainMenuNo < 0 || mainMenuNo > menus.length) {
            System.out.println("메뉴 번호가 옳지 않습니다!");
            continue; // while 문의 조건 검사로 보낸다.

          } else if (mainMenuNo == 0) {
            break loop;
          }

          // 메뉴에 진입할 때 breadcrumb 메뉴바에 그 메뉴를 등록한다.
          breadcrumbMenu.push(menus[mainMenuNo - 1]);



          breadcrumbMenu.pop();

        } catch (Exception ex) {
          System.out.println("입력 값이 옳지 않습니다.");
        }


      } // while
      Prompt.close();

      System.out.println("연결을 끊었음!");


      System.out.println("종료!");
    } catch (Exception e) {
      System.out.println("시스템오류 발생!");
      e.getStackTrace();
    }
  }
   */
  static void welcome(PrintWriter out) throws Exception {
    out.println("[게시판 애플리케이션]");
    out.println();
    out.println("환영합니다!");
    out.println();
  }

  static void printMainMenus(PrintWriter out) {
    for (int i = 0; i < menus.length; i++) {
      out.printf("  %d: %s\n", i + 1, menus[i]);
    }
    out.printf("메뉴를 선택하세요[1..%d](quit: 종료) ", menus.length);
  }

  protected static void printTitle() {
    StringBuilder builder = new StringBuilder();
    for (String title : breadcrumbMenu) {
      if (!builder.isEmpty()) {
        builder.append(" > ");
      }
      builder.append(title);
    }
    System.out.printf("%s:\n", builder.toString());
  }
}
