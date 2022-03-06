package com.crow.sort;

import java.util.Arrays;

/**
 * User crow7
 * Date 2021/10/31.
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -2};
        //测试冒泡排序
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    //选择排序
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            //当minIndex不等于i时，相当于没有发生最小值变化，也就是i就是最小值，此时换位置是没有意义的
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
