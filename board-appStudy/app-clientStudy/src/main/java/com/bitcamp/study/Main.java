package com.bitcamp.study;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int oneD = sc.nextInt();
    int twoD = sc.nextInt();
    int threeD = sc.nextInt();        
    int bigNoing = oneD > twoD ? oneD : twoD;
    int bigNo = bigNoing > threeD ? bigNoing : threeD; 

    if ((oneD != twoD) && (oneD != threeD)) {

    }
  }
}