package com.bitcamp.board;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetSocketAddress;
import java.net.URI;
import com.bitcamp.handler.ErrorHandler;
import com.bitcamp.handler.WelcomeHandler;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class MiniWebServer {

  public static void main(String[] args) throws Exception {

    class MyHttpHandler implements HttpHandler {
      @Override
      public void handle(HttpExchange exchange) throws IOException {
        System.out.println("클라이언트가 요청함");

        URI requestUri = exchange.getRequestURI();

        String path = requestUri.getPath();

        WelcomeHandler welcomeHandeler = new WelcomeHandler();
        ErrorHandler errorHandler = new ErrorHandler();

        byte[] bytes = null;

        try (StringWriter strOut = new StringWriter();
            PrintWriter tempOut = new PrintWriter(strOut)) {
          if(path.equals("/")) {
            welcomeHandeler.service(tempOut);
          } else {
            errorHandler.service(tempOut);
          }



          bytes = strOut.toString().getBytes("UTF-8");
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
