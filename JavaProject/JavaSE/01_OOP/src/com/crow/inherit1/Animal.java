package com.crow.inherit1;

/**
 * User crow7
 * Date 2021/9/5.
 */

/**
 * 动物类，作为Dog和Cat的父类存在
 */
public class Animal {//extends Object 默认的父类就是Object，也就是什么都不写的话就相当于extends Object
    private String color;//颜色
    private int age;//年龄

    public Animal() {
    }

    public Animal(String color, int age) {
        this.age = age;
        this.color = color;
    }
    public void introduce() {
        System.out.println("coloc = " + color + "\nage = " + age );
    }


    public void eat() {
        System.out.println("eating...");
    }

    public void sleep() {
        System.out.println("leeping....");
    }
}
