package com.bitcamp.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/service/*")
public class DispatcherServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String pathInpo = req.getPathInfo();

    resp.setContentType("text/html; charset=UTF-8");
    RequestDispatcher 요청배달자 = req.getRequestDispatcher(pathInpo);
    요청배달자.include(req, resp);

    @SuppressWarnings("unchecked")
    List<Cookie> cookies = (List<Cookie>) req.getAttribute("viewName");
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        resp.addCookie(cookie);
      }
    }

    String viewName = (String) req.getAttribute("viewName");

    if (viewName != null) {
      if (viewName.startsWith("redirect:")) {
        resp.sendRedirect(viewName.substring(9));
        return;

      } else {
        req.getRequestDispatcher(viewName).include(req, resp);
      }
    } else {
      req.getRequestDispatcher("/error.jsp").include(req, resp);
    }
  }
}
