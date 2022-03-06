package com.crow.inherit0;

/**
 * User crow7
 * Date 2021/9/5.
 */
public class Cat {
    private String color;//颜色
    private int age;//年龄

    private double eyeSight;//视力 Cat类特有

    public void ear() {
        System.out.println("eating...");
    }

    public void sleep() {
        System.out.println("leeping....");
    }

    public void introduce() {
        System.out.println("color = " + color + "\nage = " + age + "\neyeSight = " + eyeSight);
    }

    public void grabMouse(){
        System.out.println("Cat grab mouse....");
    }
}
