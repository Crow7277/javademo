package com.crow.sort;

import java.util.Arrays;

/**
 * User crow7
 * Date 2021/10/31.
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    //使用逐步推导的方式编写希尔排序
    public static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //希尔排序第一轮
            //第一轮排序是将10个数据分成了5组
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素（共5组，每组有两个元素），步长为5
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长后的那个元素，说明需要交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("第" + (++count) + "轮");
            System.out.println(Arrays.toString(arr));
        }
    }

//        //希尔排序第二轮
//        //第二轮排序是将10个数据分成了2组
//        for (int i = 2; i < arr.length; i++) {
//            //遍历各组中所有的元素（共5组，每组有两个元素），步长为5
//            for (int j = i - 2; j >= 0; j -= 2) {
//                //如果当前元素大于加上步长后的那个元素，说明需要交换
//                if (arr[j] > arr[j + 2]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 2];
//                    arr[j + 2] = temp;
//                }
//            }
//        }
//        System.out.println("第二轮：");
//        System.out.println(Arrays.toString(arr));
//
//        //希尔排序第二轮
//        //第二轮排序是将10个数据分成了1组
//        for (int i = 1; i < arr.length; i++) {
//            //遍历各组中所有的元素（共5组，每组有两个元素），步长为5
//            for (int j = i - 1; j >= 0; j -= 1) {
//                //如果当前元素大于加上步长后的那个元素，说明需要交换
//                if (arr[j] > arr[j + 1]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//        System.out.println("第三轮：");
//        System.out.println(Arrays.toString(arr));

    //对交换式的希尔排序进行优化
    public static void shellSort2(int[] arr) {
        int count = 0;
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap元素开始逐个对其所在组进行插入
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    //移动
                    arr[j] = arr[j - gap];
                    j -= gap;
                    //当退出while循环后找到了插入的位置
                    arr[j] = temp;
                }
            }
            System.out.println("第" + (++count) + "轮");
            System.out.println(Arrays.toString(arr));
        }
    }
}
