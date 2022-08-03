package com.bitcamp2.util;

public class LinkedList {
  int size;
  Node head;
  Node tail;

  public void append(Object value) {
    Node node = new Node(value);

    size++;

    if(tail == null) {
      head = tail = node;
      return;
    }

    tail.next = node;
    node.priv = tail;
    tail = node;
  }

  public Object retrieve(int index) {
    if (index < 0 || index >= size) {
      throw new ListException("인덱스가 무효함");
    }
    Node cursor = head;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }

    return cursor.value;
  }

  public Object delete (int index) {
    if (index < 0 || index >= size) {
      throw new ListException("인덱스가 무효함");
    }
    size--;

    Object deleted;

    if (tail == head) {
      deleted = head.value;
      head.value = null;
      head = tail = null;
      return deleted;
    }

    Node cursor = head;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }

    if (cursor.priv != null) {

    }
  }

}
