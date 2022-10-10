package com.bitcamp.board.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.domain.Board;
import com.bitcamp.board.service.BoardService;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  BoardService boardService;

  @Override
  public void init() throws ServletException {
    boardService = (BoardService) this.getServletContext().getAttribute("boardService");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      List<Board> boards = boardService.list();

      request.setAttribute("boards", boards);
      request.setAttribute("viewName", "redirect:/board/list.jsp");

    } catch (Exception e) {
      request.setAttribute("exception", e);
    }
  }
}