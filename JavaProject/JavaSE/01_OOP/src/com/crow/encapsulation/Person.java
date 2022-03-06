package com.crow.encapsulation;

/**
 * User crow7
 * Date 2021/9/5.
 */
public class Person {
    String name;
    int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public void show() {
        System.out.println("name = " + name + "\tage = " + age);
    }

    public static void main(String[] args) {
        Person person = new Person("张三",23);
        person.show();
    }
}
