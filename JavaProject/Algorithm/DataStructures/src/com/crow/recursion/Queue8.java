package com.crow.recursion;

/**
 * User crow7
 * Date 2021/10/29.
 */
public class Queue8 {
    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义一个数组array，用于保存皇后位置的结果，比如arr[8] = {0, 4, 7, 5, 2, 6, 1, 3}
    int[] arr = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        //测试
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println("解法总数：" + count);
    }

    //编写一个方法，放置第n个皇后
    //特别注意：check是每一次递归时，进入到check中都有for(int i = 0; i < max; i++)，因此会有回溯
    private void check(int n) {
        if (n == max) {// n = 8，相当于放第9个皇后，其实8个皇后已经放好了
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当皇后n放入该行的第1列
            arr[n] = i;
            //当放置第n个皇后在i列时是否冲突
            if (judge(n)) {
                //如果不冲突，就开始放n+1个皇后
                check(n + 1);
            }
            //如果冲突，就继续执行循环，arr[n] = i，即将第n个皇后放置在本行的后移的一个位置
        }
    }

    /**
     * 查看当放置第n个皇后，就去检测该皇后是否和起那么已经摆放的皇后冲突
     *
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            /**
             * 说明
             * 1.arr[i] == arr[n] 表示判断第n个皇后是佛䄦前面的n-1个皇后在同一列
             * 2.Math.abs(n - 1) == Math.abs(arr[n] - arr[i]) 表示判断第n个皇后是否和第i个皇后在同一个斜线
             * 3.由于n每次都在递增，所以不会在同一行
             */
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    //写一个方法，可以将皇后摆放的位置打印出来
    private void print() {
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
