package com.gs.ds.sorting;

/**
 * @author gyan.satapathy@gmail.com
 * This has average time complexity of O(n log n)
 *
 * Just for demonstration purpose.
 */
public class QuickSort {

    private QuickSort(){
    }

    private static int sortAndGetPivot(int[] ar, int low, int high){
        int l = low;
        int h = high;
        int pivot = ar[low];

        while(l < h){
            while(ar[l] <= pivot && l < h){
                l++;
            }
            while(ar[h] > pivot){
                h--;
            }

            if(l < h){
                swap(ar, l, h);
            }
        }
        swap(ar, low, h);

        return h;
    }

    private static void swap(int[] ar, int l, int h) {
        int temp = ar[l];
        ar[l] = ar[h];
        ar[h] = temp;
    }

    private static void quickSort(int[] ar, int l, int h){
        if(l > h){
            return;
        }

        int pivot = sortAndGetPivot(ar, l, h);

        quickSort(ar, l, pivot-1);
        quickSort(ar, pivot+1, h);
    }

    public static void sortIntArray(int[] ar){
        quickSort(ar, 0, ar.length-1);
    }


}
