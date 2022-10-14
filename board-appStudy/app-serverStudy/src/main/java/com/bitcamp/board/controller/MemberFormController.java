package com.bitcamp.board.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.servlet.Controller;

@WebServlet("/member/form")
public class MemberFormController implements Controller {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return "/member/form.jsp";

  }
}




