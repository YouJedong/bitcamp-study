package com.bitcamp.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.domain.Board;

@WebServlet("/board/add")
public class BoardAddController extends HttpServlet {
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
      Board board = new Board();
      board.title = request.getParameter("title");
      board.content = request.getParameter("content");
      board.memberNo = Integer.parseInt(request.getParameter("writerNo"));

      if (boardDao.insert(board) == 0) {
        throw new Exception("게시글 등록 실패!");
      }

      // 1. JSP의 해더 설정 + 작업처리 위임 
      response.setHeader("Refresh", "1;url=list");
      response.setContentType("text/html; charset=UTF-8");
      request.getRequestDispatcher("/board/add.jsp").include(request, response);

    } catch (Exception e) {

    }

  }
}
