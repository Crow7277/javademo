package com.crow.sort;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * User crow7
 * Date 2021/11/2.
 */
public class MergeSort {
    public static void main(String[] args) {

        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = (int) (Math.random()*8);
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println(date1Str);
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        Date data2 = new Date();
        String date1Str2 = simpleDateFormat.format(data2);
        System.out.println(date1Str2);
        System.out.println("归并排序后");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序，分加合的方法
     *
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param right 右边索引
     * @param temp  中转数组
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;//中间索引
            //先向左递归进行分解
            mergeSort(arr, left, mid, temp);
            //向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            //到合并
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 归并排序，合并的方法
     *
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  中转数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//初始化i，i表示左边有序序列的初始索引
        int j = mid + 1;//初始化j，j表示右边有序序列的初始索引
        int t = 0;//指向temp数组的当前索引，t表示中转数组的索引

        //1.先把左右两边的（有序）数据按照规则条冲到temp中,直到左右两边有序数列有一边处理完毕为止
        //左边有序序列是从left到mid，右边有序数列是从mid+1到right
        while (i <= mid && j <= right) {
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素，拷贝到temp中转数组，然后t和i要后移
            if (arr[i] < arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {//反之，将右边的当前元素拷贝到temp中转数组，然后j和t后移
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        //2.把有剩余数据的一边的数据依次填充到temp中
        while (i <= mid) {//说明左边的有序序列还有剩余的元素，此时全部填充到temp
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {//说明右边的有序序列还有剩余的元素，此时全部填充到temp
            temp[t] = arr[j];
            t++;
            j++;
        }

        //3.将temp数组中的元素拷贝到arr
        //并不是每次都拷贝所有的元素，因为存在递归，最后一次拷贝的时候是所有的元素，之前的时候其实是将分治的数组拷贝进来
        t = 0;//t为中转数组索引
        //第一次合并时，tempLeft = 0，right = 1；第二次tempLeft = 2，right = 3;第三次为0,3...
        //最后一次tempLeft = 0，left = 7
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }
    }
}
