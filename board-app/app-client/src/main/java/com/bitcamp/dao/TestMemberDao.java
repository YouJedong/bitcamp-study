package com.bitcamp.dao;

import java.util.List;
import com.bitcamp.board.domain.Member;

public class TestMemberDao {

  public static void main(String[] args) throws Exception {
    MariaDBMemberDao dao = new MariaDBMemberDao();
    List<Member> list = dao.findAll();
    for (Member member : list) {
      System.out.println(member);
    }
    System.out.println("-------------------------------------");

    //    dao.delete(6);

    Member member = new Member();
    member.no = 1;
    member.name = "xxxx";
    member.email = "xxxx@test.com";
    member.password = "2222";
    dao.update(member);

    Member member2 = dao.findByNo(1);
    System.out.println(member2);

    //    Member member = dao.findByNo(1);
    //    System.out.println(member);

    //    System.out.println("-------------------------------------");

    //    Member member = new Member();
    //    member.name = "홍길동";
    //    member.email = "hong@test.com";
    //    member.password = "1111";
    //    dao.insert(member);
    //
    //    list = dao.findAll();
    //    for (Member m : list) {
    //      System.out.println(m);
    //    }
    //
    //    System.out.println("-------------------------------------");
    //
  }

}

