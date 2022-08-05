package com.eomcs.design_pattern.iterator.after1;

public class QueIteratorue<E> implements Iterator<E>{

  Queue<E> list;

  public QueIteratorue(Queue<E> list) {
    this.list = list;
  }
  @Override
  public boolean hasNext() {
    return !list.empty();
  }
  @Override
  public E next() {
    return list.poll();
  }  
}
