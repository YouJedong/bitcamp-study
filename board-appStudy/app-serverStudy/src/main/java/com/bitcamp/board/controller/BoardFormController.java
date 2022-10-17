package com.bitcamp.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardFormController {

  @GetMapping("/board/form")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return "/board/form.jsp";
  }
}