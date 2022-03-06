package com.crow.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * User crow7
 * Date 2021/11/2.
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[800];
        for (int i = 0; i < 800; i++) {
            arr[i] = (int) (Math.random() * 800);
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println(date1Str);
        radixSort(arr);
        Date data2 = new Date();
        String date1Str2 = simpleDateFormat.format(data2);
        System.out.println(date1Str2);
//        System.out.println("基数排序后");
//        System.out.println(Arrays.toString(arr));
    }

    //基数排序方法
    public static void radixSort(int[] arr) {
        //得到数组中最大的位数的个数
        int max = arr[0];//假设第一个数就是最大的数
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        //定义一个二维数组，表示10个桶，每个桶就是一个1维数组
        /**
         * 说明：
         * 1.二维数组包含10个以为是数组
         * 2.为了防止溢出，为了防止在放入数据时溢出，将每个桶的大小定位arr.length
         * 3.基数排序是使用空间换时间的经典算法
         */
        int[][] bucket = new int[10][arr.length];
        //为了记录每个桶中实际存放了多少个数据，定义一个一维数组来记录各个桶每次放入的数据的个数
        //这里的bucketElementCounts[0]记录的就是bucket[0]桶中放入数据的个数
        int[] bucketElementCounts = new int[10];
        //使用循环处理代码
        for (int j = 0, n = 1; j < maxLength; j++, n *= 10) {
            //针对每个元素对应位进行排序处理，第一次是个位，第二次是十位...
            for (int i = 0; i < arr.length; i++) {
                //取出每个元素对应位的值
                int digitOfElement = arr[i] / n % 10;
                //放入到对应的桶中
                //bucketElementCounts[digitOfElement]表示对应桶中的元素个数，因此每一次添加元素后，自增1
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
                bucketElementCounts[digitOfElement]++;
            }
            //按照放入桶的顺序（一维数组的下表依次取出数据，放回原来数组）
            int index = 0;
            for (int k = 0; k < bucket.length; k++) {
                //如果桶中有数据，才放入到原数组
                if (bucketElementCounts[k] != 0) {
                    //循环该桶，就是第k个桶，放入原数组
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr中
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                //每一轮结束后，需要将每个bucketElementCounts[k]归零
                bucketElementCounts[k] = 0;
            }
            //System.out.println("第" + (j + 1) + "轮，排序的处理结果为 arr = " + Arrays.toString(arr));
        }
    }
}


