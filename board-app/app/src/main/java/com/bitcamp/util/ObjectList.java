package com.bitcamp.util;

public class ObjectList {

  private static final int DEFAULT_CAPACITY = 10;

  private int size;
  private Object[] elementDate;

  public ObjectList () {
    elementDate = new Object[DEFAULT_CAPACITY];
  }
  public ObjectList (int initialCapacity) {
    elementDate = new Object[initialCapacity];
  }

  public void add(Object e) {
    if (size == elementDate.length) {
      grow();
    }

    elementDate[size++] = e;
  } 

  public Object[] toArray() {
    Object[] arr = new Object[size];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = elementDate[i];
    }
    return arr;
  }

  // 예외를 보고하는 메서드인 경우
  // 메서드 선언부에 어떤 예외를 보고하는지 표시해야 한다.
  // => 오류가 발생했을 때 예외 정보를 던지는 메서드인 경우
  //    메서드 선언부에 던지는 예외 정보의 타입을 표시해야한다.
  public Object get(int index) throws Throwable {
    if (index < 0 || index >= size) {
      throw new Throwable("인덱스가 무효함!"); 
    }

    return elementDate[index]; // 리턴 타입은 Object
  }

  // 예외를 보고하는 메서드인 경우
  // 메서드 선언부에 어떤 예외를 보고하는지 표시해야 한다.
  public boolean remove(int index) throws Throwable {
    if (index < 0 || index >= size) {
      throw new Throwable("인덱스가 무효합니다!");

    }

    // 삭제할 항목의 다음 항목을 앞으로 당긴다.
    for (int i = index + 1; i < size; i++) {
      elementDate[i - 1] = elementDate[i];
    }

    // 게시글 개수를 한 개 줄인 후 
    // 맨 뒤의 있던 항목의 주소를 0으로 설정한다.
    elementDate[--size] = null;

    return true;
  }

  public int size() {
    return size;
  }


  private void grow() {
    int newCapacity = elementDate.length + (elementDate.length >> 1);
    Object[] newArray = new Object[newCapacity];
    for (int i = 0; i < elementDate.length; i++) {
      newArray[i] = elementDate[i];
    }
    elementDate = newArray;
  }

}
