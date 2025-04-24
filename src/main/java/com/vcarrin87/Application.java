package com.vcarrin87;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	   // Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            // If num is already in the countMap and its count is greater than 0, it means you have found a duplicate, so you return true.
            if (countMap.containsKey(num) && countMap.get(num) > 0) {
                return true;
            }
            // If num is not in the countMap or its count is 0, you add it to the countMap with a count of 1.
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        return false;
    }

    // Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    // You may assume that each input would have exactly one solution, and you may not use the same element twice.
    // You can return the answer in any order.
    public static int[] getIndices(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (indexMap.containsKey(diff)) {
                return new int[] { indexMap.get(diff), i };
            }
            indexMap.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    // Add two Numbers.
    public static int sumTwoNumbers(int num1, int num2) {
        return num1 + num2;
    }

    // Swap Two Numbers
    public static void swapTwoNumbers(int a, int b) {
        // Logic of XOR operator
//        a = a ^ b;
//        b = a ^ b;
//        a = a ^ b;

        // Using arithmetic operators
        a = (a + b) - (b = a);
        System.out.println("Value of a is " + a + " and Value of b is " + b);
    }

    // Find Factorial of a Number in Java.
    // use cases:
    // determining the number of trucks needed to supply their stores in each district
    public static int factorialUsingRecursion(int n) {
        // n! = n * (n-1) * (n-2) * (n-3) * ........ * 1
        // 5! == 5*4*3*2*1 = 120
        if (n == 0) {
            return 1;
        }
        return n * factorialUsingRecursion(n - 1);
    }

    // Compute the Sum of Array Elements
    public static int sum(int[] nums) {
        // Arrays.stream(nums).sum();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
        }
        return result;
    }

    // Find the Largest Element in Array
    public static int findLargest(int[] nums) {
        // Initialize maximum element
        // Arrays.stream(arr).max().getAsInt();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    // Remove All Occurrences of an Element in an Array
    public static int[] removeAllOccurrences(int[] nums, int key) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (key != nums[i]) {
              nums[index++] = nums[i];
            }
        }
        // Create a copy of nums[]
        return Arrays.copyOf(nums, index);
        // System.out.println(Arrays.toString(sumOfAll));
    }

    // check whether a string is a Palindrome: the reverse of level is still level
    public static boolean checkIfPalindrome(String originalString) {
        String reversedString = new StringBuilder(originalString).reverse().toString();
        return reversedString.equals(originalString);
    }

    // reverse a string
    public static String reverseString(String originalString) {
        // return new StringBuilder(originalString).reverse().toString();
        String r = "";
        char ch;
        for (int i = 0; i < originalString.length(); i++) {
            // extracts each character
            ch = originalString.charAt(i);
            // adds each character (originalString) in front of the existing string (r)
            r = ch + r;
        }
        return r;
    }

    // Remove leading zeros
    public static String removeLeadingZeros(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        int i = 0;
        while (i < str.length() - 1 && str.charAt(i) == '0') {
            i++;
        }
        return str.substring(i);
    }

    // Find the Transpose of Matrix
    // Changing rows to columns and columns to rows
    /*
      Input:
        [ [ 1, 2, 3 ]
          [ 4, 5, 6 ]
          [ 7, 8, 9 ] ]
      Output:
        [ [ 1, 4, 7]
          [ 2, 5, 8]
          [ 3, 6, 9] ]
     */
    // used to reshape or reformat data, for example, changing the orientation of data in a spreadsheet or database
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposedMatrix = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

}
