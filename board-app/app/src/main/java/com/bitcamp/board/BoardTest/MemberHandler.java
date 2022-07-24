/*
 * 회원 메뉴 처리 클래스 
 * 비트캠프-20220704
 */
package com.bitcamp.board.BoardTest;

import java.util.Date;

public class MemberHandler {

  String title;

  MemberList memberList = new MemberList();

  MemberHandler() {
    this.title = "회원";
  }

  void execute() {
    // App 클래스에서 이 메서드를 호출할 때 BoardHandler의 인스턴스 주소를 줄 것이다.
    // 그 주소는 this 라는 내장 변수에 보관된다.
    while (true) {
      System.out.println("[회원]");
      System.out.println("  1: 목록");
      System.out.println("  2: 상세보기");
      System.out.println("  3: 등록");
      System.out.println("  4: 삭제");
      System.out.println("  5: 변경");
      System.out.println();

      int menuNo = Prompt.inputInt("메뉴를 선택하세요[1..5](0: 이전) ");
      displayHeadLine();

      // 다른 인스턴스 메서드를 호출할 때 this에 보관된 인스턴스 주소를 사용한다.
      switch (menuNo) {
        case 0: return;
        case 1: this.onList(); break;  
        case 2: this.onDetail(); break;
        case 3: this.onInput(); break;
        case 4: this.onDelate(); break;
        case 5: this.onUpdate(); break;
        default: System.out.println("메뉴 번호가 옳지 않습니다!");
      } 

      displayBlankLine();
    }// 게시판 while
  }

  static void displayHeadLine() {
    System.out.println("--------------------------------------------------");
  }

  static void displayBlankLine() {
    System.out.println();
  }

  void onList() {  
    System.out.println("[회원 목록]");
    System.out.println("번호\t이름\t이메일");

    Member[] list = this.memberList.toArray();

    for (Member member : list) {
      System.out.printf("%d\t %s\t %s\n", member.no, member.name, member.email);
    }

  }
  void onDetail() {
    System.out.println("[회원 상세보기]");

    int memberNo = Prompt.inputInt("조회할 회원 번호?");

    Member member = this.memberList.get(memberNo);

    // 사용자가 입력한 번호에 해당하는 게시글을 못 찾았다면
    if (member == null) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }

    System.out.printf("번호: %d\n", member.no);
    System.out.printf("이름: %s\n", member.name);
    System.out.printf("이메일: %s\n", member.email);
    Date date = new Date(member.createdDate);
    System.out.printf("등록일: %tY-%1$tm-%1$td %1$tH:%1$tM\n", date); 

  }
  void onInput() {
    System.out.println("[회원 등록]");

    Member member = new Member();

    member.name = Prompt.inputString("\n이름? ");
    member.email = Prompt.inputString("\n이메일? ");  
    member.password = Prompt.inputString("\n암호? ");
    member.createdDate = System.currentTimeMillis();
    this.memberList.add(member); 

    System.out.println("회원을 등록했습니다.");

  }

  void onDelate() {
    System.out.println("[회원 삭제]\n");

    int memberNo = Prompt.inputInt("삭제할 회원 번호?");

    if (memberList.remove(memberNo)) {
      System.out.println("삭제됐습니다!");
    } else {
      System.out.println("해당 번호의 회원이 없습니다!");
    }

  }
  void onUpdate() {
    System.out.println("[회원 프로필 변경]\n");

    int memberNo = Prompt.inputInt("변경할 회원 번호?");

    Member member = this.memberList.get(memberNo);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }

    String newName = Prompt.inputString("이름? (" + member.name + ")");
    String newEmail = Prompt.inputString("이메일? (" + member.email + ")");

    while (true) {
      char yesORno = Prompt.inputStringToChar("변경하시겠습니까?(y/n)");
      if (yesORno == 'y') {
        System.out.print("변경되었습니다.");
        member.name = newName;
        member.email = newEmail;
        break;

      } else if (yesORno == 'n') {
        System.out.print("변경이 취소되었습니다.");
        break;

      } else {
        System.out.println("잘못 입력했습니다. 다시 입력해주세요.(y/n)");
      }
    }
  }
}  