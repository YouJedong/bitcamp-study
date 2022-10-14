package com.bitcamp.board.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.servlet.Controller;

@WebServlet("/board/form")
public class BoardFormController implements Controller {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return "/board/form.jsp";
  }
}