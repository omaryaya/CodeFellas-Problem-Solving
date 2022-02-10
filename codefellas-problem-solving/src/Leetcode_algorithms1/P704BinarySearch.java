package Leetcode_algorithms1;

public class P704BinarySearch {

    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int start, int end, int target) {

        if (start == end) {
            return nums[start] == target ? start : -1;
        }
        if (start >= end) {
            return -1;
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }

        int midIndex = ((end - start + 1) / 2) + start;
        int midVal = nums[midIndex];
        if (midVal > target) {
            return binarySearch(nums, start, midIndex - 1, target);
        } else if (midVal < target) {
            return binarySearch(nums, midIndex + 1, end, target);
        }

        return midIndex;

    }

    public static void validate(int[] nums, int target, int expected) {
        P704BinarySearch solution = new P704BinarySearch();
        int actual = solution.search(nums, target);
        if (actual != expected) {
            throw new RuntimeException("expected: " + expected + ", actual: " + actual);
        }
        System.out.println("PASSED");
    }

    public static void main(String[] args) {

        int[] nums = { -1, 0, 3, 5, 9, 12 };
        validate(nums, 9, 4);

        int[] nums2 = { -1, 0, 3, 5, 9, 12 };
        validate(nums2, 13, -1);

        int[] nums3 = { -1, 0, 3, 5, 9, 12 };
        validate(nums3, 2, -1);

        int[] nums4 = {};
        validate(nums4, 2, -1);

        int[] nums5 = { 1 };
        validate(nums5, 1, 0);

        int[] nums6 = { 1, 10 };
        validate(nums6, 10, 1);
    }

}
