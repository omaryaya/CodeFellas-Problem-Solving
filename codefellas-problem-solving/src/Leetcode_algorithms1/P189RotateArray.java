package Leetcode_algorithms1;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/rotate-array/">#189</a>
 */
public class P189RotateArray {

    public int[] rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        return nums;
    }

    private void reverse(int[] A, int l, int r) {
        while (l < r) {
            int temp = A[l];
            A[l] = A[r];
            A[r] = temp;
            l++;
            r--;
        }
    }

    public static void validate(int[] nums, int k, int[] expected) {
        P189RotateArray solution = new P189RotateArray();
        int[] actual = solution.rotate(nums, k);

        if (!Arrays.equals(actual, expected)) {
            throw new RuntimeException("expected: " + expected + ", actual: " + actual);
        }
        System.out.println("PASSED");
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        int[] answer = { 5, 6, 7, 1, 2, 3, 4 };
        validate(nums, k, answer);

        int[] nums1 = { -1 };
        int[] answer1 = { -1 };
        int k1 = 3;
        validate(nums1, k1, answer1);

        int[] nums2 = { -1, -100, 3, 99 };
        int[] answer2 = { 3, 99, -1, -100 };
        int k2 = 2;
        validate(nums2, k2, answer2);

        int[] nums3 = { 0, 4, 3 };
        int[] answer3 = { 4, 3, 0 };
        int k3 = 5;
        validate(nums3, k3, answer3);

        int[] nums4 = { 1, 2, 3, 4, 5, 6, 7 };
        int k4 = 1;
        int[] answer4 = { 7, 1, 2, 3, 4, 5, 6 };
        validate(nums4, k4, answer4);

        // int[] nums4 = { -1, 0 };
        // int[] answer4 = { 0, 1 };
        // validate(nums4, k, answer4);

        // int[] nums5 = { 1 };
        // int[] answer5 = { 1 };
        // validate(nums5, k, answer5);

        // int[] nums6 = { -3, -2, -1, 0, 0, 0, 0, 0, 0, 1 };
        // int[] answer6 = { 0, 0, 0, 0, 0, 0, 1, 1, 4, 9 };
        // validate(nums6, k, answer6);
    }

}
