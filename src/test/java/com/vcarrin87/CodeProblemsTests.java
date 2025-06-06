package com.vcarrin87;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

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
    void testRemoveDuplicates() {
        int[] nums = {1, 1, 2, 3, 4, 4, 5};
        int expectedLength = 5;
        int[] expectedArray = {1, 2, 3, 4, 5};

        int length = CodeProblems.removeDuplicates(nums);
        assertEquals(expectedLength, length);
        assertArrayEquals(expectedArray, Arrays.copyOf(nums, length));
    }

    @Test
    void testRemoveElement() {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int expectedLength = 2;
        int[] expectedArray = {2, 2};

        int length = CodeProblems.removeElement(nums, val);
        assertEquals(expectedLength, length);
        assertArrayEquals(expectedArray, Arrays.copyOf(nums, length));
    }

    @Test
    void testLengthOfLastWord() {
        String str = "Hello World";
        int expectedLength = 5;

        int result = CodeProblems.lengthOfLastWord(str);
        assertEquals(expectedLength, result);
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

    @Test
    void testIsNeedleInHaystack() {
        assertEquals(2, CodeProblems.isNeedleInHaystack("hello", "ll"));
        assertEquals(-1, CodeProblems.isNeedleInHaystack("aaaaa", "bba"));
        assertEquals(-1, CodeProblems.isNeedleInHaystack("abc", "d"));
    }

    @Test
    void testSortArrayInDescendingOrder() {
        int[] arr = {5, 3, 8, 1, 2, 10};
        int[] expected = {10, 8, 5, 3, 2, 1};

        int[] result = CodeProblems.sortArrayInDescendingOrder(arr);
        assertArrayEquals(expected, result);
    }

    @Test
    void testFindMaxValue() {
        int[] arr = {1, 2, 3, 4, 5};
        int result = CodeProblems.findMaxValue(arr);
        assertEquals(5, result);

        arr = new int[]{-1, -2, -3, -4, -5};
        result = CodeProblems.findMaxValue(arr);
        assertEquals(-1, result);
    }

    @Test
    void testFindMinValue() {
        int[] arr = {1, 2, 3, 4, 5};
        int result = CodeProblems.findMinValue(arr);
        assertEquals(1, result);

        arr = new int[]{-1, -2, -3, -4, -5};
        result = CodeProblems.findMinValue(arr);
        assertEquals(-5, result);
    }
    
    @Test
    void testPlusOne() {
        int[] digits = {1, 2, 3};
        int[] expected = {1, 2, 4};

        int[] result = CodeProblems.plusOne(digits);
        assertArrayEquals(expected, result);

        digits = new int[]{9, 9, 9};
        expected = new int[]{1, 0, 0, 0};

        result = CodeProblems.plusOne(digits);
        assertArrayEquals(expected, result);

        digits = new int[]{9,8,7,6,5,4,3,2,1,0};
        expected = new int[]{9,8,7,6,5,4,3,2,1,1};
        result = CodeProblems.plusOne(digits);
        assertArrayEquals(expected, result);
    }

    @Test
    void testMySqrt() {
        assertEquals(2, CodeProblems.mySqrt(4));
        assertEquals(3, CodeProblems.mySqrt(9));
        assertEquals(5, CodeProblems.mySqrt(25));
        assertEquals(6, CodeProblems.mySqrt(36));
        assertEquals(7, CodeProblems.mySqrt(49));
        assertEquals(8, CodeProblems.mySqrt(64));
        assertEquals(9, CodeProblems.mySqrt(81));
        assertEquals(10, CodeProblems.mySqrt(100));
    }

    @Test
    void testSimplifyPath() {
        assertEquals("/c", CodeProblems.simplifyPath("/a/./b/../../c/"));
        assertEquals("/", CodeProblems.simplifyPath("/../"));
        assertEquals("/", CodeProblems.simplifyPath(""));
        assertEquals("/home/foo", CodeProblems.simplifyPath("/home//foo/"));
        assertEquals("/a/b/c", CodeProblems.simplifyPath("/a/b/c/"));
        assertEquals("/a/b/c/d", CodeProblems.simplifyPath("/a/b/c/d/"));
    }

    @Test
    void testSumFirstAndLastDigit() {
        assertEquals(4, CodeProblems.sumFirstAndLastDigit(252));
        assertEquals(9, CodeProblems.sumFirstAndLastDigit(257));
        assertEquals(4, CodeProblems.sumFirstAndLastDigit(13));
        assertEquals(0, CodeProblems.sumFirstAndLastDigit(0));
        assertEquals(10, CodeProblems.sumFirstAndLastDigit(5));
        assertEquals(-1, CodeProblems.sumFirstAndLastDigit(-10));
    }

    @Test
    void testGetEvenDigitSum() {
        assertEquals(20, CodeProblems.getEvenDigitSum(123456789));
        assertEquals(0, CodeProblems.getEvenDigitSum(13579));
        assertEquals(20, CodeProblems.getEvenDigitSum(24680));
        assertEquals(0, CodeProblems.getEvenDigitSum(0));
        assertEquals(-1, CodeProblems.getEvenDigitSum(-12345));
    }

    @Test
    void testGetOddDigitSum() {
        assertEquals(25, CodeProblems.getOddDigitSum(123456789));
        assertEquals(25, CodeProblems.getOddDigitSum(13579));
        assertEquals(0, CodeProblems.getOddDigitSum(24680));
        assertEquals(0, CodeProblems.getOddDigitSum(0));
        assertEquals(-1, CodeProblems.getOddDigitSum(-12345));
    }

    @Test
    void testIsTwoDigitNumber() {
        assertTrue(CodeProblems.isTwoDigitNumber(12));
        assertTrue(CodeProblems.isTwoDigitNumber(99));
        assertFalse(CodeProblems.isTwoDigitNumber(9));
        assertFalse(CodeProblems.isTwoDigitNumber(100));
        assertFalse(CodeProblems.isTwoDigitNumber(-12));
        assertFalse(CodeProblems.isTwoDigitNumber(0));
    }

    @Test
    void testIsThreeDigitNumber() {
        assertTrue(CodeProblems.isThreeDigitNumber(123));
        assertTrue(CodeProblems.isThreeDigitNumber(999));
        assertFalse(CodeProblems.isThreeDigitNumber(99));
        assertFalse(CodeProblems.isThreeDigitNumber(1000));
        assertFalse(CodeProblems.isThreeDigitNumber(-123));
        assertFalse(CodeProblems.isThreeDigitNumber(0));
    }

    @Test
    void testHasSharedDigit() {
        assertTrue(CodeProblems.hasSharedDigit(12, 23));
        assertTrue(CodeProblems.hasSharedDigit(12, 21));
        assertTrue(CodeProblems.hasSharedDigit(10, 11));

        assertFalse(CodeProblems.hasSharedDigit(12, 34));
        assertFalse(CodeProblems.hasSharedDigit(9, 99));
        assertFalse(CodeProblems.hasSharedDigit(-1, 10));
        assertFalse(CodeProblems.hasSharedDigit(10, -1));
    }
}
