package com.crow.inherit0;

/**
 * User crow7
 * Date 2021/9/5.
 */
public class Dog {
    private String nickName; //昵称  Dog类特有
    private String color;//颜色
    private int age;//年龄

    public void ear() {
        System.out.println("eating...");
    }

    public void sleep() {
        System.out.println("sleeping....");
    }

    public void introduce() {
        System.out.println("coloc = " + color + "\nage = " + age + "\nNickName" + nickName);
    }

    public void guard() {
        System.out.println("Dog guarding....");
    }

}
