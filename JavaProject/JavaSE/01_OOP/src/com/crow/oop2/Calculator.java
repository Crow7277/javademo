package com.crow.oop2;

/**
 * User crow7
 * Date 2021/9/4.
 */
/*
 * 计算器类
 *
 * 首先执行main方法开始执行，在栈内存开启了一个栈帧，创建了一个对象calc，同时也是一个局部变量
 * 在堆内存中创建成员变量brand和size，默认值为null和0.0
 * 将堆内存地址赋给了calc
 * 此时brand为calc.brand，size为calc.size
 * 之后给成员变量赋值为casio与4.5,这时，堆内存中会更新为这个值
 * 此时调用show方法，在栈内存中开启一个新的栈帧，执行完毕后弹出
 * 之后调用add方法，add方法有两个局部变量num1,num2初始值为带入的1,2，result没有初始值
 * 执行方法，进行计算返回result，并在执行完成后弹出栈帧
 * main方法执行结束，弹出栈帧
 * */
public class Calculator {
    //成员变量  静态特征
    private String brand;//品牌
    private double size;//尺寸

    //成员方法  动态行为
    public int add(int num1, int num2) {// num1与num2为局部变量
        int result;
        result = num1 + num2;
        return result;
    }

    public int sub(int num1, int num2) {
        int result;
        result = num1 - num2;
        return result;
    }

    public void show() {
        System.out.println("brand: " + brand + "\nsize: " + size);
    }

    public static void main(String[] args) {
        //创建一个计算器
        Calculator calc = new Calculator();
        //操作属性
        calc.brand = "casio";
        calc.size = 4.5;
        //执行功能
        calc.show();
        System.out.println(calc.add(1, 2));
        System.out.println(calc.sub(1, 2));
    }
}
