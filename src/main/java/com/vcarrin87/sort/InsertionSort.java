package com.vcarrin87.sort;

/*
Insertion Sort is an efficient algorithm for ordering a small number of items. This method is based on the way card
players sort a hand of playing cards.

We start with an empty left hand and the cards laid down on the table. We then remove one card at a time from the table
and insert it into the correct position in the left hand. To find the correct position for a new card, we compare it
with the already sorted set of cards in the hand, from right to left.

Usage:
    int[] arr = {12, 11, 13, 5, 6};
    System.out.println("Original array:");
    printArray(arr);

    sort(arr);

    System.out.println("\nSorted array:");
    printArray(arr);
 */
public class InsertionSort {

    private InsertionSort() {}

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
