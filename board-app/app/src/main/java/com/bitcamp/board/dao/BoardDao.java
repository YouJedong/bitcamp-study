package com.bitcamp.board.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import com.bitcamp.board.domain.Board;

// 게시글 목록을 관리하는 역할
//
public class BoardDao {

  List<Board> list = new LinkedList<>();

  private int boardNo = 0;

  String filename;
  public BoardDao(String filename) {
    this.filename = filename;
  }

  public void insert(Board board) {
    board.no = nextNo();
    list.add(board);
  }

  public void load() throws Exception {
    FileInputStream in = new FileInputStream(filename);

    // 게시글 목록 
    int size = (in.read() << 24) + (in.read() << 16) + (in.read() << 8) + in.read();

    for (int i = 0; i < size; i++) {

      // 읽은 객체의 데이터를 저장할 객체 준비
      Board board = new Board();

      // 게시글 번호 불러오기 
      board.no = (in.read() << 24) + (in.read() << 16) + (in.read() << 8) + in.read();

      // 게시글 제목의 바이트 수를 저장한 데이터 불러오기
      int strByte = 0;
      strByte = (in.read() <<24) + (in.read() << 16) + (in.read() << 8) + in.read();
      // 
      byte[] bytes = new byte[strByte];
      //bytes의 배열크기에 해당되는 데이터 크기를 읽고 반환한다.
      in.read(bytes);
      board.title = new String(bytes, "UTF-8");

      // 게시글 내용
      strByte = 0;
      strByte = (in.read() <<24) + (in.read() << 16) + (in.read() << 8) + in.read();
      bytes = new byte[strByte];
      //bytes의 배열크기에 해당되는 데이터 크기를 읽고 반환한다.
      in.read(bytes);
      board.content = new String(bytes, "UTF-8");

      // 게시글 작성자
      strByte = 0;
      strByte = (in.read() <<24) + (in.read() << 16) + (in.read() << 8) + in.read();
      bytes = new byte[strByte];
      //bytes의 배열크기에 해당되는 데이터 크기를 읽고 반환한다.
      in.read(bytes);
      board.writer = new String(bytes, "UTF-8");

      // 게시글 암호
      strByte = 0;
      strByte = (in.read() <<24) + (in.read() << 16) + (in.read() << 8) + in.read();
      bytes = new byte[strByte];
      //bytes의 배열크기에 해당되는 데이터 크기를 읽고 반환한다.
      in.read(bytes);
      board.password = new String(bytes, "UTF-8");

      // 게시글 조회수
      board.viewCount = (in.read() << 24) + (in.read() << 16) + (in.read() << 8) + in.read();

      // 게시글 등록일
      board.createdDate =
          (((long)in.read()) << 54) + 
          (((long)in.read()) << 48) +
          (((long)in.read()) << 40) +
          (((long)in.read()) << 32) +
          (((long)in.read()) << 24) +
          (((long)in.read()) << 16) +
          (((long)in.read()) << 8) +
          ((in.read()));

      list.add(board);

      boardNo = board.no;

    }
    in.close();
  }

  public void save() throws Exception {
    FileOutputStream out = new FileOutputStream(filename);

    //    게시글 수 저장
    out.write(list.size() >> 24);
    out.write(list.size() >> 16);
    out.write(list.size() >> 8);
    out.write(list.size());

    for (Board board : list) {
      // 게시글 번호
      out.write(board.no >> 24);
      out.write(board.no >> 16);
      out.write(board.no >> 8);
      out.write(board.no);

      // 게시글 제목
      byte[] bytes = board.title.getBytes("UTF-8");
      out.write(bytes.length >> 24);
      out.write(bytes.length >> 16);
      out.write(bytes.length >> 8);
      out.write(bytes.length);
      out.write(bytes);

      // 게시글 내용
      bytes = board.content.getBytes("UTF-8");
      out.write(bytes.length >> 24);
      out.write(bytes.length >> 16);
      out.write(bytes.length >> 8);
      out.write(bytes.length);
      out.write(bytes);

      // 게시글 작성자
      bytes = board.writer.getBytes("UTF-8");
      out.write(bytes.length >> 24);
      out.write(bytes.length >> 16);
      out.write(bytes.length >> 8);
      out.write(bytes.length);
      out.write(bytes);

      // 게시글 암호 
      bytes = board.password.getBytes("UTF-8");
      out.write(bytes.length >> 24);
      out.write(bytes.length >> 16);
      out.write(bytes.length >> 8);
      out.write(bytes.length);
      out.write(bytes);

      // 게시글 조회수
      out.write(board.viewCount >> 24);
      out.write(board.viewCount >> 16);
      out.write(board.viewCount >> 8);
      out.write(board.viewCount);

      // 게시글 등록일 
      out.write((int)(board.createdDate >> 54));
      out.write((int)(board.createdDate >> 48));
      out.write((int)(board.createdDate >> 40));
      out.write((int)(board.createdDate >> 32));
      out.write((int)(board.createdDate >> 24));
      out.write((int)(board.createdDate >> 16));
      out.write((int)(board.createdDate >> 8));
      out.write((int)(board.createdDate));
    }

    out.close();
  }


  public Board findByNo(int boardNo) {
    for (int i = 0; i < list.size(); i++) {
      Board board = list.get(i);
      if (board.no == boardNo) {
        return board;
      }
    }
    return null;
  }

  public boolean delete(int boardNo) {
    for (int i = 0; i < list.size(); i++) {
      Board board = list.get(i);
      if (board.no == boardNo) {
        return list.remove(i) != null;
      }
    }
    return false;
  }

  public Board[] findAll() {

    // 목록에서 값을 꺼내는 일을 할 객체를 준비한다.
    Iterator<Board> iterator = list.iterator();

    // 역순으로 정렬하여 리턴한다.
    Board[] arr = new Board[list.size()];

    int index = list.size() - 1;
    while (iterator.hasNext()) {
      arr[index--] = iterator.next();
    }
    return arr;
  }

  private int nextNo() {
    return ++boardNo;
  }
}














