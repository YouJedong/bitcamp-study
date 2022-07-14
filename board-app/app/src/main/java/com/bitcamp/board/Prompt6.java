/*
 * 게시판 관리 애플리케이션 7/14일 자습 중 게시판 만들기
 * 비트캠프-20220704
 */
package com.bitcamp.board;

public class Prompt6 {
 
  static java.util.Scanner keyboardInput = new java.util.Scanner(System.in);
  
  static int inputInt() {
    String str = keyboardInput.nextLine();
    return Integer.parseInt(str);
  }

  static int inputInt(String askNo) {
    System.out.print(askNo);
    String str = keyboardInput.nextLine();
    return Integer.parseInt(str);
  }





  static String inputString (String askContents) {
    System.out.print("\n" + askContents + " ");
    return keyboardInput.nextLine();
  }
  
  static void close() {
    keyboardInput.close();
  }
  

}
