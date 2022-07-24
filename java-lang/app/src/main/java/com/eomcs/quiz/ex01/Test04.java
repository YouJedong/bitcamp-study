package com.eomcs.quiz.ex01;

// 출처: codefights.com
//
// 주어진 숫자에 짝수가 몇 개인지 세어라.
// 예) 
// 1010 => 2
// 123 => 1
//
public class Test04 {

  public static void main(String[] args) {
    System.out.println(countEvenNumber(12323) == 2);
    System.out.println(countEvenNumber(1238694636) == 6);
    System.out.println(countEvenNumber(2567884) == 5);
  }
  static int countEvenNumber(int value) {
    int result = 0;
    if (value == 0)
      result++;
    while (value != 0) {
      if (value < 10) {
        if ((value % 2) == 0) 
          result++;
        break;
      } else {
        if ((value & 1) == 0) 
          result++;
        value /= 10;
      }
    }
    return result;
  }
}
//이 메서드를 완성하시오!
// 반복문으로 만약 10보다 작다면 그냥 (i % 2) == 0 일때 result++ 브레이
// 만약 10보다 크면 최하위비트추출해서 0이면 result++
// 그 후 value 나누기 10 
// 0이 될때까지
