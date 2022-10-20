package com.bitcamp.board.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import com.bitcamp.board.domain.Member;

@Component
public class LoginCheckFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("LoginCheckFilter 실행!");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    System.out.println("LoginCheckFilter.doFilter() 실행!");

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;

    String servletPath = httpRequest.getServletPath(); // service로 시작하는 다음 경로로 알 수 있어야해서 이걸로 변경!

    if (servletPath.toLowerCase().endsWith("add") ||
        servletPath.toLowerCase().endsWith("update") ||
        servletPath.toLowerCase().endsWith("delete")) {

      Member loginMember = (Member) httpRequest.getSession().getAttribute("loginMember");
      if (loginMember == null) {// 로그인하지 않았다면
        httpResponse.sendRedirect(httpRequest.getContextPath() + "/auth/form");
        return;
      }
    }

    // 다음 필터를 실행한다.
    // 다음으로 실행할 필터가 없다면 원래 목적지인 서블릿이 실행될 것이다.
    chain.doFilter(request, response);
  }

}