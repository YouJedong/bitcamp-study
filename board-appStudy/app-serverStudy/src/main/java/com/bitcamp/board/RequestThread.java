package com.bitcamp.board;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Map;
import com.bitcamp.servlet.Servlet;

public class RequestThread extends Thread{

  private Socket socket;
  private Map<String,Servlet> servletMap;

  public RequestThread(Socket socket, Map<String,Servlet> servletMap) {
    this.socket = socket;
    this.servletMap = servletMap;
  }
  @Override
  public void run() {
    try (Socket socket = this.socket;
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());) {

      System.out.println("클라이언트와 연결 되었음!");

      // 클라이언트와 서버 사이에 정해진 규칙(protocol)에 따라 데이터를 주고 받는다.
      String dataName = in.readUTF();

      Servlet servlet = servletMap.get(dataName);
      if (servlet != null) {
        servlet.service(in, out);
      } else {
        out.writeUTF("fail");
      }

      System.out.println("클라이언트와 연결을 끊었음!");
    } catch (Exception e) {
      System.out.println("클라이언트 요청 처리 중 문제 발생!");
      e.printStackTrace();
    }

  }
}