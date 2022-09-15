package com.bitcamp.board;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import com.bitcamp.board.handler.BoardHandler;
import com.bitcamp.board.handler.MemberHandler;
import com.bitcamp.handler.Handler;
import com.bitcamp.util.BreadCrumb;

public class ServerApp {

  private String[] menus = {"게시판", "회원"};
  private int port;
  ArrayList<Handler> handlers = new ArrayList<>();

  public ServerApp(int port) throws Exception {
    this.port = port;
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb","study","1111")){

      handlers.add(new BoardHandler(con));
      handlers.add(new MemberHandler(null));
    }
  }

  public static void main(String[] args) {
    try {
      ServerApp app = new ServerApp(8888);
      app.execute();

    } catch (Exception e) {
      System.out.println("서버 실행 오류!");
    }
  }

  public void execute()  {
    try (ServerSocket serverSocket = new ServerSocket(this.port);) {
      System.out.println("서버 실행 중..");

      while (true) {
        new Thread(new ServiceProccesor(serverSocket.accept())).start();
        System.out.println("클라이언트 접속");
      } 
      //      System.out.println("서버 종료");
    } catch (Exception e) {
      System.out.println("서버 실행 중 오류 발생!");
      e.printStackTrace();
    }
  }
  /*
  public static void main2(String[] args) {

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
  static void welcome(DataOutputStream out) throws Exception {
    try (StringWriter strOut = new StringWriter();
        PrintWriter tempOut = new PrintWriter(strOut);) {
      tempOut.println("[게시판 애플리케이션]");
      tempOut.println();
      tempOut.println("환영합니다!");
      tempOut.println();
      out.writeUTF(strOut.toString());
    }
  }

  static void error(DataOutputStream out, Exception e) {
    try (StringWriter strOut = new StringWriter();
        PrintWriter tempOut = new PrintWriter(strOut);) {
      tempOut.printf("실행오류 :&s\n", e.getMessage());

      out.writeUTF(strOut.toString());
    } catch (Exception e2) {
      e2.printStackTrace();
    }
  }

  void printMainMenus(DataOutputStream out) throws Exception {
    try (StringWriter strOut = new StringWriter();
        PrintWriter tempOut = new PrintWriter(strOut);) {
      tempOut.println(BreadCrumb.getBreadCrumbOfCurrentThread().toString());

      for (int i = 0; i < menus.length; i++) {
        tempOut.printf("  %d: %s\n", i + 1, menus[i]);
      }
      tempOut.printf("메뉴를 선택하세요[1..%d](quit: 종료) ", menus.length);
      out.writeUTF(strOut.toString());
    }
  }



  private class ServiceProccesor implements Runnable {
    Socket socket;

    public ServiceProccesor(Socket socket) {
      this.socket = socket;
    }
    @Override
    public void run() {
      try (Socket s = this.socket;
          DataOutputStream out = new DataOutputStream(s.getOutputStream());
          DataInputStream in = new DataInputStream(s.getInputStream())) {

        BreadCrumb breadCrumb = new BreadCrumb();
        breadCrumb.put("메인");

        welcome(out);

        while(true) {
          String request = in.readUTF();

          if (request.equals("quit")) {
            break;
          } else if (request.equals("menu")) {
            printMainMenus(out);
          } else {
            processMainMenu(in, out, request);
          }
        }
        System.out.println("클라이언트에 접속 종료!");

      } catch (Exception e) {
        System.out.println("클라이언트 통신하는 중 오류 발생!");
        e.printStackTrace();
      }

    }

    void processMainMenu (DataInputStream in, DataOutputStream out, String request) {
      try {
        int menuNo = Integer.parseInt(request);
        if (menuNo < 1 || menuNo > menus.length) {
          throw new Exception("메뉴 번호가 옳지 않습니다.");
        }
        BreadCrumb breadCrumb = BreadCrumb.getBreadCrumbOfCurrentThread();

        breadCrumb.put(menus[menuNo - 1]);

        handlers.get(menuNo - 1).execute(in, out);

        breadCrumb.pickUp();

      } catch (Exception e) {
        error(out, e); 
      }

    }
  }  
}
