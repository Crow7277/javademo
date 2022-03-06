package com.crow.oop1;

/**
 * User crow7
 * Date 2021/9/4.
 */
/*
* 定义一个Person类
* */
public class TestPerson {
    public static void main(String[] args) {
        //张三
        //创建一个对象
        Person p1 = new Person();
        //操作属性
        p1.name = "张三";
        p1.age = 23;
        //执行方法
        p1.eat();
        p1.work();
        p1.rest("公司");

        //李四
        //创建一个对象
        Person p2 = new Person();
        //操作属性
        p2.name = "李四";
        p2.age = 24;
        //执行方法
        p2.eat();
        p2.work();
        p2.rest("宿舍");
    }
}
