package com.bitcamp.board.service;

import java.util.List;
import com.bitcamp.board.domain.Member;

public interface MemberService {

  Member get(String email, String password) throws Exception;

  int add(Member member) throws Exception;

  boolean delete(int no) throws Exception;

  Member get(int no) throws Exception;

  List<Member> list() throws Exception;

  boolean update(Member member) throws Exception;

}
