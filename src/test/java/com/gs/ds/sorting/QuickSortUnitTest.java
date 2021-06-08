package com.gs.ds.sorting;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class QuickSortUnitTest {

    @Test
    public void test_quick_sort() {
        int[] testArray = new int[]{4, 6, 1, 53, 22,};
        int[] expectedArray = new int[]{1, 4, 6, 22, 53};

        QuickSort.sortIntArray(testArray);

        assertThat(testArray, is(equalTo(expectedArray)));
    }
}
