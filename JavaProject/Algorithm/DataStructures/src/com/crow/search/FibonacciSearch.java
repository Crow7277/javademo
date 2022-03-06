package com.crow.search;

import java.util.Arrays;

/**
 * User crow7
 * Date 2021/11/3.
 */
public class FibonacciSearch {
    public static int max = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(fibSearch(arr, 1));
    }

    //因为后面的公式mid = low + F(k - 1) - 1会用到斐波那契数列，因此需要先获取到斐波那契数列
    //使用非递归方式得到
    public static int[] fib() {
        int[] f = new int[max];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < max; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     * 斐波那契查找算法
     *
     * @param a   数组
     * @param key 需要查找的值
     * @return 放回对应下标，没找到返回-1
     */
    public static int fibSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int k = 0;//斐波那契分割数值下标
        int mid = 0;
        int[] f = fib();//获取斐波那契数列
        //获取斐波那契分格竖直下标
        while (high > f[k] - 1) {
            k++;
        }
        //因为f[k]的值可能更大于数组的长度，因此需要Arrays类构造一个新的数组并指向a
        //不足的地方会使用0填充
        int[] temp = Arrays.copyOf(a, f[k]);
        //实际上，使用a数组的最后一个数填充temp
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }
        //使用while循环来循环处理，查找key
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                /**
                 * 为什么是k--
                 * 1.全部元素 = 前面的元素 + 后面的元素
                 * 2. f[k] = f[k - 1] + f[k - 2]
                 * 3.因为起那么有f[k - 1]个元素，所以可以继续拆分 f[k - 2] + f[k - 3]
                 *   即在f[k - 1]的前面继续查找k--
                 *   即下次循环时 mid = f[k - 1 - 1] - 1
                 */
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                /**
                 * 为什么是k -= 2
                 * 1.全部元素 = 前面的元素 + 后面的元素
                 * 2. f[k] = f[k - 1] + f[k - 2]
                 * 3.因为起那么有f[k - 2]个元素，所以可以继续拆分 f[k - 3] + f[k - 4]
                 *   即在f[k - 2]的前面继续查找k -= 2
                 *   即下次循环时 mid = f[k - 1 - 2] - 1
                 */
                k -= 2;
            } else {
                //需要确定返回的是哪个下标
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
