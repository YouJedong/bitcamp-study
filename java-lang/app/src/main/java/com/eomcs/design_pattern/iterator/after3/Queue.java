package com.eomcs.design_pattern.iterator.after3;

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
    return new QueIteratorue<E>();
  }

  class QueIteratorue<T> implements Iterator<T>{


    @Override
    public boolean hasNext() {
      return !Queue.this.empty();
    }
    @SuppressWarnings("unchecked")
    @Override
    public T next() {
      return (T) Queue.this.poll();
    }  
  }

}


