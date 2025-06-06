package com.vcarrin87.code_problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class CodeProblems {

    private CodeProblems() {
        // Prevent instantiation
    }

    // boolean isNumberPalindrome = CodeProblems.isNumberPalindrome(121);
    // 121 -> true
    // 123 -> false
    // -121 -> false
    public static boolean isNumberPalindrome(int x) {
        // Negative numbers are not palindromes
        if (x < 0) return false;
    
        int originalNum = x; // Store the original number
        int reversedNum = 0;
    
        while (x != 0) {
            // x % 10 is used to extract the last digit of the number x
            int digit = x % 10;
            reversedNum = reversedNum * 10 + digit;
            // the /= operator is a shorthand for division followed by assignment
            x /= 10;
        }
    
        // Compare the reversed number with the original
        return reversedNum == originalNum;
    }

     // check whether a string is a Palindrome: the reverse of level is still level
    public static boolean isStringPalindrome(String originalString) {
        String reversedString = new StringBuilder(originalString).reverse().toString();
        return reversedString.equals(originalString);
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

    // Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place 
    // such that each unique element appears only once. The relative order of the elements should be 
    // kept the same. Then return the number of unique elements in nums.
    public static int removeDuplicates(int[] nums) {
        // if the array is empty, return 0
        if (nums.length == 0) {
            return 0;
        }

        int uniqueIndex = 1; // Start from the second element

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[uniqueIndex] = nums[i];
                uniqueIndex++;
            }
        }

        System.out.println("Unique elements: " + Arrays.toString(Arrays.copyOf(nums, uniqueIndex)));

        return uniqueIndex;
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
    // (b = a) assigns the value of a to b and returns the value of a.
    // a + b computes the sum of the original a and b.
    // Subtracting (b = a) from (a + b) effectively assigns the original value of b to a.
    public static int[] swapTwoNumbers(int a, int b) {
        // Using arithmetic operators
        a = (a + b) - (b = a);
        System.out.println("Value of a is " + a + " and Value of b is " + b);
        return new int[] { a, b };
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
    public static int sumArrayElements(int[] nums) {
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

    // Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
    // The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[index++] = nums[i];
            }
        }
        System.out.println("index: " + index);
        // return the number of elements in nums which are not equal to val.
        return index;
    }

    // Given a string s consisting of words and spaces, return the length of the last word in the string.
    public static int lengthOfLastWord(String s) {
        String[] array = s.split(" ");
        String last = array[array.length - 1];
        return last.length();
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

    // Count vowels in a string
    // int count = countVowels("hello");
    // System.out.println("Number of vowels: " + count);
    public static int countVowels(String str) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < str.length(); i++) {
            if (vowels.indexOf(str.charAt(i)) != -1) {
                count++;
            }
        }

        return count;
    }

    // check if a vowel is present in a string
    // Boolean exists = checkIfVowelPresentInString("e", "hello");
    // System.out.println("Vowel exists: " + exists);
    public static boolean checkIfVowelPresentInString(char vowel, String str) {
        return str.indexOf(vowel) != -1;
    }

    // A prime number is a natural number greater than 1 that has no divisors
    // other than 1 and itself. In other words, a prime number can only be divided evenly 
    // (without a remainder) by 1 and the number itself.

    // For n = 7:

    // n is not 0 or 1, so it skips the first condition.
    // n is not 2, so it skips the second condition.
    // The loop checks divisors from 2 to 7 / 2 = 3. 
    // Since 7 is not divisible by 2 or 3, the method returns true.

     // check if a number is prime
    public static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
         return false;
        }
        if (n == 2) {
         return true;
        }
        for (int i = 2; i <= n / 2; i++) {
         if (n % i == 0) {
          return false;
         }
        }
      
        return true;
    }

    // Given two strings needle and haystack, return the index of the first occurrence of needle in 
    // haystack, or -1 if needle is not part of haystack.
    public static int isNeedleInHaystack(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    // Sort primitive arrays in Java in descending order
    public static int[] sortArrayInDescendingOrder(int[] arr) {
        Arrays.sort(arr);
        // iterate from the start of the array up to its midpoint (arr.length / 2)
        // ensuring that each element is swapped only once with its corresponding element from the end of the array.
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            // swap the elements at index i and (arr.length - 1 - i)
            arr[i] = arr[arr.length - 1 - i];
            // assign the value of temp to the element at index (arr.length - 1 - i)
            arr[arr.length - 1 - i] = temp;
        }
        System.out.println("Sorted array in descending order: " + Arrays.toString(arr));
        return arr;
    }

    // Find the maximum value in an array
    public static int findMaxValue(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Find the minimum value in an array   
    public static int findMinValue(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

     public static int[] plusOne(int[] digits) {
        long sum = 0;
        long result = 0;
        System.out.println("Initial array: " + Arrays.toString(digits));
        for (int digit : digits) {
            // 9,8,7,6,5,4,3,2,1,0
            // Multiply the current sum by 10 and add the current digit
            // This effectively shifts the previous digits to the left and adds the new digit at the end
            // For example, if digits = [1, 2, 3], the sum will be calculated as follows:
            // sum = 0 * 10 + 1 = 1
            // sum = 1 * 10 + 2 = 12
            // sum = 12 * 10 + 3 = 123
            sum = sum * 10 + digit;
        }
        System.out.println("Sum of digits: " + sum);
        result = sum + 1;
        System.out.println(result);

        // Convert the result back to an array of digits
        // For example, if result = 123, the resultStr will be "124"
        // and resultArr will be [1, 2, 4]
        String resultStr = String.valueOf(result);
        int[] resultArr = new int[resultStr.length()];

        // start the loop from the end of the resultStr
        for (int i = resultStr.length() - 1; i >= 0; i--) {
            // Convert each character to an integer and store it in the resultArr
            // For example, if resultStr = "124", the loop will fill resultArr as follows:
            // resultArr[2] = 4
            // resultArr[1] = 2
            // resultArr[0] = 1
            resultArr[i] = (int) (result % 10);
            result /= 10;
        }

        System.out.println("Result array after adding one: " + Arrays.toString(resultArr));
        return resultArr;
    }

    /**
     * The square root of a number x is a value y such that y * y = x.
     * For example, the square root of 9 is 3, because 3 * 3 = 9.
     * In Java, you can compute the square root using Math.sqrt(x).
     */
    public static int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }


    public static String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();
        String[] parts = path.split("/");
        
        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else {
                deque.addLast(part);
            }
        }
        
        if (deque.isEmpty()) {
            return "/";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String dir : deque) {
            sb.append("/").append(dir);
        }
        return sb.toString();
    }

    public static int sumFirstAndLastDigit(int number) {
        if (number < 0) return -1;
        
        String resultStr = String.valueOf(number);
        int[] resultArr = new int[resultStr.length()];

        // start the loop from the end of the resultStr
        for (int i = resultStr.length() - 1; i >= 0; i--) {
            resultArr[i] = number % 10;
            number /= 10;
        }
        
        int firstDigit = resultArr[0];
        int lastDigit = resultArr[resultArr.length - 1];

        int result = firstDigit + lastDigit;

        System.out.println("Result array: " + Arrays.toString(resultArr) + " result: " + result);
        
        return result;
    }

    // Calculating The Sum Of All Even Digits In An Integer
    public static int getEvenDigitSum(int number) {
        if (number < 0) return -1;
        
        String numberString = String.valueOf(number);
        int[] numberArr = new int[numberString.length()];

        int sum = 0;

        for (int i = numberString.length() - 1; i >= 0; i--) {
            // Convert each character to an integer and store it in the numberArr
            numberArr[i] = number % 10;
            number /= 10;
        }

        System.out.println("Number array: " + Arrays.toString(numberArr));

        for (int num : numberArr) {
            // Check if the number is even
            // example: 6 % 2 == 0 then it has no remainder, so it is an even number
            if (num % 2 == 0) {
                sum += num;
            }
        }
        
        return sum;
    }

    // Calculate the sum of all odd digits in an integer
    public static int getOddDigitSum(int number) {
        if (number < 0) return -1;
        
        String numberString = String.valueOf(number);
        int[] numberArr = new int[numberString.length()];

        int sum = 0;

        for (int i = numberString.length() - 1; i >= 0; i--) {
            // Convert each character to an integer and store it in the numberArr
            numberArr[i] = number % 10;
            number /= 10;
        }

        System.out.println("Number array: " + Arrays.toString(numberArr));

        for (int num : numberArr) {
            // Check if the number is odd
            // example: 5 % 2 != 0 then it has a remainder, so it is an odd number
            if (num % 2 != 0) {
                sum += num;
            }
        }
        
        return sum;
    }

    // Check if a number is a two-digit number
    public static boolean isTwoDigitNumber(int number) {
        // Check if the number is between 10 and 99 (inclusive)
        return number >= 10 && number <= 99;
    }
    
    // Check if a number is a three-digit number
    public static boolean isThreeDigitNumber(int number) {
        // Check if the number is between 100 and 999 (inclusive)
        return number >= 100 && number <= 999;
    }

    // Check For A Shared Digit Between Two Numbers
    public static boolean hasSharedDigit(int num1, int num2) {
        if (!(num1 >= 10 && num1 <= 99) || !(num2 >= 10 && num2 <= 99)) return false;
        
        String s1 = String.valueOf(num1);
        String s2 = String.valueOf(num2);
        
        boolean shareDigit = false;
        // s1.toCharArray() converts the string into an array of characters
        for (char c : s1.toCharArray()) {
            if (s2.indexOf(c) != -1) {
                shareDigit = true;
                break;
            }
        }
        
        return shareDigit;
    }
}
