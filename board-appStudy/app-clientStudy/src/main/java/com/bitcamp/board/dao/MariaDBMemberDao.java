package com.bitcamp.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.bitcamp.board.domain.Member;

// 회원 목록을 관리하는 역할
//
public class MariaDBMemberDao {

  public int insert(Member member) throws Exception {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb","study","1111");
        PreparedStatement psmt = con.prepareStatement(
            "insert into app_member(name,email,pwd) values(?, ?, sha2(?,256))")) {

      psmt.setString(1, member.name);
      psmt.setString(2, member.email);
      psmt.setString(3, member.password);

      return psmt.executeUpdate();
    }
  }

  public Member findByNo(int no) throws Exception{
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb","study","1111");
        PreparedStatement psmt = con.prepareStatement(
            "select mno,name,email,cdt from app_member where mno=" + no);
        ResultSet rs = psmt.executeQuery()) {

      if(!rs.next()) {
        return null;
      }

      Member member = new Member();
      member.no = rs.getInt("mno");
      member.name = rs.getString("name");
      member.email = rs.getString("email");
      member.createdDate = rs.getDate("cdt");
      return member;
    }
  }

  public int update(Member member) throws Exception {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb","study","1111");
        PreparedStatement psmt = con.prepareStatement(
            "update app_member set name=?, email=?, pwd=sha2(?,256) where mno=?")) {

      psmt.setString(1, member.name);
      psmt.setString(2, member.email);
      psmt.setString(3, member.password);
      psmt.setInt(4, member.no);
      return psmt.executeUpdate();

    }
  }

  public int delete(int no) throws Exception{
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb","study","1111");
        PreparedStatement psmt1 = con.prepareStatement("delete from app_board where mno=?");
        PreparedStatement psmt2 = con.prepareStatement("delete from app_member where mno=?")) {

      psmt1.setInt(1, no);
      psmt1.executeUpdate();

      psmt2.setInt(1, no);
      return psmt2.executeUpdate();

    }
  }

  public List<Member> findAll() throws Exception{
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb","study","1111");
        PreparedStatement psmt = con.prepareStatement(
            "select mno,name,email from app_member");
        ResultSet rs = psmt.executeQuery()) {

      ArrayList<Member> list = new ArrayList<>();

      while (rs.next()) {
        Member member = new Member();
        member.no = rs.getInt("mno");
        member.name = rs.getString("name");
        member.email = rs.getString("email");
        list.add(member);
      }
      return list;

    }
  }
}














