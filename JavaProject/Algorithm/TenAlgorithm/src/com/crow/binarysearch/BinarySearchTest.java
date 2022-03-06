package com.crow.binarysearch;

/**
 * User crow7
 * Date 2021/11/30.
 */
public class BinarySearchTest {
    public static void main(String[] args) {
        int arr[] = {1, 3, 8, 10, 11, 67, 100};
        int index = binarySearch(arr, 3);
        System.out.println(index);
    }

    //二分查找非递归实现
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else return mid;
        }
        return -1;
    }
}

