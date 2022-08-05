package com.eomcs.design_pattern.iterator.after2;

public class Queue<E> extends LinkedList<E> {

  public void offer(E value) {
    this.add(value);
  }

  public E poll() {
    return this.remove(0);
  }

  public boolean empty() {
    return this.size == 0;
  }

  @Override
  public Iterator<E> iterator() {
    return new QueIteratorue<E>(this);
  }

  static class QueIteratorue<E> implements Iterator<E>{

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

}


