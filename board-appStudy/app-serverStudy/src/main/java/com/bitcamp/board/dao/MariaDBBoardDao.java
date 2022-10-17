package com.bitcamp.board.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.stereotype.Repository;
import com.bitcamp.board.domain.AttachedFile;
import com.bitcamp.board.domain.Board;
import com.bitcamp.board.domain.Member;

@Repository
public class MariaDBBoardDao implements BoardDao {

  DataSource ds;

  //DAO가 사용할 의존 객체 Connection을 생성자의 파라미터로 받는다.
  public MariaDBBoardDao(DataSource ds) {
    System.out.println("mariaDBBoardDao() 호출됨");
    this.ds = ds;
  }

  @Override
  public int insert(Board board) throws Exception {
    try (PreparedStatement pstmt = ds.getConnection().prepareStatement(
        "insert into app_board(title,cont,mno) values(?,?,?)",
        Statement.RETURN_GENERATED_KEYS)) {

      pstmt.setString(1, board.getTitle());
      pstmt.setString(2, board.getContent());
      pstmt.setInt(3, board.getWriter().getNo());
      int count = pstmt.executeUpdate();

      try (ResultSet rs = pstmt.getGeneratedKeys()) {
        rs.next();
        board.setNo(rs.getInt(1));
      }

      return count;
    }
  }

  @Override
  public int insertFiles(Board board) throws Exception {
    try (PreparedStatement pstmt = ds.getConnection().prepareStatement(
        "insert into app_board_file(filepath,bno) values(?,?)")) {

      List<AttachedFile> attachedFiles = board.getAttachedFiles();
      for (AttachedFile attachedFile : attachedFiles) {
        pstmt.setString(1, attachedFile.getFilepath());
        pstmt.setInt(2, board.getNo());
        pstmt.executeUpdate();
      }
      return attachedFiles.size();
    }
  }

  @Override
  public Board findByNo(int no) throws Exception {
    try (PreparedStatement pstmt = ds.getConnection().prepareStatement(
        "select "
            + "  b.bno,"
            + "  b.title,"
            + "  b.cont,"
            + "  b.cdt,"
            + "  b.vw_cnt, "
            + "  m.mno,"
            + "  m.name"
            + " from app_board b"
            + "  join app_member m on b.mno = m.mno"
            + " where b.bno=" + no);
        ResultSet rs = pstmt.executeQuery()) {

      if (!rs.next()) {
        return null;
      }

      Board board = new Board();
      board.setNo(rs.getInt("bno"));
      board.setTitle(rs.getString("title"));
      board.setContent(rs.getString("cont"));
      board.setCreatedDate(rs.getDate("cdt"));
      board.setViewCount(rs.getInt("vw_cnt"));

      Member member = new Member();
      member.setNo(rs.getInt("mno"));
      member.setName(rs.getString("name"));

      board.setWriter(member);

      try (PreparedStatement pstmt2 = ds.getConnection().prepareStatement(
          "select bfno, filepath, bno from app_board_file where bno=" + no);
          ResultSet rs2 = pstmt2.executeQuery()) {

        ArrayList<AttachedFile> attachedFiles = new ArrayList<>();
        while (rs2.next()) {
          AttachedFile file = new AttachedFile(); 
          file.setNo(rs2.getInt("bfno"));
          file.setFilepath(rs2.getString("filepath"));
          attachedFiles.add(file);
        }
        board.setAttachedFiles(attachedFiles);
      }

      return board;
    }
  }

  @Override
  public int update(Board board) throws Exception {
    try (PreparedStatement pstmt = ds.getConnection().prepareStatement(
        "update app_board set title=?, cont=? where bno=?")) {

      pstmt.setString(1, board.getTitle());
      pstmt.setString(2, board.getContent());
      pstmt.setInt(3, board.getNo());

      return pstmt.executeUpdate();
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (PreparedStatement pstmt = ds.getConnection().prepareStatement(
        "delete from app_board where bno=?")) {

      pstmt.setInt(1, no);

      return pstmt.executeUpdate();
    }
  }

  @Override
  public int deleteFiles(int fileNo) throws Exception {
    try (PreparedStatement pstmt = ds.getConnection().prepareStatement(
        "delete from app_board_file where bno=?")) {

      pstmt.setInt(1, fileNo);
      return pstmt.executeUpdate();
    }


  }

  @Override
  public List<Board> findAll() throws Exception {
    try (PreparedStatement pstmt = ds.getConnection().prepareStatement(
        "select "
            + "  b.bno,"
            + "  b.title,"
            + "  b.cdt,"
            + "  vw_cnt, "
            + "  m.mno,"
            + "  m.name"
            + " from app_board b"
            + "  join app_member m on b.mno = m.mno");
        ResultSet rs = pstmt.executeQuery()) {

      ArrayList<Board> list = new ArrayList<>();

      while (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("bno"));
        board.setTitle(rs.getString("title"));
        board.setCreatedDate(rs.getDate("cdt"));
        board.setViewCount(rs.getInt("vw_cnt"));

        Member member = new Member();
        member.setNo(rs.getInt("mno"));
        member.setName(rs.getString("name"));
        board.setWriter(member);

        list.add(board);
      }

      return list;
    }
  }

  @Override
  public AttachedFile findFileByNo(int fileNo) throws Exception {
    try (PreparedStatement pstmt = ds.getConnection().prepareStatement(
        "select bfno, filepath, bno from app_board_file where bfno=" + fileNo);
        ResultSet rs = pstmt.executeQuery()) {

      if (!rs.next()) {
        return null;
      }

      AttachedFile file = new AttachedFile();
      file.setNo(rs.getInt("bfno"));
      file.setFilepath(rs.getString("filepath"));
      file.setBoardNo(rs.getInt("bno"));

      return file;
    }
  }

  @Override
  public int deleteFile(int fileNo) throws Exception {
    try (PreparedStatement pstmt = ds.getConnection().prepareStatement(
        "delete from app_board_file where bfno=?")) {

      pstmt.setInt(1, fileNo);
      return pstmt.executeUpdate();
    }

  }
}














