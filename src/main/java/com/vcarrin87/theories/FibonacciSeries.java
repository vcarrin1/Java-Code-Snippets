package com.vcarrin87.theories;

/*
The Fibonacci series is a sequence of numbers where each number is the sum of the two preceding ones, usually starting
with 0 and 1. Thus, the sequence typically appears as: 0, 1, 1, 2, 3, 5, 8, 13, 21, and so on.

USE CASES:
Population Growth: The Fibonacci sequence can model idealized population growth in certain species, where the number
of individuals in a generation is the sum of the previous two generations.
Modeling Growth Patterns: In fields like ecology and economics, Fibonacci numbers can model growth patterns and trends,
helping analysts make predictions based on historical data.
 */
public class FibonacciSeries {

    private FibonacciSeries() {}

    public static void printFibonacci(int n) {
        int a = 0, b = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int nextTerm = a + b;
            a = b;
            b = nextTerm;
        }
    }
}
