package com.bitcamp.study;

import java.util.Scanner;

public class myTest {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int M = sc.nextInt();

    if ((M - 45) < 0) { 
      if (H == 0) {
        H = 24;
      }
      System.out.print(--H);    
      System.out.print(M + 15); 
    } else {
      System.out.print(H);
      System.out.print(M - 45);
    }
  }
}
