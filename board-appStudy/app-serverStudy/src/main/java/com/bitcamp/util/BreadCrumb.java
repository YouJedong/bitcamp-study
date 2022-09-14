package com.bitcamp.util;

import java.util.Stack;

public class BreadCrumb {

  public Stack<String> menuStack = new Stack<>();

  static ThreadLocal<BreadCrumb> localManager = new ThreadLocal<>();

  public static BreadCrumb getBreadCrumbOfCurrentThread() {

    return localManager.get();
  }

  public BreadCrumb() {

    localManager.set(this);
  }

  public void put(String menu) {
    menuStack.push(menu);
  }
  public void pickUp() {
    menuStack.pop();
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for (String title : menuStack) {
      if (!builder.isEmpty()) {
        builder.append(" > ");
      }
      builder.append(title);
    }
    return builder.toString();
  }
}
