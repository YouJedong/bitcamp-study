package com.bitcamp.board.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.domain.Member;
import com.bitcamp.board.service.MemberService;
import com.bitcamp.servlet.Controller;

@WebServlet("/member/detail")
public class MemberDetailController implements Controller {

  MemberService memberService;
  public MemberDetailController(MemberService memberService) {
    this.memberService = memberService;
  }

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    Member member = memberService.get(no);

    if (member == null) {
      throw new Exception("회원 상세보기 실패!");
    }

    request.setAttribute("member", member);
    return "/member/detail.jsp";

  }
}




