package com.bitcamp.board.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import com.bitcamp.board.domain.Member;

// 회원 목록을 관리하는 역할
//
public class MemberDao {

  List<Member> list = new LinkedList<Member>();

  String titleName;

  public MemberDao(String titleName) {
    this.titleName = titleName;
  }

  public void insert(Member member) {
    list.add(member);
  }

  public void load() throws Exception {
    FileInputStream in = new FileInputStream(titleName);

    // 회원 수  
    int size = (in.read() << 24) + (in.read() << 16) + (in.read() << 8) + in.read();

    for (int i = 0; i < size; i++) {

      // 읽은 객체의 데이터를 저장할 객체 준비
      Member member = new Member();

      // 회원 번호 불러오기 
      member.no = (in.read() << 24) + (in.read() << 16) + (in.read() << 8) + in.read();

      // 회원 이름의 바이트 수를 저장한 데이터 불러오기
      int strByte = 0;
      strByte = (in.read() <<24) + (in.read() << 16) + (in.read() << 8) + in.read();
      // 
      byte[] bytes = new byte[strByte];
      //bytes의 배열크기에 해당되는 데이터 크기를 읽고 반환한다.
      in.read(bytes);
      member.name = new String(bytes, "UTF-8");

      // 회원 이메일 
      strByte = 0;
      strByte = (in.read() <<24) + (in.read() << 16) + (in.read() << 8) + in.read();
      bytes = new byte[strByte];
      //bytes의 배열크기에 해당되는 데이터 크기를 읽고 반환한다.
      in.read(bytes);
      member.email = new String(bytes, "UTF-8");

      // 회원 암호
      strByte = 0;
      strByte = (in.read() <<24) + (in.read() << 16) + (in.read() << 8) + in.read();
      bytes = new byte[strByte];
      //bytes의 배열크기에 해당되는 데이터 크기를 읽고 반환한다.
      in.read(bytes);
      member.password = new String(bytes, "UTF-8");

      // 회원 등록일
      member.createdDate =
          (((long)in.read()) << 54) + 
          (((long)in.read()) << 48) +
          (((long)in.read()) << 40) +
          (((long)in.read()) << 32) +
          (((long)in.read()) << 24) +
          (((long)in.read()) << 16) +
          (((long)in.read()) << 8) +
          ((in.read()));

      list.add(member);

    }
    in.close();
  }

  public void save() throws Exception {
    FileOutputStream out = new FileOutputStream(titleName);

    //    게시글 수 저장
    out.write(list.size() >> 24);
    out.write(list.size() >> 16);
    out.write(list.size() >> 8);
    out.write(list.size());

    for (Member member : list) {
      // 게시글 번호
      out.write(member.no >> 24);
      out.write(member.no >> 16);
      out.write(member.no >> 8);
      out.write(member.no);

      // 게시글 제목
      byte[] bytes = member.name.getBytes("UTF-8");
      out.write(bytes.length >> 24);
      out.write(bytes.length >> 16);
      out.write(bytes.length >> 8);
      out.write(bytes.length);
      out.write(bytes);

      // 게시글 내용
      bytes = member.email.getBytes("UTF-8");
      out.write(bytes.length >> 24);
      out.write(bytes.length >> 16);
      out.write(bytes.length >> 8);
      out.write(bytes.length);
      out.write(bytes);

      // 게시글 암호 
      bytes = member.password.getBytes("UTF-8");
      out.write(bytes.length >> 24);
      out.write(bytes.length >> 16);
      out.write(bytes.length >> 8);
      out.write(bytes.length);
      out.write(bytes);

      // 게시글 등록일 
      out.write((int)(member.createdDate >> 54));
      out.write((int)(member.createdDate >> 48));
      out.write((int)(member.createdDate >> 40));
      out.write((int)(member.createdDate >> 32));
      out.write((int)(member.createdDate >> 24));
      out.write((int)(member.createdDate >> 16));
      out.write((int)(member.createdDate >> 8));
      out.write((int)(member.createdDate));
    }

    out.close();
  }

  public Member findByEmail(String email) {
    for (int i = 0; i < list.size(); i++) {
      Member member = list.get(i);
      if (member.email.equals(email)) {
        return member;
      }
    }
    return null;
  }

  public boolean delete(String email) {
    for (int i = 0; i < list.size(); i++) {
      Member member = list.get(i);
      if (member.email.equals(email)) {
        return list.remove(i) != null;
      }
    }
    return false;
  }

  public Member[] findAll() {
    Iterator<Member> iterator = list.iterator();

    Member[] arr = new Member[list.size()];

    int i = 0;
    while (iterator.hasNext()) {
      arr[i++] = iterator.next(); 
    }
    return arr;
  }
}














