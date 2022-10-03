package com.bitcamp.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bitcamp.board.dao.MemberDao;
import com.bitcamp.board.domain.Member;

@WebServlet("/auth/login")
public class LoginController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  MemberDao memberDao;

  @Override
  public void init() throws ServletException {
    memberDao = (MemberDao) this.getServletContext().getAttribute("memberDao");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {


    try {
      String email = request.getParameter("email");
      String password = request.getParameter("password");
      Member member = memberDao.findByEmailPassword(email, password);

      if (member != null) {
        HttpSession session = request.getSession();
        session.setAttribute("loginMember", member);
      }

      Cookie cookie = new Cookie("email", email);
      if (request.getParameter("saveEmail") == null) {
        cookie.setMaxAge(0);
      } else {
        cookie.setMaxAge(60 * 60 * 24 * 7);
      }
      response.addCookie(cookie);

      request.setAttribute("member", member);
      response.setContentType("text/html; charset=UTF-8");
      request.getRequestDispatcher("/auth/loginResult.jsp").include(request, response);

    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}




