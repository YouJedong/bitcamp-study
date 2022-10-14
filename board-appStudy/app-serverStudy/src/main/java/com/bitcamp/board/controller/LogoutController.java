package com.bitcamp.board.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bitcamp.servlet.Controller;

@WebServlet("/auth/logout")
public class LogoutController implements Controller {
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession();
    session.invalidate();
    return "redirect:../../";

  }
}




