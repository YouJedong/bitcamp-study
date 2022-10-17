package com.bitcamp.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.bitcamp.board.service.BoardService;

@Controller
public class BoardListController {

  BoardService boardService;
  public BoardListController(BoardService boardService) {
    System.out.println("boardListController() 호출됨!");
    this.boardService = boardService;
  }

  @GetMapping("/board/list")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    request.setAttribute("boards", boardService.list());
    return "/board/list.jsp";

  }
}