package com.crow.dac;

/**
 * User crow7
 * Date 2021/12/2.
 */
public class Hanoitower {
    static int count = 0;

    public static void main(String[] args) {
        hanoiTower(15, 'A', 'B', 'C');
        System.out.println(count);
    }

    /**
     * 汉诺塔的移动方案
     * 分治算法
     *
     * @param num 盘的个数
     * @param a   其实柱子
     * @param b   借用柱子
     * @param c   目标柱子
     */
    public static void hanoiTower(int num, char a, char b, char c) {
        //如果只有一个盘
        count++;
        if (num == 1) {
            System.out.println("第1个盘：" + a + "->" + c);
        } else {
            //如果n >= 2的情况，总是看做两个盘,最下面的一个盘和上面的所有盘
            //1.先把最上面的A->B，
            hanoiTower(num - 1, a, c, b);
            //2.把下面的盘A->C
            System.out.println("第" + num + "个盘：" + a + "->" + c);
            //3.把B的所有的盘移动到C,移动过程会使用到A
            hanoiTower(num - 1, b, a, c);
        }
    }
}

