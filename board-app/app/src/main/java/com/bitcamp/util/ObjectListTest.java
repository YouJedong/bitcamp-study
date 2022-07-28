package com.bitcamp.util;


public class ObjectListTest {

  public static void main(String[] args) throws Throwable {

    ObjectList list = new ObjectList ();
    list.add("임꺽정");
    list.add("유관순");
    list.add(null);
    list.add("안중근");

    System.out.println(list.get(0));

    System.out.println(list.get(1));

    System.out.println(list.get(2));


    System.out.println(list.get(3));

  }
}
