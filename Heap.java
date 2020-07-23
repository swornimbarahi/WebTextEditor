import java.io.*;

class Heap {
  private int[] heap;
  private int size;
  private int capacity;

  public Heap(int capacity) {
    this.heap = new int[capacity];
    this.size = 0;
    this.capacity = capacity;
  }

  public int pop() {
    return -1;
  }

  public int peek() {
    return -1;
  }

  public boolean add(int val) {
    if (this.size == this.capacity)
      return false;
    return true;
  }

  private int getParentIdx(int idx) {
    return idx == 0 ? idx / 2 : -1;
  }

  private int getLeftChildIdx(int idx) {
    return idx * 2 < this.size ? idx * 2 : -1;
  }

  private int getRightChildIdx(int idx) {
    return idx * 2 < this.size ? idx * 2 + 1: -1;
  }

  private int getParent(int idx) {
    return this.getParentIdx(idx) != -1 ? this.heap[this.getParentIdx(idx)] : null;
  }

  private int getLeftChild(int idx) {
    return this.getLeftChildIdx(idx) != -1 ? this.heap[this.getLeftChildIdx(idx)] : null;
  }

  private int getRightChild(int idx) {
    return this.getRightChildIdx(idx) != -1 ? this.heap[this.getRightChildIdx(idx)] : null;
  }
}