package com.bitcamp.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import com.bitcamp.board.service.BoardService;
import com.bitcamp.servlet.Controller;

@Component("/board/list")
public class BoardListController implements Controller {

  BoardService boardService;
  public BoardListController(BoardService boardService) {
    System.out.println("boardListController() 호출됨!");
    this.boardService = boardService;
  }
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    request.setAttribute("boards", boardService.list());
    return "/board/list.jsp";

  }
}