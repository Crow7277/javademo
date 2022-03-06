package com.crow.inherit1;

/**
 * User crow7
 * Date 2021/9/5.
 */
public class Cat extends Animal {//继承Animal类

    private double eyeSight;//视力 Cat类特有

    public void grabMouse() {
        System.out.println("Cat grab mouse....");
    }

    public Cat() {
    }

    public Cat(double eyeSight, int age, String color) {
        super(color, age);
        this.eyeSight = eyeSight;
    }
}
