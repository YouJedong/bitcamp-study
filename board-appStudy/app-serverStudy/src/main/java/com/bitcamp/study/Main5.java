// 반복문 25304 영수

package com.bitcamp.study;

import java.util.Scanner;

class Main5 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int total = sc.nextInt();
    int count = sc.nextInt();
    int result = 0;

    for (int i = 0; i < count; i++) {
      result += sc.nextInt() * sc.nextInt();
    }
    if (result == total) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}