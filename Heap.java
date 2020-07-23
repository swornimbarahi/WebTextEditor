import java.io.*;

class Heap {
  private int[] storage;
  private int size;
  private int capacity;

  public Heap(int capacity) {
    this.storage = new int[capacity];
    this.size = 0;
    this.capacity = capacity;
  }

  public int pop() {
    return -1;
  }

  public int peek() {
    return this.size != 0 ? this.storage[0] : null;
  }

  public boolean add(int val) {
    if (this.size == this.capacity)
      return false;
    this.storage[this.size] = val;
    this.bubbleUp();
    this.size++;
    return true;
  }

  private void bubbleUp() {
    int idx = this.size;
    while (this.getParentIdx(idx) != -1 && this.getParent(idx) > this.storage[idx]) {
      this.swap(idx, this.getParentIdx(idx));
      idx = this.getParentIdx(idx);
    }
  }

  private void swap(int idx1, int idx2) {
    int temp = this.storage[idx1];
    this.storage[idx1] = this.storage[idx2];
    this.storage[idx2] = temp;
  }

  public void bubbleDown() {
    throw new UnsupportedOperationException("This method will be implemented in the next update.");
  }

  private int getParentIdx(int idx) {
    return idx == 0 ? idx / 2 : -1;
  }

  private int getLeftChildIdx(int idx) {
    return idx * 2 < this.size ? idx * 2 : -1;
  }

  private int getRightChildIdx(int idx) {
    return idx * 2 < this.size ? idx * 2 + 1 : -1;
  }

  private int getParent(int idx) {
    return this.getParentIdx(idx) != -1 ? this.storage[this.getParentIdx(idx)] : null;
  }

  private int getLeftChild(int idx) {
    return this.getLeftChildIdx(idx) != -1 ? this.storage[this.getLeftChildIdx(idx)] : null;
  }

  private int getRightChild(int idx) {
    return this.getRightChildIdx(idx) != -1 ? this.storage[this.getRightChildIdx(idx)] : null;
  }
}