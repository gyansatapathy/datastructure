package com.gs.ds.heap;

import org.junit.Test;

public class HeapImplTest {

    @Test
    public void insert_element_to_min_heap(){
        MinimumHeap<Integer> minimumHeap = new MinimumHeap<Integer>(Integer.class,10);
        minimumHeap.insert(5);
        minimumHeap.insert(2);

        minimumHeap.insert(1);
        minimumHeap.insert(19);
        minimumHeap.insert(1);
        assert(minimumHeap.getMaxPriorityElement() == 1);
        assert(minimumHeap.getSize() == 4);
    }

    @Test
    public void insert_element_to_max_heap(){
        MaximumHeap<Integer> maxHeap = new MaximumHeap<Integer>(Integer.class,10);
        maxHeap.insert(5);
        maxHeap.insert(2);

        maxHeap.insert(1);
        maxHeap.insert(19);
        maxHeap.insert(1);
        assert((Integer) maxHeap.getMaxPriorityElement() == 19);
        assert(maxHeap.getSize() == 4);
    }

    @Test(expected = IllegalStateException.class)
    public void insert_element_to_max_heap_beyond_its_limit() {
        MaximumHeap<Integer> maxHeap = new MaximumHeap<Integer>(Integer.class,4);
        maxHeap.insert(5);
        maxHeap.insert(2);

        maxHeap.insert(1);
        maxHeap.insert(19);
        maxHeap.insert(1);
    }

    @Test(expected = IllegalStateException.class)
    public void retrieve_element_to_empty_heap() {
        MaximumHeap<Integer> maxHeap = new MaximumHeap<Integer>(Integer.class,4);
        maxHeap.getMaxPriorityElement();
    }
}
