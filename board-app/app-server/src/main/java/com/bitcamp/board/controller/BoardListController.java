package com.bitcamp.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.bitcamp.board.service.BoardService;

@Controller
//- 애노테이션을 붙일 때 객체 이름을 명시하면 그 이름으로 저장한다.
//- 프론트 컨트롤러는 페이지 컨트롤러를 찾을 때 이 이름으로 찾을 것이다.
public class BoardListController {

  BoardService boardService;

  public BoardListController(BoardService boardService) {
    System.out.println("보드리스트컨트롤러 호출됨");
    this.boardService = boardService;
  }

  @GetMapping("/board/list")
  public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    req.setAttribute("boards", boardService.list());
    return "/board/list.jsp";
  }
}
