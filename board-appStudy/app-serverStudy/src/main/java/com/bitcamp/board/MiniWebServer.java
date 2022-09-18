package com.bitcamp.board;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetSocketAddress;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.dao.MariaDBBoardDao;
import com.bitcamp.board.dao.MariaDBMemberDao;
import com.bitcamp.board.dao.MemberDao;
import com.bitcamp.board.handler.BoardHandler;
import com.bitcamp.handler.ErrorHandler;
import com.bitcamp.handler.WelcomeHandler;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class MiniWebServer {

  public static void main(String[] args) throws Exception {
    Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb","study","1111");

    BoardDao boardDao = new MariaDBBoardDao(con);
    MemberDao memberDao = new MariaDBMemberDao(con);

    WelcomeHandler welcomeHandeler = new WelcomeHandler();
    ErrorHandler errorHandler = new ErrorHandler();
    BoardHandler boardHandler = new BoardHandler(boardDao);

    class MyHttpHandler implements HttpHandler {
      @Override
      public void handle(HttpExchange exchange) throws IOException {
        System.out.println("클라이언트가 요청함");

        URI requestUri = exchange.getRequestURI();
        String path = requestUri.getPath();
        String query = requestUri.getRawQuery();
        byte[] bytes = null;

        try (StringWriter strOut = new StringWriter();
            PrintWriter tempOut = new PrintWriter(strOut)) {

          Map<String,String> paramMap = new HashMap<>();
          if(query != null && query.length() > 0) {
            String[] entries = query.split("&");
            for(String entry : entries) {
              String[] kv = entry.split("=");
              paramMap.put(kv[0], kv[1]);
            }

          }

          if(path.equals("/")) {
            welcomeHandeler.service(tempOut);

          } else if (path.equals("/board/list")) {
            boardHandler.list(tempOut);

          } else if (path.equals("/board/detail")) {
            boardHandler.detail(paramMap, tempOut);

          } else if (path.equals("/board/delete")) {
            boardHandler.delete(paramMap, tempOut);

          } else if (path.equals("/board/update")) {
            boardHandler.update(paramMap, tempOut);

          } else if (path.equals("/board/form")) {
            boardHandler.form(tempOut);

          } else if (path.equals("/board/add")) {
            boardHandler.add(paramMap, tempOut);

          } else {
            errorHandler.service(tempOut);
          } 

          bytes = strOut.toString().getBytes("UTF-8");
        } catch (Exception e) {
          bytes = "요청 처리 중 오류 발생".getBytes("UTF-8");
          e.printStackTrace();
        }

        Headers responseHeaders = exchange.getResponseHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");

        exchange.sendResponseHeaders(200, bytes.length);

        OutputStream out = exchange.getResponseBody();

        out.write(bytes);
        out.close();

      }

    }
    HttpServer server = HttpServer.create(new InetSocketAddress(8888), 0);
    server.createContext("/", new MyHttpHandler());
    server.setExecutor(null);
    server.start();

    System.out.println("서버 시작!");
  }

}
