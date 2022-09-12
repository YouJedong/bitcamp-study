package com.bitcamp.study;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int M = sc.nextInt();
    int needTime = sc.nextInt();
    int finalM = (H * 60) + M + needTime;

    if (finalM >= 1440) {
      int result = finalM - 1440;
      System.out.println((result / 60) + " " + (result % 60));
    } else {
      System.out.println((finalM / 60) + " " + (finalM % 60));
    }
    sc.close();
  }
}