package com.bitcamp.board.dao;

import java.util.List;
import com.bitcamp.board.domain.Member;

// 회원 목록을 관리하는 역할
//
public interface MemberDao {

  public int insert(Member member) throws Exception;

  public Member findByNo(int no) throws Exception;

  public int update(Member member) throws Exception;

  public int delete(int no) throws Exception;

  public List<Member> findAll() throws Exception;
}














