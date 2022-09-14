// 반복문 15552 빠른 A+B 

package com.bitcamp.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main6 {
  public static void main(String[] args) throws IOException {
    try (
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

      int count = Integer.parseInt(br.readLine());

      for (int i = 0; i < count; i++) {
        String sum = br.readLine();
        int a = Integer.parseInt(sum.split(" ")[0]);
        int b = Integer.parseInt(sum.split(" ")[1]);

        bw.write(a+b + "\n");
      }
      bw.flush();
    }
  }

}