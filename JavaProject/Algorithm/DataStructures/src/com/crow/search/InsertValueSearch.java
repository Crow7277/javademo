package com.crow.search;

import java.util.Arrays;

/**
 * User crow7
 * Date 2021/11/3.
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
        int index = insertValueSearch(arr, 0, arr.length - 1, 100);
        System.out.println(index);
    }

    /**
     * 插值查找
     * 插值查找算法也要求数组有序
     *
     * @param arr     数组
     * @param left    左边索引
     * @param right   右边索引
     * @param findVal 查找值
     * @return 返回索引，如果找到返回对应的下标否则返回-1
     */
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        //此处的findVal < arr[0] || findVal > arr[arr.length - 1]不但可以优化次数，同时也会防止mid越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        //求出mid
        int mid = left + (arr[right] - arr[left]) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) {
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
