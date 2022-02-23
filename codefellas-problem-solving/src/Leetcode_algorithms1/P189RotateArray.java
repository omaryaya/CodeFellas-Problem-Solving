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
        UtilityMethods<Integer> util = new UtilityMethods<>();
        int[] actual = solution.rotate(nums, k);

        if (!Arrays.equals(actual, expected)) {
            System.out.print("FAILED ---- ");
            System.out.print("Expected: ");
            util.printArr(expected);

            System.out.print("FAILED ------ Actual: ");
            util.printArr(actual);
        } else {
            System.out.println("PASSED");
        }
    }

    public static void main(String[] args) {

        int[] nums0 = { 1, 2, 3, 4 };
        int k0 = 2;
        int[] answer0 = { 3, 4, 1, 2 };
        validate(nums0, k0, answer0);

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

        int[] nums5 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int k5 = 3;
        int[] answer5 = { 7, 8, 9, 1, 2, 3, 4, 5, 6 };
        validate(nums5, k5, answer5);

        int[] nums6 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int k6 = 6;
        int[] answer6 = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
        validate(nums6, k6, answer6);

    }

}
