package com.vcarrin87;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.vcarrin87.code_problems.CodeProblems;

@SpringBootTest
class CodeProblemsTests {

    @Test
    void testIsNumberPalindrome() {
        assertTrue(CodeProblems.isNumberPalindrome(121));
        assertTrue(CodeProblems.isNumberPalindrome(1));
        assertTrue(CodeProblems.isNumberPalindrome(12321));
        assertTrue(CodeProblems.isNumberPalindrome(0));

        assertFalse(CodeProblems.isNumberPalindrome(-121));
        assertFalse(CodeProblems.isNumberPalindrome(-1));

        assertFalse(CodeProblems.isNumberPalindrome(123));
        assertFalse(CodeProblems.isNumberPalindrome(10));
    }

    @Test
    void testIsStringPalindrome() {
        assertTrue(CodeProblems.isStringPalindrome("level"));
        assertTrue(CodeProblems.isStringPalindrome("a"));
        assertTrue(CodeProblems.isStringPalindrome(""));

        assertFalse(CodeProblems.isStringPalindrome("hello"));
        assertFalse(CodeProblems.isStringPalindrome("world"));
    }

    @Test
    void testContainsDuplicate() {
        int[] numsWithDuplicates = {1, 2, 3, 4, 5, 1};
        int[] numsWithoutDuplicates = {1, 2, 3, 4, 5};

        assertTrue(CodeProblems.containsDuplicate(numsWithDuplicates));
        assertFalse(CodeProblems.containsDuplicate(numsWithoutDuplicates));
    }

    @Test
    void testGetIndices() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expectedIndices = {0, 1};

        int[] result = CodeProblems.getIndices(nums, target);
        assertArrayEquals(expectedIndices, result);
    }

    @Test
    void testReverseString() {
        assertEquals("cba", CodeProblems.reverseString("abc"));
        assertEquals("", CodeProblems.reverseString(""));
        assertEquals("a", CodeProblems.reverseString("a"));
        assertEquals("racecar", CodeProblems.reverseString("racecar"));
    }

    @Test
    void testFactorial() {
        assertEquals(1, CodeProblems.factorialUsingRecursion(0));
        assertEquals(1, CodeProblems.factorialUsingRecursion(1));
        assertEquals(2, CodeProblems.factorialUsingRecursion(2));
        assertEquals(6, CodeProblems.factorialUsingRecursion(3));
        assertEquals(24, CodeProblems.factorialUsingRecursion(4));
        assertEquals(120, CodeProblems.factorialUsingRecursion(5));
    }

    @Test
    void testIsPrime() {
        assertFalse(CodeProblems.isPrime(0));
        assertFalse(CodeProblems.isPrime(1));
        assertTrue(CodeProblems.isPrime(2));
        assertTrue(CodeProblems.isPrime(3));
        assertFalse(CodeProblems.isPrime(4));
        assertTrue(CodeProblems.isPrime(5));
        assertFalse(CodeProblems.isPrime(9));
        assertTrue(CodeProblems.isPrime(13));
    }

    @Test
    void testRemoveLeadingZeros() {
        assertEquals("123", CodeProblems.removeLeadingZeros("000123"));
        assertEquals("0", CodeProblems.removeLeadingZeros("0"));
        assertEquals("", CodeProblems.removeLeadingZeros(""));
        assertEquals("123", CodeProblems.removeLeadingZeros("123"));
        assertEquals("1", CodeProblems.removeLeadingZeros("0001"));
    }

    @Test
    void testSwapTwoNumbers() {
        int[] result = CodeProblems.swapTwoNumbers(3, 5);
        assertArrayEquals(new int[]{5, 3}, result);
    }  
    
    @Test
    void testSumTwoNumbers() {
        int result = CodeProblems.sumTwoNumbers(3, 5);
        assertEquals(8, result);
    }

    @Test
    void testSumArrayElements() {
        int[] arr = {1, 2, 3, 4, 5};
        int result = CodeProblems.sumArrayElements(arr);
        assertEquals(15, result);
    }

    @Test
    void testFindLargest() {
        int[] arr = {1, 2, 3, 4, 5};
        int result = CodeProblems.findLargest(arr);
        assertEquals(5, result);
    }

    @Test
    void testRemoveAllOccurrences() {
        int[] arr = {1, 2, 3, 4, 5, 2};
        int key = 2;
        int[] expected = {1, 3, 4, 5};

        int[] result = CodeProblems.removeAllOccurrences(arr, key);
        assertArrayEquals(expected, result);
    }

    @Test
    void testTransposeMatrix() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[][] expected = {
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        };

        int[][] result = CodeProblems.transposeMatrix(matrix);
        assertArrayEquals(expected, result);
    }

    @Test
    void testcountVowels() {
        String str = "hello";
        int result = CodeProblems.countVowels(str);
        assertEquals(2, result);

        str = "aeiou";
        result = CodeProblems.countVowels(str);
        assertEquals(5, result);

        str = "xyz";
        result = CodeProblems.countVowels(str);
        assertEquals(0, result);
    }

    @Test
    void testCheckIfVowelPresentInString() {
        String str = "hello";
        char vowel = 'e';
        boolean result = CodeProblems.checkIfVowelPresentInString(vowel, str);
        assertTrue(result);

        vowel = 'z';
        result = CodeProblems.checkIfVowelPresentInString(vowel, str);
        assertFalse(result);
    }
    
}
