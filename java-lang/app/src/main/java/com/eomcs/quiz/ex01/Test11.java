package com.eomcs.quiz.ex01;

// 출처: codefights.com
//
// 소문자 알파벳의 문자열이 주어질 때, 서로 다른 알파벳의 개수는?
//
// 예) "cabca" ==> 3
//
/*
Given a string, find the number of different characters in it.

for "cabca" output should be 3

[input] string s

a string of lowercase latin letters
[output] integer
 */
//
// [시간 복잡도]
// - ?
//
public class Test11 {

  public static void main(String[] args) {
    System.out.println(differentSymbolsNaive("cabca") == 3);
  }

  static int differentSymbolsNaive(String s) {
    int result = 0;
    // 이 메서드를 완성하시오!
    for (int i = 'a'; i <= 'z'; i++) {
      //      System.out.println('a' + i);
      for (int x = 0; x < s.length(); x++) {
        char c = s.charAt(x);
        if (c == i) {
          result++;
          break;
        }
      }
    }
    return result;
  }
}
