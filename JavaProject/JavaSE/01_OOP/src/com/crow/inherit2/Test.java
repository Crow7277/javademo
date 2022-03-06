package com.crow.inherit2;

/**
 * User crow7
 * Date 2021/9/5.
 */
public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog("黑",3,"wangcai");
        dog.eat();
        dog.sleep();
        dog.guard();
        dog.introduce();//父类方法无法满足子类要求需要方法重写
        System.out.println(dog.toString());
    }
}
