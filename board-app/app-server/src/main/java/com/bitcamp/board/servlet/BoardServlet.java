/*
 * 게시글 메뉴 처리 클래스
 */
package com.bitcamp.board.servlet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import com.bitcamp.servlet.Servlet;

public class BoardServlet implements Servlet {

  private int BoardDao;

  public BoardServlet(String dataname) {
    //    boardDao = new BoardDao(filename);
    //
    //    try {
    //      boardDao.load();
    //    } catch (Exception e) {
    //      System.out.printf("%s 파일 로딩 중 오류 발생!\n", filename);
    //      //      e.printStackTrace();
    //    }
  }

  @Override
  public void service(DataInputStream in, DataOutputStream out) {
    try {
      String commend = in.readUTF();

      switch (commend) {
        case "findAll":
          out.writeUTF("Success");
          break;
        case "findByNo":
          out.writeUTF("Success");
          break;
        case "insert":
          out.writeUTF("Success");
          break;
        case "delete":
          out.writeUTF("Success");
          break;
        case "update": 
          out.writeUTF("Success");
          break;
        default : 
          out.writeUTF("fail");
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}




