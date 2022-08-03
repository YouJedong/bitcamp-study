package com.eomcs.quiz.ex01;

// [문제]
// 양의 정수 x를 2진수로 표현했을 때 1 값을 갖는 비트 개수를 정수의 무게라고 정의하자. 
// 같은 무게를 가지는 양의 정수 중에서 x와 가장 가까운 양의 정수를 구하시오!
// 예) x = 0b0000_1010 (10)
//   x와 같은 무게를 가지는 정수들
//     0b0000_1001 (9)
//     0b0000_1100 (12)
//     0b0001_0010 (18)
//     ...
//   답: 0b0000_1001 (9)
//
// [훈련 목표]
// - 2진수를 다루는 방법
// - 연산자, 흐름제어문을 다루는 방법
//
// [시간 복잡도]
// - ?
//
public class Test06 {

  public static void main(String[] args) {
    System.out.println(closestIntSameBit(0b00001010) == 0b00001001); // 10 ==> 9
    System.out.println(closestIntSameBit(0b11001000) == 0b11000100); // 200 ==> 196
  }

  static int closestIntSameBit(int x) {
    // 이 메서드를 완성하시오!
    for (int i = 0; i < 31; i++) {
      int bit1 = (x >>> i) & 1;
      int bit2 = (x >>> i + 1) & 1;

      if (bit1 != bit2) {
        x ^= (1 << i) + (1 << i + 1);
        return x;
      }
    }
    throw new RuntimeException("비트모두 1이거나 0입니다.");
  }
}