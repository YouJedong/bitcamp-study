package com.bitcamp.study;

import java.util.Scanner;

public class myTest {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] chess = {1, 1, 2, 2, 2, 8};
    int[] inChess = new int[6];

    for(int i = 0; i < inChess.length; i++) {
      inChess[i] = sc.nextInt();
      System.out.print(chess[i] - inChess[i] + " ");
    }
  }
}


