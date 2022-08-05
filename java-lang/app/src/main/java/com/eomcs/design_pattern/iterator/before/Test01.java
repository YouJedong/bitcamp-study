package com.eomcs.design_pattern.iterator.before;

import java.util.HashSet;

public class Test01 {

  public static void main(String[] args) {
    ArrayList<String> list1 = new ArrayList<>();
    list1.add("aaa");
    list1.add("bbb");
    list1.add("ccc");
    list1.add("ddd");

    LinkedList<String> list2 = new LinkedList<>();
    list2.add("aaa2");
    list2.add("bbb2");
    list2.add("ccc2");
    list2.add("ddd2");

    Stack<String> list3 = new Stack<>();
    list3.push("aaa3");
    list3.push("bbb3");
    list3.push("ccc3");
    list3.push("ddd3");

    Queue<String> list4 = new Queue<>();
    list4.offer("aaa4");
    list4.offer("bbb4");
    list4.offer("ccc4");
    list4.offer("ddd4");

    HashSet<String> list5 = new HashSet<>();
    list5.add("aaa5");
    list5.add("bbb5");
    list5.add("ccc5");
    list5.add("ddd5");


    // 목록에서 값 꺼내기
    for (int i = 0; i < list1.size(); i++) {
      System.out.println(list1.get(i));
    }
    System.out.println("------------------------------------");

    for (int i = 0; i < list2.size(); i++) {
      System.out.println(list2.get(i));
    }
    System.out.println("------------------------------------");

    while (!list3.empty()) {
      System.out.println(list3.pop());
    }
    System.out.println("------------------------------------");

    while (!list4.empty()) {
      System.out.println(list4.poll());
    }
    System.out.println("------------------------------------");

    String[] arr = list5.toArray(new String[0]); 
    for (String s : arr) {
      System.out.println(s);
    }
    System.out.println("------------------------------------");



  }


}









