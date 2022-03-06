package com.crow.sort;

import java.util.Arrays;

/**
 * User crow7
 * Date 2021/10/31.
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        insertSort(arr);
    }

    //插入排序
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //定义待插入的数
            int insertValue = arr[i];
            int insertIndex = i - 1;//也就是arr[1]前面的这个数的下标
            //给insertValue找到插入的位置
            //1.insertIndex >= 0 保证再给insertValue找插入位置时，不越界
            //2.insertIndex < arr[insertIndex] 待插入数还没有找到适当的位置
            //3.就需要将arr[insertIndex]后移
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                //将arr[insertIndex]后移
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
//            for (insertIndex = i - 1; insertIndex >= 0 && insertValue < arr[insertIndex]; insertIndex--) {
//                arr[insertIndex + 1] = arr[insertIndex];
//            }
            //通过判断是否需要赋值减少比较次数
            //如果假定的位置就是应该放的位置时，就不需要赋值了
            if (insertIndex + 1 != i) {
                //当退出while循环时，说明插入位置找到，insertIndex + 1
                arr[insertIndex + 1] = insertValue;
                System.out.println(Arrays.toString(arr));
            }
        }
    }
}
