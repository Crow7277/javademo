package com.crow.tree;

import java.util.Arrays;

/**
 * User crow7
 * Date 2021/11/19.
 */
public class HeapSort {
    public static void main(String[] args) {
        //要求将数组进行升序排列，因此使用大顶堆
        int[] arr = {4, 6, 8, 5, 9, -1, 90, 98, 56, -213};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //编写一个堆排序的方法
    public static void heapSort(int arr[]) {
        System.out.println("堆排序");
//        //分布完成
//        adjustHeap(arr, 1, arr.length);
//        System.out.println("第一次" + Arrays.toString(arr));//4，9，8，5，6
//
//        adjustHeap(arr, 0, arr.length);
//        System.out.println("第二次" + Arrays.toString(arr));//9，6，8，5，1
        //最终代码
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        System.out.println("数组 = " + Arrays.toString(arr));
        for (int j = arr.length - 1; j > 0; j--) {
            //交换
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }


    /**
     * 将一个数组调整成一个大顶堆
     * 功能：将以 i 对应的非叶子结点的数调整成大顶堆
     * 举例：int[] arr = {4,6,8,5,9}; => i = 1 => adjustheap => {4, 9 , 8 , 5, 6}
     *
     * @param arr    待调整数组
     * @param i      非叶子结点在数组中的索引
     * @param length 对多少个元素进行调整，是在逐渐减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        //先取出当前元素的值，保存在临时变量
        int temp = arr[i];
        //开始调整
        //k为 i 结点的左子结点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //左子结点的值小于右子节点的值
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                //k指向右子节点
                k++;
            }
            if (arr[k] > temp) {
                //如果子结点大于父节点
                //把较大的值付给当前结点
                arr[i] = arr[k];
                //i指向k，继续循环比较
                i = k;
            } else {
                break;
            }
        }
        //当for循环解释和，已经将i以为父节点的树的最大值放在了最顶上
        arr[i] = temp;//将temp放入到跳帧后的位置
    }
}

