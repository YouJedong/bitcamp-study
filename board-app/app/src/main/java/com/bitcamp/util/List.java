package com.bitcamp.util;

public interface List {
  void add(Object value);
  Object get(int index);
  Object remove(int index);
  Object[] toArray();
  int size();
}
