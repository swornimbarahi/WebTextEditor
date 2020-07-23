import java.io.*;

class Heap {
  private int[] storage;
  private int size;
  private int capacity;

  public Heap(int capacity) {
    storage = new int[capacity];
    size = 0;
    this.capacity = capacity;
  }

  public int pop() {
    if (size == 0)
      throw new IllegalStateException();
    int val = storage[0];
    storage[0] = storage[size - 1];
    size--;
    heapifyDown();
    return val;
  }

  public int peek() {
    if (size == 0)
      throw new IllegalStateException();
    return storage[0];
  }

  public boolean add(int val) {
    if (size == capacity)
      return false;
    storage[size] = val;
    heapifyUp();
    size++;
    return true;
  }

  private void heapifyUp() {
    int idx = size;
    while (hasParent(idx) && parent(idx) > storage[idx]) {
      swap(idx, getParentIdx(idx));
      idx = getParentIdx(idx);
    }
  }

  private void swap(int idx1, int idx2) {
    int temp = storage[idx1];
    storage[idx1] = storage[idx2];
    storage[idx2] = temp;
  }

  public void heapifyDown() {
    int idx = 0;
    while (hasLeftChild(idx)) {
      int smallerIdx = getLeftChildIdx(idx);
      if (hasRightChild(idx) && rightChild(idx) < leftChild(idx)) {
        smallerIdx = getRightChildIdx(idx);
      }
      if (storage[idx] < storage[smallerIdx])
        break;
      swap(idx, smallerIdx);
      idx = smallerIdx;
    }
  }

  private int getParentIdx(int idx) {
    return (idx - 1) / 2;
  }

  private int getLeftChildIdx(int idx) {
    return idx * 2 + 1;
  }

  private int getRightChildIdx(int idx) {
    return idx * 2 + 2;
  }

  private int parent(int idx) {
    return storage[getParentIdx(idx)];
  }

  private int leftChild(int idx) {
    return storage[getLeftChildIdx(idx)];
  }

  private int rightChild(int idx) {
    return storage[getRightChildIdx(idx)];
  }

  private boolean hasParent(int idx) {
    return getParentIdx(idx) >= 0;
  }

  private boolean hasLeftChild(int idx) {
    return getLeftChildIdx(idx) < size;
  }

  private boolean hasRightChild(int idx) {
    return getRightChildIdx(idx) < size;
  }

  public void print() {
    for (int i = 0; i < size; i++)
      System.out.println(storage[i]);
  }
}