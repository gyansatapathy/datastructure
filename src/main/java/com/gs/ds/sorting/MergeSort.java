package com.gs.ds.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author gyan.satapathy@gmail.com
 * This has average time complexity of O(n log n)
 * has space complexity O(n)
 *
 * Just for demonstration purpose.
 */
public class MergeSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ar = new int[n];

        for(int i = 0; i < n; i++){
            ar[i] = sc.nextInt();
        }

        mergeSort(ar);

        System.out.println(Arrays.toString(ar).replaceAll(" ", ""));

    }

    private static void merge(int[] ar, int[] fL, int[] sL){

        int mergedIndex = 0;
        int firstIndex = 0;
        int secondIndex = 0;

        /*
        Compare and merge both sublist to main list
         */
        while(firstIndex < fL.length && secondIndex < sL.length){
            if(fL[firstIndex] <= sL[secondIndex]){
                ar[mergedIndex] = fL[firstIndex];
                firstIndex++;
            }  else if(sL[secondIndex] < fL[firstIndex]){
                ar[mergedIndex] = sL[secondIndex];
                secondIndex++;
            }

            mergedIndex++;
        }

        /*
        Copy over left over elements to main array.
         */
        while(firstIndex < fL.length){
            ar[mergedIndex++] = fL[firstIndex++];

        }

        /*
        copy over left over elements to main array
         */
        while(secondIndex < sL.length){
            ar[mergedIndex++] = sL[secondIndex++];
        }

    }

    public static void mergeSort(int ar[]){
        int n = ar.length;

        if(n == 1){
            return;
        }

        int midIndex = n/2 + n%2;

        int[] firstHalf = new int[midIndex];
        int[] secondHalf = new int[n - midIndex];
        split(ar, firstHalf, secondHalf);

        mergeSort(firstHalf);
        mergeSort(secondHalf);

        merge(ar, firstHalf, secondHalf);

    }


    private static void split(int[] ar, int[] fL, int[] sL){
        for(int i = 0; i < ar.length; i++){
            if(i < fL.length){
                fL[i] = ar[i];
            } else {
                sL[i - fL.length] = ar[i];
            }
        }
    }
}