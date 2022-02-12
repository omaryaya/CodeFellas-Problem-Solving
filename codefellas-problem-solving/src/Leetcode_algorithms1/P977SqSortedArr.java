package Leetcode_algorithms1;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/squares-of-a-sorted-array/">#977</a>
 */
public class P977SqSortedArr {

    public int[] sortedSquares(int[] nums) {
        return sortSquares(nums);
    }

    private int[] sortSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int i = 0, j = 1, k = 0;

        while (i < n && j < n && nums[i] < 0 && nums[j] < 0) {
            i++;
            j++;
        }

        while (i >= 0 && j < n) {
            int sqLeft = sq(nums[i]), sqRight = sq(nums[j]);
            if (sqLeft < sqRight) {
                result[k++] = sqLeft;
                i--;
            } else if (sqLeft > sqRight) {
                result[k++] = sqRight;
                j++;
            } else {
                result[k++] = sqLeft;
                result[k++] = sqRight;
                i--;
                j++;
            }
        }
        while (i >= 0 && i < n) {
            int sqLeft = sq(nums[i]);
            result[k++] = sqLeft;
            i--;
        }
        while (j < n && j >= 0) {
            int sqRight = sq(nums[j]);
            result[k++] = sqRight;
            j++;
        }
        return result;
    }

    private int sq(int n) {
        return n * n;
    }

    public static void validate(int[] nums, int[] expected) {
        P977SqSortedArr solution = new P977SqSortedArr();
        int[] actual = solution.sortedSquares(nums);

        if (!Arrays.equals(actual, expected)) {
            throw new RuntimeException("expected: " + expected + ", actual: " + actual);
        }
        System.out.println("PASSED");
    }

    public static void main(String[] args) {

        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int[] answer = { 0, 1, 9, 25, 81, 144 };
        validate(nums, answer);

        int[] nums2 = { -7, -3, 2, 3, 11 };
        int[] answer2 = { 4, 9, 9, 49, 121 };
        validate(nums2, answer2);

        int[] nums1 = { -1 };
        int[] answer1 = { 1 };
        validate(nums1, answer1);

        int[] nums3 = { 0 };
        int[] answer3 = { 0 };
        validate(nums3, answer3);

        int[] nums4 = { -1, 0 };
        int[] answer4 = { 0, 1 };
        validate(nums4, answer4);

        int[] nums5 = { 1 };
        int[] answer5 = { 1 };
        validate(nums5, answer5);

        int[] nums6 = { -3, -2, -1, 0, 0, 0, 0, 0, 0, 1 };
        int[] answer6 = { 0, 0, 0, 0, 0, 0, 1, 1, 4, 9 };
        validate(nums6, answer6);
    }

}
