package com.crow.oop4;

/**
 * User crow7
 * Date 2021/9/4.
 */

/**
 * 交换两个变量的值
 */
public class TestRefArgs {
    public static void main(String[] args) {
        //定义连个变量并赋值
        Point p = new Point();
        //Point p = new Point(10,20);
        p.x = 10;
        p.y = 20;

        //输出交换之前变量的值
        System.out.println("交换前 p.x = " + p.x + ", p.y = " + p.y);

        //进行交换
        swap(p);

        //输出交换之后变量的值
        System.out.println("交换后 p.x = " + p.x + ", p.y = " + p.y);
    }
    public static void swap(Point p) {
        int temp = p.x;
        p.x = p.y;
        p.y = temp;
    }
}
