package com.crow.sort;

import java.util.Arrays;

/**
 * User crow7
 * Date 2021/10/30.
 */
public class BobblueSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -2};
        //测试冒泡排序
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        bobllueSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    //将冒泡排序封装成一个方法
    public static void bobllueSort(int[] arr){
        int temp = 0;//临时变量
        boolean flag = false;//表示变量，判断是否进行过排序
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "躺排序：" + Arrays.toString(arr));
            if (!flag) break;//说明一趟排序中一次交换都没有法神过
            else flag = false;//重置flag，进行下次判断
        }
    }
}
