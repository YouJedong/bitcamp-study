/*
 * 키보드 입력을 받는 도구를 구비하고 있다.
 * 비트캠프-20220704
 */
package com.bitcamp.board;

public class Prompt {

  static java.util.Scanner keyboardInput = new java.util.Scanner(System.in); 

  static int inputInt() {
    String str = keyboardInput.nextLine(); 
    return Integer.parseInt(str);
  }

  static int inputInt(String title) {
    System.out.print(title + " ");
    String str = keyboardInput.nextLine(); 
    return Integer.parseInt(str);
  }

  static char inputStringToChar(String ask) {
    System.out.println(ask);
    String charac  = keyboardInput.nextLine(); 
    return charac.charAt(0);
  }

  static String inputString () {
    return keyboardInput.nextLine(); 
  }

  static String inputString (String title) {
    System.out.print(title);
    return keyboardInput.nextLine(); 
  }

  static void close() {
    keyboardInput.close();
  }
}
