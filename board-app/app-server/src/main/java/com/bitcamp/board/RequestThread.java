package com.bitcamp.board;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Map;
import com.bitcamp.servlet.Servlet;

// 클라이언트 요청을 main 실행 흐름과 분리하여 
// 별도의 실행으로 다루는 클래스
public class RequestThread implements Runnable {

  private Socket socket;
  private Map<String,Servlet> servletMap;

  public RequestThread(Socket socket, Map<String,Servlet> servletMap) {
    this.socket = socket;
    this.servletMap = servletMap;
  }

  // 별도의 실행흐름에서 수행할 작업 정의
  @Override
  public void run() {
    try (
        Socket socket = this.socket;
        // 굳이 소켓을 또 써야하나? 
        // 여기에 선언된 변수(socket)만이 자동으로 닫힘
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());) {

      System.out.println("클라이언트와 연결 되었음!");

      String dataName = in.readUTF();

      Servlet servlet = servletMap.get(dataName);
      if (servlet != null) {
        servlet.service(in, out);
      } else {
        out.writeUTF("fail");
      }
      System.out.println("클라이언트와 연결을 끊었음!");
    } catch (Exception e) {
      System.out.println("클라이언트 오류");
      System.out.println();
    }
  } 

}
