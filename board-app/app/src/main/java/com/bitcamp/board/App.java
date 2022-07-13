/*
 * 게시판 관리 애플리케이션
 * 비트캠프-20220704
 */
package com.bitcamp.board;

public class App {
  
    public static void main(String[] args) {
      System.out.println("[게시판 애플리케이션]");
      System.out.println();
      System.out.println("환영합니다!");
      System.out.println();
    
      java.util.Scanner keyboardInput = new java.util.Scanner(System.in);

      String title = "";
      String content = "";
      String writer = "";
      String password = "";

      

      while (true) {
        System.out.println("메뉴");
        System.out.println("  1: 게시글 목록");
        System.out.println("  2: 게시글 상세보기");
        System.out.println("  3: 게시글 등록");
        System.out.println();
        System.out.print("메뉴를 선택하세요[1..3](0: 종료) ");  
        
        int menuNo = keyboardInput.nextInt(); //블러킹 사용자가 숫자를 입력하고 엔터를 칠때 까지 다음으로 안감
        keyboardInput.nextLine(); //입력한 숫자 뒤에 남아 있는 줄바꿈 코드 제거

        if (menuNo == 0) {
          break;
        } else if (menuNo == 1) {
          System.out.println("-----------------------------------");
          System.out.println("[게시글 목록]");
          System.out.println("번호\t제목\t조회수\t작성자\t등록일");
          
          System.out.print(1 + "\t");
          System.out.print("제목입니다.1\t");
          System.out.print(20 + "\t");
          System.out.print("홍길동\t");
          System.out.print("2022-07-08\n");
          System.out.print(2 + "\t" + "제목입니다.2" + '\t' + 11 + "\t" + "홍길동\t" + "2022-07-08\n");
          System.out.println(3 + "\t제목입니다.3\t" + 31 + "\t" + "홍길동\t" + "2022-07-08");
          System.out.printf("%d\t%s\t%d\t%s\t%s\n", 4, "제목입니다.4", 45, "홍길동", "2022-07-08");
        } else if (menuNo ==2) {
          System.out.println("-----------------------------------");
          System.out.println("[게시글 상세보기]");

          System.out.printf("번호: %d\n", 1);
          System.out.printf("제목: %s\n", title);
          System.out.printf("내용: %s\n", content);
          System.out.printf("조회수: %d\n", 100);
          System.out.printf("작성자: %s\n", writer);
          System.out.printf("등록일: %s\n", "2022-07-08");
        } else if (menuNo ==3) {
          System.out.println("-----------------------------------");
          System.out.println("[게시글 등록]");

          System.out.print("\n제목? ");
          title = keyboardInput.nextLine(); 
          System.out.print("\n내용? ");
          content = keyboardInput.nextLine(); 
          System.out.print("\n작성자? ");
          writer = keyboardInput.nextLine(); 
          System.out.print("\n암호? ");
          password = keyboardInput.nextLine(); 
          
        } else {
          System.out.println("메뉴 번호가 옳지 않습니다!");
        }
        System.out.println();
      }// while
      System.out.println("안녕히 가세요!");
      keyboardInput.close();
    }
}
