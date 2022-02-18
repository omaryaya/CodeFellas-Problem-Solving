package Leetcode_interviews;

/**
 * <a href=
 * "https://leetcode.com/problems/n-th-tribonacci-number/</a>
 */
public class P1137NthTribonacciNumber {

    /*
     * The Tribonacci sequence Tn is defined as follows:
     * 
     * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
     */

    int[] tribonacci = new int[38];

    public int tribonacci(int n) {
        for (int i = 3; i < 38; ++i) {
            tribonacci[i] = -1;
        }
        tribonacci[0] = 0;
        tribonacci[1] = 1;
        tribonacci[2] = 1;
        return tribonacciRecursive(n);
    }

    private int tribonacciRecursive(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        if (tribonacci[n] == -1) {
            tribonacci[n] = tribonacciRecursive(n - 1) + tribonacciRecursive(n - 2) + tribonacciRecursive(n - 3);
        }
        return tribonacci[n];
    }

    public static void validate(int n, int expected) {
        P1137NthTribonacciNumber solution = new P1137NthTribonacciNumber();
        int actual = solution.tribonacci(n);
        if (actual != expected) {
            throw new RuntimeException("expected: " + expected + ", actual: " + actual);
        }
        System.out.println("PASSED");
    }

    public static void main(String[] args) {

        validate(4, 4);
        validate(25, 1389537);
    }

}
