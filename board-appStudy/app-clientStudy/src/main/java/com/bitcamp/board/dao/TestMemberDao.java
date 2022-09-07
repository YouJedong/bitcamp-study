package com.bitcamp.board.dao;

import java.util.List;
import com.bitcamp.board.domain.Member;

public class TestMemberDao {

  public static void main(String[] args) throws Exception  {
    MariaDBMemberDao dao = new MariaDBMemberDao();
    List<Member> list = dao.findAll();
    for(Member m : list) {
      System.out.println(m);
    }

    System.out.println("---------------------------------------");

    //    Member member = new Member();
    //    member.name = "test4";
    //    member.email = "tes5@test.com";
    //    member.password = "1111";
    //    dao.insert(member);

    //    dao.delete(16);
    Member member = dao.findByNo(14);

    member.name = "kokokok";
    member.email = "kokok@test.com";
    member.password = "1121";
    dao.update(member);


    List<Member> list2 = dao.findAll();
    for(Member m : list2) {
      System.out.println(m);
    }
    System.out.println("---------------------------------------");



  }

}
