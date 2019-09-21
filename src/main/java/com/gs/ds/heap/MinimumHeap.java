package com.gs.ds.heap;

/**
 * @author G808286
 */
public class MinimumHeap<T extends Comparable> extends Heap<T> {
    public MinimumHeap(Class<T> clazz) {
        super(clazz);
    }

    public MinimumHeap(Class<T> clazz, int size) {
        super(clazz, size);
    }

    @Override
    public void siftDown(int index) {
        int leftIndex = getLeftChildIndex(index);
        int rightIndex = getRightChildIndex(index);
        int smallerIndex = -1;

        if(leftIndex != -1 && rightIndex != -1){
            smallerIndex = getElementAtIndex(leftIndex).compareTo(getElementAtIndex(rightIndex)) < 0 ? leftIndex: rightIndex;
        }

        if(leftIndex != -1){
            smallerIndex = leftIndex;
        }

        if(rightIndex != -1){
            smallerIndex = rightIndex;
        }

        if(smallerIndex == -1){
            return;
        }

        if(getElementAtIndex(smallerIndex).compareTo(getElementAtIndex(index)) < 0) {
            swapElements(smallerIndex, index);
            siftDown(smallerIndex);
        }
    }

    @Override
    public void siftUp(int index) {
        int parentIndex = getParentIndex(index);

        if(parentIndex != -1) {
            if (getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) < 0) {
                swapElements(parentIndex,index);
                siftUp(parentIndex);
            }
        }
    }
}
