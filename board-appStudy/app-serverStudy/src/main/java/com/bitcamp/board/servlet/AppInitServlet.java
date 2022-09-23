package com.bitcamp.board.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(
    value="/init",
    loadOnStartup=1)
public class AppInitServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void init() throws ServletException {

    System.out.println("공유할 자원 준비시작!");
    try {
      Class.forName("org.mariadb.jdbc.Driver");
      Connection con = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3306/studydb","study","1111");

      ServletContext stx = this.getServletContext();
      /////
      stx.setAttribute("board", stx);

    } catch (Exception e) {

    }
  }

}
