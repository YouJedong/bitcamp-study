package com.bitcamp.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.dao.BoardDao;

@WebServlet("/board/delete")
public class BoardDeleteController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  BoardDao boardDao;

  @Override
  public void init() throws ServletException {
    boardDao = (BoardDao) this.getServletContext().getAttribute("boardDao");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      if (boardDao.delete(no) == 0) {
        throw new Exception("게시글 삭제 실패!");
      }

      // 1. JSP의 해더 설정 + 작업처리 위임 
      response.setHeader("Refresh", "1;url=list");
      response.setContentType("text/html; charset=UTF-8");
      request.getRequestDispatcher("/board/delete.jsp").include(request, response);

      //      // 2. 작업처리 위임 (Refresh)
      //      response.setContentType("text/html; charset=UTF-8");
      //      request.getRequestDispatcher("/board/add.jsp").include(request, response);

      //      // 3.
      //      response.sendRedirect("list");

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}