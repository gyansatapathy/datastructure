package com.gs.ds.heap;

public class HeapSort {

    static int[] arrayToSort;

    private static void percolateDown(int index, int endIndex) {
        int leftChildIndex = getLeftChildren(index, endIndex);
        int rightChildIndex = getrightChildren(index, endIndex);

        if (leftChildIndex != -1 && arrayToSort[leftChildIndex] > arrayToSort[index]) {
            swapElements(leftChildIndex, index);
            percolateDown(leftChildIndex, endIndex);
        }

        if (rightChildIndex != -1 && arrayToSort[rightChildIndex] > arrayToSort[index]) {
            swapElements(rightChildIndex, index);
            percolateDown(rightChildIndex, endIndex);
        }

    }

    private static int getLeftChildren(int index, int endIndex) {

        int leftChildrenIndex = (2 * index) + 1;

        if (leftChildrenIndex > endIndex) {
            return -1;
        }

        return leftChildrenIndex;
    }

    private static int getrightChildren(int index, int endIndex) {

        int rightChildrenIndex = (2 * index) + 2;

        if (rightChildrenIndex > endIndex) {
            return -1;
        }

        return rightChildrenIndex;
    }

    private static int getParentIndex(int index, int endIndex) {
        int parentIndex = -1;
        if (index > 0 && index <= endIndex) {
            parentIndex = (index - 1) / 2;
        }

        return parentIndex;
    }

    private static void swapElements(int index1, int index2) {
        int temp = arrayToSort[index1];
        arrayToSort[index1] = arrayToSort[index2];
        arrayToSort[index2] = temp;
    }

    private static void heapify(int endIndex) {
        int index = getParentIndex(endIndex, endIndex);
        while (index >= 0) {
            percolateDown(index, endIndex);
            index--;
        }
    }

    public static void main(String[] args) {
        arrayToSort = new int[]{4, 2, 4, 56, 7, 82, 1, 5, 9, 0};
        heapify(arrayToSort.length - 1);

        int endIndex = arrayToSort.length - 1;

        while (endIndex > 0) {
            swapElements(0, endIndex);
            endIndex--;
            percolateDown(0, endIndex);
        }

        for (int a : arrayToSort) {
            System.out.println(a);
        }
    }
}
