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

  /**
   * 목록에서 인덱스에 해당하는 항목을 찾아 리턴한다.
   * @param index 목록에 저장된 항목의 인덱스
   * @return index에 저장된 항
   * @throws ListException 인덱스가 무효
   */

  public Object get(int index) /* throws ListException */ {
    if (index < 0 || index >= size) {
      throw new ListException("인덱스가 무효함!"); 
    }

    return elementDate[index]; // 리턴 타입은 Object
  }

  public boolean remove(int index) /* throws ListException */ {
    if (index < 0 || index >= size) {
      throw new ListException("인덱스가 무효합니다!");

    }

    for (int i = index + 1; i < size; i++) {
      elementDate[i - 1] = elementDate[i];
    }

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
