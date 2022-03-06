package com.crow.encapsulation2;

/**
 * User crow7
 * Date 2021/9/5.
 */
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.setAge(age);
        this.setName(name);
    }

    public void setName(String name) {
        if (name.length() > 4) {
            //如果名字错误则取名字的前四个字母
            this.name = name.substring(0, 4);
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        if (age < 0 || age > 100) {
            this.age = 18;
        } else {
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }

    public void show() {
        System.out.println("name = " + name + "\tage = " + age);
    }

    public static void main(String[] args) {
        Person person = new Person("张三", 23);
        person.show();
    }
}
