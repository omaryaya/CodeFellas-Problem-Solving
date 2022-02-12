package Leetcode_algorithms1;

public class UtilityMethods<T> {

    public boolean equalArrays(T[] arr1, T[] arr2) {

        if (arr1.length != arr2.length)
            return false;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }

        return true;

    }

    public boolean equalArrays(int[] arr1, int[] arr2) {

        if (arr1.length != arr2.length)
            return false;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }

        return true;

    }

}
