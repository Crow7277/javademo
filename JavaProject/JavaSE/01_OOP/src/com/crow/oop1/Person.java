package com.crow.oop1;

/**
 * User crow7
 * Date 2021/9/4.
 */
/*
 * 定义一个Person类
 * 创建多个Person对象，模拟人的行为
 * */
public class Person {
    //静态特征  成员变量 名称 field   成员变量有默认值
    String name;//名字  默认值为null
    int age;//年龄   默认值为0

    //动态行为  成员方法 动词 method
    public void eat() {
        System.out.println("吃饭");
    }

    public void work() {
        System.out.println("工作");
    }

    public void rest(String site) {
        System.out.println(name + "在" + site + "休息");
    }

}
