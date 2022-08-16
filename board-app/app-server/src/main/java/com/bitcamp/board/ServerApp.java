package com.bitcamp.board;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import com.bitcamp.board.servlet.BoardServlet;

public class ServerApp {
  public static void main(String[] args) {
    System.out.println("[게시글 데이터 관리 서버]");

    try(
        ServerSocket serverSocket = new ServerSocket(8888);) {

      System.out.println("서버 소켓 준비 완료");

      try (Socket socket = serverSocket.accept();
          DataInputStream in = new DataInputStream(socket.getInputStream());
          DataOutputStream out = new DataOutputStream(socket.getOutputStream());
          ) {
        System.out.println("클라이언트와 연결되었음");

        BoardServlet boardServlet = new BoardServlet("board");
        BoardServlet readingServlet = new BoardServlet("reading");
        BoardServlet visitServlet = new BoardServlet("visit");
        BoardServlet noticeServlet = new BoardServlet("notice");
        BoardServlet dailyServlet = new BoardServlet("daily");

        while (true) {
          String dataName = in.readUTF();

          if (dataName.equals("exit")) {
            break;
          }

          switch (dataName) {
            case "board": boardServlet.service(in, out); break;
            case "reading": readingServlet.service(in, out); break;
            case "visit": visitServlet.service(in, out); break;
            case "notice": noticeServlet.service(in, out); break;
            case "daily": dailyServlet.service(in, out); break;
            default : 
              out.writeUTF("fail");
          }
        }
        System.out.println("클라이언트와 연결을 끊었음!");
      }
    } catch (Exception e) {
      e.getStackTrace();
    }
    System.out.println("서버 종료!");

  }
}
