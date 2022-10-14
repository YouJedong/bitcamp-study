package com.bitcamp.board.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.domain.Member;
import com.bitcamp.board.service.MemberService;
import com.bitcamp.servlet.Controller;

@WebServlet("/member/add")
public class MemberAddController implements Controller {

  MemberService memberService;
  public MemberAddController(MemberService memberService) {
    this.memberService = memberService;
  }
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Member member = new Member();
    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setPassword(request.getParameter("password"));

    memberService.add(member);

    return "redirect:list";
  }
}




