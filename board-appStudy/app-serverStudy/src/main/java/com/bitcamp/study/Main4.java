// 반복문 8393 합 

package com.bitcamp.study;

import java.util.Scanner;

class Main4 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int lastNo = sc.nextInt();
    int result = 0;

    for (int i = 1; i <= lastNo; i++) {
      result += i;
    }
    System.out.println(result);

  }
}