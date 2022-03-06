package com.crow.oop4;

/**
 * User crow7
 * Date 2021/9/4.
 */

/**
 * 交换两个变量的值
 */
public class TestPrimaryArgs {
    public static void main(String[] args) {
        //定义连个变量并赋值
        int num1 = 10;
        int num2 = 20;

        //输出交换之前变量的值
        System.out.println("交换前 num1 = " + num1 + ", num2 = " + num2);

        //进行交换
        swap(num1, num2);
        //输出交换之后变量的值
        System.out.println("交换后 num1 = " + num1 + ", num2 = " + num2);

    }

    public static void swap(int num1, int num2) {
        int temp = num1;
        num1 = num2;
        num2 = temp;
    }
}
