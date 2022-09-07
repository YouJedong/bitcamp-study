package com.bitcamp.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.bitcamp.board.domain.Board;

//
public class MariaDBBoardDao {

  public int insert(Board board) throws Exception {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb","study","1111");
        PreparedStatement psmt = con.prepareStatement(
            "insert into app_board(title,cont,mno) values(?, ?, ?)")) {
      psmt.setString(1, board.title);
      psmt.setString(2, board.content);
      psmt.setInt(3, board.memberNo);
      return psmt.executeUpdate();
    }
  }

  public Board findByNo(int no) throws Exception{
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb","study","1111");
        PreparedStatement psmt = con.prepareStatement(
            "select bno,title,cont,mno,cdt,vw_cnt from app_board where bno=" + no);
        ResultSet rs = psmt.executeQuery()) {

      if(!rs.next()) {
        return null;
      }

      Board board = new Board();
      board.no = rs.getInt("bno");
      board.title = rs.getString("title");
      board.content = rs.getString("cont");
      board.memberNo = rs.getInt("mno");
      board.createdDate = rs.getDate("cdt");
      board.viewCount = rs.getInt("vw_cnt");
      return board;
    }
  }

  public int update(Board board) throws Exception {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb","study","1111");
        PreparedStatement psmt = con.prepareStatement(
            "update app_board set title=?, cont=? where bno=?")) {

      psmt.setString(1, board.title);
      psmt.setString(2, board.content);
      psmt.setInt(3, board.no);
      return psmt.executeUpdate();

    }
  }

  public int delete(int no) throws Exception{
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb","study","1111");
        PreparedStatement psmt = con.prepareStatement("delete from app_board where bno=?")) {

      psmt.setInt(1, no);
      return psmt.executeUpdate();

    }
  }

  public List<Board> findAll() throws Exception{
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb","study","1111");
        PreparedStatement psmt = con.prepareStatement(
            "select bno,title,mno,cdt,vw_cnt from app_board");
        ResultSet rs = psmt.executeQuery()) {

      ArrayList<Board> list = new ArrayList<>();

      while (rs.next()) {
        Board board = new Board();
        board.no = rs.getInt("bno");
        board.title = rs.getString("title");
        board.memberNo = rs.getInt("mno");
        board.createdDate = rs.getDate("cdt");
        board.viewCount = rs.getInt("vw_cnt");
        list.add(board);
      }
      return list;

    }
  }
}














