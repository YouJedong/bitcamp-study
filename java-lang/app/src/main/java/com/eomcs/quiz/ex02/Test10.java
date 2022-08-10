package com.eomcs.quiz.ex02;

// copyright by codefights.com
// 
// 양의 정수가 주어질 때
// 오직 4와 7로만 이루어진 수인지 검사하라!
// 예)
//   isLuckyNumber(4744) ==> true
//   isLuckyNumber(4754) ==> false
//
/*
Lucky numbers are the positive integers 
whose decimal representations contain only the lucky digits 4 and 7

[input] integer n
a positive integer

[output] boolean
true if n is a lucky number, false otherwise
 */
//
// [시간 복잡도]
// - ? 
//
public class Test10 {

  public static void main(String[] args) {
    System.out.println(isLuckyNumber(4744) == true);
    System.out.println(isLuckyNumber(4754) == false);
    System.out.println(isLuckyNumber(4744447) == true);
  }

  static boolean isLuckyNumber(int n) {
    for (int i = 0; n < 0; i++) {
      int value = n % 10;
      if (value != 4 || value != 7) {
        return false;
      }
      n /= 10;
    }
    return true;
  }

}
