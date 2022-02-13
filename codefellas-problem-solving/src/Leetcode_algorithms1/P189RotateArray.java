package Leetcode_algorithms1;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/rotate-array/">#189</a>
 */
public class P189RotateArray {

    public int[] rotate(int[] nums, int k) {
        // | 5 | 6 | 7 | 1 | 2 | 3 | 4 | << expected
        // | 3 | 4 | 5 | 6 | 7 | 1 | 2 | << actual
        // int n = nums.length;
        // k %= n;
        // int[] rotated = new int[n];
        // for (int i = 0; i < n; ++i) {
        // rotated[((i + k) % n)] = nums[i];
        // }
        // return rotated;
        int n = nums.length;
        k %= nums.length; // 3
        int j = 0, counter = 0;
        int moveIn, moveOut;
        // | 1 | 2 | 3 | 4 | 5 | 6 | 7 |

        int i = -1;
        moveIn = nums[0]; // 4
        while (counter < n) {

            if (j == i) {
                j = (j + 1) % n;
                moveIn = nums[j];
                continue;
            }
            j = (j + k) % n;
            moveOut = nums[j];
            nums[j] = moveIn;

            moveIn = moveOut;
            i = j;
            ++counter;
        }

        return nums;
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
