package com.eomcs.concurrent;

public class MyThreadTest extends Thread {

  int count;

  public MyThreadTest(int count) {
    this.count = count;
  }

  @Override
  public void run() {
    for (int i = 0; i < count; i++) {
      System.out.println("==> " + i);
    }
  }



}
