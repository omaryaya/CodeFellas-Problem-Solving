package Leetcode_algorithms1;

/**
 * <a href=
 * "https://leetcode.com/problems/search-insert-position/">search-insert-position/</a>
 */
public class P35SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        return searchInsertPosition(nums, 0, nums.length - 1, target);
    }

    private int searchInsertPosition(int[] nums, int start, int end, int target) {

        if (start == end) {
            if (nums[start] == target) {
                return start;
            }
            if (target > nums[start]) {
                return start + 1;
            }
            return start;
        }
        if (start >= end) {
            return start;
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
            return searchInsertPosition(nums, start, midIndex - 1, target);
        } else if (midVal < target) {
            return searchInsertPosition(nums, midIndex, end, target);
        }

        return midIndex;

    }

    public static void validate(int[] nums, int target, int expected) {
        P35SearchInsertPosition solution = new P35SearchInsertPosition();
        int actual = solution.searchInsert(nums, target);
        if (actual != expected) {
            throw new RuntimeException("expected: " + expected + ", actual: " + actual);
        }
        System.out.println("PASSED");
    }

    public static void main(String[] args) {

        int[] nums = { 1, 3, 5, 6 };
        validate(nums, 5, 2);
        validate(nums, 2, 1);
        validate(nums, 7, 4);
        validate(nums, -1, 0);

        int[] nums1 = { 1 };
        validate(nums1, 0, 0);
        validate(nums1, 5, 1);
        validate(nums1, 1, 0);

        int[] nums3 = { 1, 2, 4, 6, 7 };
        validate(nums3, 3, 2);

    }

}
