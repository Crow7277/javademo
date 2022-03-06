package com.LeetCode.LC2021_11;

/**
 * User crow7
 * Date 2021/11/8.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 8, 12, 56, 123};
        System.out.println(binarySearch(arr, 12));
    }

    //二分查找
    public static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length;
        int mid = 0;
        while (right >= left) {
            mid = left + (right - left) / 2;
            if (arr[mid] > key) {
                right = mid - 1;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else if (arr[mid] == key) {
                return mid;
            }
        }
        return -1;
    }

    //查找边界
    //查找左边界
    public static int leftSearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > key) {
                //mid大于key，说明目标值key在mid左边
                right = mid - 1;
            } else if (arr[mid] < key) {
                //mid小于key，说明目标值key在mid右边
                left = mid + 1;
            } else if (arr[mid] == key) {
                //当mid = key时由于在寻找左边界所以左边界一定在mid左边
                right = mid;
            }
        }
        //确定查找到了左边界，返回，否则返回-1
        if (arr[left] == key) {
            return left;
        }
        return -1;
    }

    //查找右边界
    public static int rightSearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left < right) {
            mid = (left + right + 1) / 2;
            if (arr[mid] > key) {
                //mid大于key，说明目标值key在mid左边
                right = mid - 1;
            } else if (arr[mid] < key) {
                //mid小于key，说明目标值key在mid右边
                left = mid + 1;
            } else if (arr[mid] == key) {
                //当mid = key时由于在寻找左边界所以左边界一定在mid左边
                left = mid;
            }
        }
        //确定查找到了右边界，返回，否则返回-1
        if (arr[right] == key) {
            return right;
        }
        return -1;
    }
}




