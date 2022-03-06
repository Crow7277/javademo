package com.crow.search;

/**
 * User crow7
 * Date 2021/11/3.
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1, 9, 11, -1, 34, 89};
        int index = seqSearch(arr, 11);
        if (index == -1) System.out.println("没有找到");
        else System.out.println("下标为" + index);
    }

    /**
     * 这里的线性查找是找到一个满足条件的值就返回
     *
     * @param arr   数组
     * @param value 需要找的值
     * @return 所查找值的下标
     */
    public static int seqSearch(int[] arr, int value) {
        //线性查找是逐一比对，发现相同，返回下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) return i;
        }
        return -1;
    }
}
