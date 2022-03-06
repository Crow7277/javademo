package com.crow.LeetCodeTest;

import java.util.Arrays;

/**
 * User crow7
 * Date 2021/11/1.
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 5, 6, 9};
        System.out.println(Arrays.toString(searchRange(arr, 4)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int leftIndex;//左边界
        int rightIndex;//右边界
        if (nums.length == 0)
            return new int[]{-1, -1};
        //确定左边界
        leftIndex = leftSearch(nums, target);
        //如果左边界不存在，则target就不存在
        if (leftIndex == -1)
            return new int[]{-1, -1};
        //确定右边界
        rightIndex = rightSearch(nums, target);
        return new int[]{leftIndex, rightIndex};
    }

    //查找左边界，使用二分查找
    public static int leftSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > target) {
                //此时目标值在[left,mid]
                right = mid - 1;
            } else if (nums[mid] < target) {
                //此时目标值在[mid,right]
                left = mid + 1;
            } else if (nums[mid] == target) {
                //由于是查找左边界，所以当相等的时候，左边界一定在[left,mid]这个区间
                right = mid;
            }
        }
        //确定查找到了左边界，返回，否则返回-1
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    //查找右边界，使用二分查找
    public static int rightSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            /**
             * 向上取整
             * 由于nums[mid] < target和nums[mid] == target都会对left进行赋值
             * 因此，当left = mid时，此时如果让mid = (left + right) / 2;会进向下取整，因此，会再出现mid = left的情况，
             * 然后再计算，仍然是left = mid，进入死循环
             * 此时需要向上取整，因此需要加一，mid = (left + right + 1) / 2;
             */
            mid = (left + right + 1) / 2;
            if (nums[mid] > target) {
                //此时目标值所在区间为[left,mid]
                right = mid - 1;
            } else if (nums[mid] < target) {
                //此时目标值所在区间为[mid,right]
                left = mid + 1;
            } else if (nums[mid] == target) {
                //由于是查找右边界，所以当相等的时候，右边界一定在[mid,right]这个区间
                left = mid;
            }
        }
        return right;
    }
}


