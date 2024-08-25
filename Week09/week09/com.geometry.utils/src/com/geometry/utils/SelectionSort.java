package com.geometry.utils;

public class SelectionSort {
    public static void sortArray(Comparable[] arr) {
        Comparable temp;
        int index;

        for(int i = 0; i < arr.length; i++) {
            index = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[index].compareTo(arr[j]) > 0) {
                    index = j;
                }
            }
            if(index != i) {
                temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
