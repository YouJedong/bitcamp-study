package com.bitcamp.board;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.text.DefaultEditorKit.InsertBreakAction;
import com.bitcamp.board.handler.BoardHandler;
import com.bitcamp.board.handler.MemberHandler;
import com.bitcamp.handler.Handler;
import com.bitcamp.util.BreadCrumb;

public class ServerApp {

  private String[] menus = {"게시판", "회원"};
  private int port;
  ArrayList<Handler> handlers = new ArrayList<>();

  public ServerApp(int port) {
    this.port = port;

    handlers.add(new BoardHandler(null));
    handlers.add(new MemberHandler(null));
  }

  public static void main(String[] args) {
    ServerApp app = new ServerApp(8888);
    app.execute();

  }

  public void execute()  {
    try (ServerSocket serverSocket = new ServerSocket(this.port);) {
      System.out.println("서버 실행 중..");

      while (true) {
        new Thread(new ServiceProccesor(serverSocket.accept())).start();
        System.out.println("클라이언트 접속");
      } 
      tempOut.println(breadCrumb.toString());
      printMainMenus(tempOut);
      out.writeUTF(strOut.toString());
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

void printMainMenus(DataOutputStream out) throws Exception {
  try (StringWriter strOut = new StringWriter();
      PrintWriter tempOut = new PrintWriter(strOut);) {
    for (int i = 0; i < menus.length; i++) {
      tempOut.printf("  %d: %s\n", i + 1, menus[i]);
    }
    tempOut.printf("메뉴를 선택하세요[1..%d](quit: 종료) ", menus.length);
    out.writeUTF(strOut.toString());
  }

}

protected void printTitle() {
  StringBuilder builder = new StringBuilder();
  for (String title : breadcrumbMenu) {
    if (!builder.isEmpty()) {
      builder.append(" > ");
    }
    builder.append(title);
  }
  System.out.printf("%s:\n", builder.toString());
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
        }
        if (request.equals("menu")) {
          breadCrumb.toString();
          printMainMenus(out);
          continue;
        }

        try {
          int menuNo = Integer.parseInt(request);
          if (menuNo < 1 || menuNo > menus.length) {
            throw new Exception("메뉴 번호가 옳지 않습니다.");
          }
        } catch (Exception e) {

        }
      }




    } catch (Exception e) {
      System.out.println("클라이언트 통신하는 중 오류 발생!");
      e.printStackTrace();
    }


  }
}  
}
