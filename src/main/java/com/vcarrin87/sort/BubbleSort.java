package com.vcarrin87.sort;

/**
* Bubble sort is good when sequential access is much faster than random access, 
* and you can only keep two objects in memory.
* It is also good when the data is already mostly sorted,
* as it can be made to stop early if no swaps are made in a pass.
* It is a simple sorting algorithm that repeatedly steps through the list,
* compares adjacent elements and swaps them if they are in the wrong order.
* The pass through the list is repeated until the list is sorted.
* The algorithm gets its name from the way smaller elements "bubble" to the top of the list.
* Bubble Sort is simple but inefficient for large datasets. For better performance, consider algorithms like Merge Sort, Quick Sort, or Heap Sort.
* Usage:
*       int[] arr = {64, 34, 25, 12, 22, 11, 90};
*
*        System.out.println("Unsorted array:");
*       BubbleSort.printArray(arr);
*
*       BubbleSort.sort(arr);
*
*        System.out.println("\nSorted array:");
*        BubbleSort.printArray(arr);
 */

public class BubbleSort {

    private BubbleSort() {}

    public static void sort(int[] arr) {
        int n = arr.length;

        // Controls the number of passes. After each pass, the largest unsorted element 
        // is placed in its correct position. Runs n-1 times because after n-1 passes, the array is sorted.
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
