package com.bitcamp.board.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bitcamp.board.dao.MemberDao;
import com.bitcamp.board.domain.Member;

@Service
public class DefaultMemberService implements MemberService {
  MemberDao memberDao;

  public DefaultMemberService(MemberDao memberDao) {
    System.out.println("DefaultMemberService()호출됨!");
    this.memberDao = memberDao;
  }

  @Override
  public Member get(String email, String password) throws Exception {
    return memberDao.findByEmailPassword(email, password);
  }

  @Override
  public int add(Member member) throws Exception {
    return memberDao.insert(member);
  }

  @Override
  public boolean delete(int no) throws Exception {
    return memberDao.delete(no) > 0;
  }

  @Override
  public Member get(int no) throws Exception {
    return memberDao.findByNo(no);
  }

  @Override
  public List<Member> list() throws Exception {
    return memberDao.findAll();
  }

  @Override
  public boolean update(Member member) throws Exception {
    return memberDao.update(member) > 0;
  }





}
