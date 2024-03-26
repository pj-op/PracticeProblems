package com.recursion;

public class RecursiveFactorialSolution {
    /**
     * Given a number n, find the factorial of the number using recursion.
     *
     * @param n
     * @return
     */
    public static int factorial(int n) {
        if (n < 0) return factorial(-1 * n);
        if (n == 0) return 1;
        if (n < 2) return n;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}