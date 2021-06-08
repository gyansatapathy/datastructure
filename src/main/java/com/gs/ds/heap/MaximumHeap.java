package com.gs.ds.heap;

public class MaximumHeap<T extends Comparable> extends Heap {
    public MaximumHeap(Class clazz) {
        super(clazz);
    }

    public MaximumHeap(Class clazz, int size) {
        super(clazz, size);
    }

    public void siftDown(int index) {
        int leftIndex = getLeftChildIndex(index);
        int rightIndex = getRightChildIndex(index);
        int largerIndex = -1;

        if (leftIndex != -1 && rightIndex != -1) {
            largerIndex = getElementAtIndex(leftIndex).compareTo(getElementAtIndex(rightIndex)) > 0 ? leftIndex : rightIndex;
        }

        if (leftIndex != -1) {
            largerIndex = leftIndex;
        }

        if (rightIndex != -1) {
            largerIndex = rightIndex;
        }

        if (largerIndex == -1) {
            return;
        }

        if (getElementAtIndex(largerIndex).compareTo(getElementAtIndex(index)) > 0) {
            swapElements(largerIndex, index);
            siftDown(largerIndex);
        }
    }

    public void siftUp(int index) {
        int parentIndex = getParentIndex(index);

        if (parentIndex != -1) {
            if (getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) > 0) {
                swapElements(parentIndex, index);
                siftUp(parentIndex);
            }
        }
    }
}
