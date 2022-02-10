package Leetcode_algorithms1;

/**
 * <a href="https://leetcode.com/problems/first-bad-version/">First Bad Version
 * #278</a>
 */
public class P278FirstBadVersion {

    static int firstBad = 4;

    public static int firstBadVersion(int n) {
        return fbv(1, n);
    }

    private static int fbv(int start, int end) {
        if (start == end && isBadVersion(start)) {
            return start;
        }
        if (start >= end) {
            return end;
        }
        int mid = (end - start) / 2 + start;
        if (isBadVersion(mid)) {
            return fbv(start, mid);
        }
        return fbv(mid + 1, end);
    }

    private static boolean isBadVersion(int v) {
        return v >= firstBad;
    }

    public static void validate(int n, int bad, int expected) {
        firstBad = bad;
        int actual = firstBadVersion(n);
        if (actual != expected) {
            throw new RuntimeException("expected: " + expected + ", actual: " + actual);
        }

        System.out.println("PASSED");
    }

    public static void main(String[] args) {

        validate(5, 4, 4);

        validate(1, 1, 1);

        validate(1000000000, 1, 1);

        validate(5, 5, 5);

        validate(1000000000, 1000000000, 1000000000);

        validate(1000000000, 1000, 1000);

    }

}
