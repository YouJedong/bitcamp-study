package com.bitcamp.board0721.dao;

public class ObjectList {

  private static final int DEFAULT_SIZE = 3;

  protected int length; // boardCount, memberCount
  protected Object[] list; //boards, members

  public ObjectList () {
    this.list = new Object[DEFAULT_SIZE]; 
  }
  public ObjectList (int initCapacity) {
    this.list = new Object[initCapacity]; 
  }

  public Object[] toArray() {
    Object[] arr = new Object[this.length];
    for (int i = 0; i < length; i++) {
      arr[i] = this.list[i];
    }
    return arr;
  }

  public Object get(int index) {
    if (index < 0 || index >= this.length) {
      return null;  
    }
    return list[index]; //하지만 이거 안씀 다 오버라이딩
  }

  public void add(Object obj) {
    if (this.length == this.list.length) {
      grow();
    }

    list[length++] = obj; //length가 배열안에 있으면 다음 게시글(회원)을 뜻
  }

  public boolean remove(int index) {
    if (index < 0 || index >= length) {              //////// 여기 바꾸야하나?
      return false;
    }
    for (int i = index + 1; i < this.length; i++) {   //// 여기도 보자 
      this.list[i - 1] = this.list[i];   // index는 삭제할 게시글, index + 1은 삭제할 게시글의 다음 게시
    }
    this.list[--this.length] = null;

    return true;
  }


  private void grow () {
    int newSize = this.list.length + (this.list.length >> 1);
    Object[] newArray = new Object[newSize];
    for (int i = 0; i < this.list.length; i++) {
      newArray[i] = this.list[i]; 
    }
    this.list = newArray;
  }
}
