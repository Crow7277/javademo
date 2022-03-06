package com.crow.sort;

import java.util.Arrays;

/**
 * User crow7
 * Date 2021/11/1.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 4, 6, 5, 3, 2, 8, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        //递归结束条件：startIndex >= endIndex
        if (startIndex >= endIndex) {
            return;
        }
        System.out.println(Arrays.toString(arr));
        //得到基准元素
        int pivotInde = partition(arr, startIndex, endIndex);
        //根据基准元素，分成两部分进行递归排序
        quickSort(arr, startIndex, pivotInde - 1);
        quickSort(arr, pivotInde + 1, endIndex);
    }

    /**
     * 分治（双边循环法）
     *
     * @param arr        待交换数组
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        //此处选取第一个位置作为基准元素，也可以使用随机位置
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left < right) {
            //控制right左移
            while (left < right && arr[right] > pivot) right--;
            //控制left右移
            while (left < right && arr[left] <= pivot) left++;
            //交换left和right指针所在位置的元素
            //if (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            //}
        }
        //由于判断条件是left!=right，因此退出循环时，left与right重合
        //pivot与重合点进行交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        //将指针重合点，也就是数组切片的地方返回
        return left;
    }
}

