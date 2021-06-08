package com.gs.ds.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeSortTest {

    @Test
    public void test_merge_sort() {
        int[] testArray = new int[]{4, 6, 1, 53, 22,};
        int[] expectedArray = new int[]{1, 4, 6, 22, 53};

        MergeSort.mergeSort(testArray);

        assertEquals(testArray.length, expectedArray.length);
        for(int i = 0; i < expectedArray.length; i++){
            assertEquals(expectedArray[i], testArray[i]);
        }
    }
}
