package com.eomcs.quiz.ex01;

// [문제] 
// 두 위치의 비트 값을 맞교환 하라! 
// 예) 값:   0b00101100_01110001
//     2번째(2^2 자리) 비트와 13번째(2^13 자리) 비트
//     결과: 0b00001100_01110101
//  
// [훈련 목표]
// - 관계 연산자 및 비트 연산자, 비트 이동 연산자 활용
// - 반복문 활용
// - 메서드 파라미터 및 리턴 값 다루기
//
public class Test03 {

  public static void main(String[] args) {
    int r = swapBits(0b01110001, 2, 5);
    System.out.println(r == 0b01010101); // true


    r = swapBits(0b00101100_01110001, 2, 13);
    System.out.println(r == 0b00001100_01110101); // true

    r = swapBits(0b01010111_01100011, 6, 10);
    System.out.println(r == 0b01010111_01100011); // true
  }

  static int swapBits(int value, int i, int j) {
    int ci = (value>>i) & 1; 
    int cj = (value>>j) & 1; 
    if ((ci+cj) == 1) {
      if (ci > cj) {
        value ^= (1 << i);
        value |= (1 << j);
      } else {
        value ^= (1 << j);
        value |= (1 << i);
      }
    }
    return value;
  }

}
// 이 메서드를 완성하시오!
// i를 i만큼 쉬프트 j를 j만큼 쉬프트하고 최하위비트로 추출
// 추출(i + j) 가 1이라면 스왑을 할꺼야
// 근데 추출i가 추출j보다 크다면 i를 j만큼 <<한 후 1 xor, j는 i만큼 <<한후 1 or
