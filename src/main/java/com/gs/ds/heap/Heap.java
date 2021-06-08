package com.gs.ds.heap;

import java.lang.reflect.Array;

public abstract class Heap <T extends Comparable> {
    T[] array;
    int size = 0;
    private int maxSize = 40;

    public int getMaxSize() {
        return maxSize;
    }

    public Heap(Class<T> clazz) {
        array = (T[]) Array.newInstance(clazz, maxSize);
    }

    public Heap(Class<T> clazz, int size){
        maxSize = size;
        array = (T[]) Array.newInstance(clazz,size);
    }

    public int getLeftChildIndex(int nodeIndex) {
        int leftChildIndex = (2 * nodeIndex) + 1;

        if (leftChildIndex > size) {
            leftChildIndex = -1;
        }

        return leftChildIndex;
    }

    public int getRightChildIndex(int index) {
        int rightChildIndex = (2 * index) + 2;

        if (rightChildIndex > size) {
            rightChildIndex = -1;
        }

        return rightChildIndex;
    }

    public int getParentIndex(int index) {
        int parentIndex = (index - 1) / 2;

        if (parentIndex < 0) {
            parentIndex = -1;
        }

        return parentIndex;
    }

    public T getElementAtIndex(int index) {
        return array[index];
    }

    public void swapElements(int firstIndex, int secondIndex) {
        T temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    public int getSize() {
        return size;
    }

    public abstract void siftDown(int index);
    public abstract void siftUp(int index);
    public void insert(T value) throws IllegalStateException {
        if (getSize() >=  getMaxSize()) {
            throw new IllegalStateException("Heap Full");
        }
        size++;
        array[size-1] = value;
        siftUp(size-1);
    }

    public T getMaxPriorityElement() throws IllegalStateException {
        if(size < 1) {
            throw new IllegalStateException("Heap Empty");
        }
        T value = array[0];
        array[0] = array[size-1];
        size--;
        siftDown(0);
        return value;
    }
}

